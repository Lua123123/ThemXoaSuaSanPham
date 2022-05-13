package com.example.themxoasuasanpham;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.themxoasuasanpham.adapter.ListItemProductAdapter;
import com.example.themxoasuasanpham.adapter.VariantListItemAdapter;
import com.example.themxoasuasanpham.model.createunit.UnitCreate;
import com.example.themxoasuasanpham.model.itemlistvariant.ItemListVariant;
import com.example.themxoasuasanpham.model.itemlistvariant.SuccessItemVariant;
import com.example.themxoasuasanpham.model.product.SuccessProduct;
import com.example.themxoasuasanpham.network.API;
import com.example.themxoasuasanpham.viewmodel.VariantListViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VariantListActivity extends AppCompatActivity {

    private LinearLayout layoutAddVariant;
    private ImageView img_back;

    private List<SuccessItemVariant> mListVocabulary = new ArrayList<>();
    private RecyclerView recyclerView;
    private VariantListItemAdapter adapter;
    private LinearLayoutManager layoutManager;
    private Context context = VariantListActivity.this;
    private VariantListViewModel variantListViewModel;

//    private String Version = "1.0.0";
//    private String device_type = "1";
//    private String accept_language = "en";
//    private String accept = "application/json";
//    private String x_authorization = "c27bf764096fe14c662232bbd9fbb837";
//    private String authorization = "$2y$10$Rpf0rqnvMEK0NLJiT7VrruYIne3/OdVJHhiKtnFRKEFvr6y1Lbnmq";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_variant_list);

        recyclerView = findViewById(R.id.rcvVariantList);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        Bundle bundle = getIntent().getExtras();
        String Version = bundle.getString("Version", "default");
        String device_type = bundle.getString("device_type");
        String accept_language = bundle.getString("accept_language");
        String accept = bundle.getString("accept");
        String x_authorization = bundle.getString("x_authorization");
        String authorization = bundle.getString("authorization");
        String position = bundle.getString("position");

        adapter = new VariantListItemAdapter(context, Version, device_type, accept_language, accept, x_authorization, authorization, position);
        recyclerView.setAdapter(adapter);

        variantListViewModel = new VariantListViewModel(context, mListVocabulary, recyclerView, adapter);
        layoutAddVariant = findViewById(R.id.layout3);
        layoutAddVariant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                variantListViewModel.getItemVariantItem(Version, device_type, accept_language, accept, x_authorization, authorization, position);

            }
        });

        img_back = findViewById(R.id.img_back);
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(VariantListActivity.this, ProductActivity.class);
                startActivity(intent3);
            }
        });

        variantListViewModel.getItemVariant(Version, device_type, accept_language, accept, x_authorization, authorization, position);
    }

}