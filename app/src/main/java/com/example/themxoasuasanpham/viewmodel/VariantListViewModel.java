package com.example.themxoasuasanpham.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

import com.example.themxoasuasanpham.VariantAddActivity;
import com.example.themxoasuasanpham.VariantListActivity;
import com.example.themxoasuasanpham.adapter.VariantListItemAdapter;
import com.example.themxoasuasanpham.model.itemlistvariant.ItemListVariant;
import com.example.themxoasuasanpham.model.itemlistvariant.SuccessItemVariant;
import com.example.themxoasuasanpham.network.API;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VariantListViewModel extends ViewModel {
    private Context context;
    private List<SuccessItemVariant> mListVocabulary;
    private RecyclerView recyclerView;
    private VariantListItemAdapter adapter;

    public VariantListViewModel(Context context, List<SuccessItemVariant> mListVocabulary, RecyclerView recyclerView, VariantListItemAdapter adapter) {
        this.context = context;
        this.mListVocabulary = mListVocabulary;
        this.recyclerView = recyclerView;
        this.adapter = adapter;
    }

    public void getItemVariant(String version, String device_type, String accept_language, String accept,
                               String x_authorization, String authorization, String position) {
        API.api.getItemVariant(version, device_type, accept_language, accept, x_authorization, authorization, "1", position).enqueue(new Callback<ItemListVariant>() {
            @Override
            public void onResponse(Call<ItemListVariant> call, Response<ItemListVariant> response) {
                ItemListVariant itemListVariant = response.body();
                for (int i = 0; i < itemListVariant.getData().size(); i++) {
                    SuccessItemVariant successItemVariant = new SuccessItemVariant(
                            itemListVariant.getData().get(i).getItemName(),
                            itemListVariant.getData().get(i).getPrice().toString(),
                            itemListVariant.getData().get(i).getTotalStock().toString(),
                            itemListVariant.getData().get(i).getStockLimit().toString(),
                            itemListVariant.getData().get(i).getSize(),
                            itemListVariant.getData().get(i).getColor(),
                            itemListVariant.getData().get(i).getImage(),
                            itemListVariant.getData().get(i).getItemId().toString(),
                            itemListVariant.getData().get(i).getId().toString());
                    mListVocabulary.add(successItemVariant);
                    adapter.setData(mListVocabulary);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<ItemListVariant> call, Throwable t) {
                Toast.makeText(context, "LOAD DATA ITEM VARIANT FAILED", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void getItemVariantItem(String version, String device_type, String accept_language, String accept,
                               String x_authorization, String authorization, String position) {
        API.api.getItemVariant(version, device_type, accept_language, accept, x_authorization, authorization, "1", position).enqueue(new Callback<ItemListVariant>() {
            @Override
            public void onResponse(Call<ItemListVariant> call, Response<ItemListVariant> response) {
                ItemListVariant itemListVariant = response.body();
                for (int i = 0; i < itemListVariant.getData().size(); i++) {
                    SuccessItemVariant successItemVariant = new SuccessItemVariant(
                            itemListVariant.getData().get(i).getItemName(),
                            itemListVariant.getData().get(i).getPrice().toString(),
                            itemListVariant.getData().get(i).getTotalStock().toString(),
                            itemListVariant.getData().get(i).getStockLimit().toString(),
                            itemListVariant.getData().get(i).getSize(),
                            itemListVariant.getData().get(i).getColor(),
                            itemListVariant.getData().get(i).getImage(),
                            itemListVariant.getData().get(i).getItemId().toString(),
                            itemListVariant.getData().get(i).getId().toString());
                    Intent intent = new Intent(context, VariantAddActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("successItemVariant", successItemVariant);

                    bundle.putString("Version", version);
                    bundle.putString("device_type", device_type);
                    bundle.putString("accept_language", accept_language);
                    bundle.putString("accept", accept);
                    bundle.putString("x_authorization", x_authorization);
                    bundle.putString("authorization", authorization);
                    bundle.putString("position", position);

                    intent.putExtras(bundle);
                    context.startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<ItemListVariant> call, Throwable t) {
                Toast.makeText(context, "LOAD DATA ITEM VARIANT FAILED", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
