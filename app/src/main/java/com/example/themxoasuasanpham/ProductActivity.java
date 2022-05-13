package com.example.themxoasuasanpham;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.themxoasuasanpham.adapter.ListItemProductAdapter;
import com.example.themxoasuasanpham.model.product.Success;
import com.example.themxoasuasanpham.model.product.SuccessProduct;
import com.example.themxoasuasanpham.network.API;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductActivity extends AppCompatActivity {

    private List<SuccessProduct> mListVocabulary = new ArrayList<>();
    private RecyclerView recyclerView;
    private ListItemProductAdapter adapter;
    private LinearLayoutManager layoutManager;
    private Context context = ProductActivity.this;

    private ConstraintLayout constraint_category;
    private LinearLayout addProduct;

    private String Version = "1.0.0";
    private String device_type = "1";
    private String accept_language = "en";
    private String accept = "application/json";
    private String x_authorization = "c27bf764096fe14c662232bbd9fbb837";
    private String authorization = "$2y$10$Rpf0rqnvMEK0NLJiT7VrruYIne3/OdVJHhiKtnFRKEFvr6y1Lbnmq";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new ListItemProductAdapter(context, Version, device_type, accept_language, accept, x_authorization, authorization);
        recyclerView.setAdapter(adapter);

        constraint_category = findViewById(R.id.constraint_category);
        constraint_category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProductActivity.this, CategoryActivity.class);
                startActivity(intent);
            }
        });

        addProduct = findViewById(R.id.layout3);
        addProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(ProductActivity.this, AddProductActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("Version", Version);
                bundle.putString("device_type", device_type);
                bundle.putString("accept_language", accept_language);
                bundle.putString("accept", accept);
                bundle.putString("x_authorization", x_authorization);
                bundle.putString("authorization", authorization);
                intent2.putExtras(bundle);
                startActivity(intent2);
            }
        });

        callListItem();
    }

    private void callListItem() {

        API.api.getItem(Version, device_type, accept_language, accept, x_authorization, authorization).enqueue(new Callback<Success>() {
            @Override
            public void onResponse(Call<Success> call, Response<Success> response) {
                Success success = response.body();

                for (int i = 0; i < success.getData().size(); i++) {
                    if (success.getData().get(i).getMainImage() != null) {
                        SuccessProduct successProduct = new SuccessProduct(
                                success.getData().get(i).getItemName(),
                                success.getData().get(i).getCategory().getCateName(),
                                success.getData().get(i).getItemVariantsCount().toString(),
                                success.getData().get(i).getPrice().toString(),
                                success.getData().get(i).getMainImage().toString());
                        mListVocabulary.add(successProduct);
                        adapter.setData(mListVocabulary);
                        recyclerView.setAdapter(adapter);
                    }
                }
            }

            @Override
            public void onFailure(Call<Success> call, Throwable t) {
                Toast.makeText(ProductActivity.this, "CALL FAILED", Toast.LENGTH_SHORT).show();
            }
        });
    }

//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        menuInflater.inflate(R.menu.search, menu)
//        val searchManager = getSystemService(SEARCH_SERVICE) as SearchManager
//        searchView = menu.findItem(R.id.action_search).actionView as SearchView
//        searchView!!.setSearchableInfo(searchManager.getSearchableInfo(componentName))
//        searchView!!.maxWidth = Int.MAX_VALUE
//        searchView!!.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
//            override fun onQueryTextSubmit(s: String): Boolean {
//                adapter!!.filter.filter(s)
//                return false
//            }
//
//            override fun onQueryTextChange(s: String): Boolean {
//                adapter!!.filter.filter(s)
//                return false
//            }
//        })
//        return true
//    }
}