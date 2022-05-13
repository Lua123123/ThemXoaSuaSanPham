package com.example.themxoasuasanpham.viewmodel;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;

import com.example.themxoasuasanpham.AddProductActivity;
import com.example.themxoasuasanpham.model.addproduct.AddProduct;
import com.example.themxoasuasanpham.model.spinner.CategorySpinner;
import com.example.themxoasuasanpham.network.API;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddProductViewModel extends ViewModel {
    private Context context;

    public AddProductViewModel(Context context) {
        this.context = context;
    }

    public void addTopics(String version, String device_type, String accept_language, String accept, String x_authorization, String authorization, String productName, String description, String branch, String price, String cost, String stockLimit) {
        API.api.addProducts(version, device_type, accept_language, accept, x_authorization, authorization,
                productName, description,
                "1", "1", branch,
                price, cost, stockLimit).enqueue(new Callback<AddProduct>() {
            @Override
            public void onResponse(Call<AddProduct> call, Response<AddProduct> response) {
                AddProduct addProduct = response.body();
                Toast.makeText(context, "INSERT PRODUCTS SUCCESS", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<AddProduct> call, Throwable t) {
                Toast.makeText(context, "ADD FAILED", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public List<CategorySpinner> getListCategory(String Add1, String Add2, String Add3, String Add4, String Add5, String Add6, String Add7, String Add8, String Add9) {
        List<CategorySpinner> list = new ArrayList<>();
        list.add(new CategorySpinner(Add1));
        list.add(new CategorySpinner(Add2));
        list.add(new CategorySpinner(Add3));
        list.add(new CategorySpinner(Add4));
        list.add(new CategorySpinner(Add5));
        list.add(new CategorySpinner(Add6));
        list.add(new CategorySpinner(Add7));
        list.add(new CategorySpinner(Add8));
        list.add(new CategorySpinner(Add9));
        return list;
    }

    public List<CategorySpinner> getListCategoryUnit(String Add1, String Add2, String Add3, String Add4, String Add5, String Add6, String Add7) {
        List<CategorySpinner> listUnit = new ArrayList<>();
        listUnit.add(new CategorySpinner(Add1));
        listUnit.add(new CategorySpinner(Add2));
        listUnit.add(new CategorySpinner(Add3));
        listUnit.add(new CategorySpinner(Add4));
        listUnit.add(new CategorySpinner(Add5));
        listUnit.add(new CategorySpinner(Add6));
        listUnit.add(new CategorySpinner(Add7));
        return listUnit;
    }
}
