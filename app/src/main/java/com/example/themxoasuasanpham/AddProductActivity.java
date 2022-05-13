package com.example.themxoasuasanpham;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.themxoasuasanpham.adapter.CategorySpinnerAdapter;
import com.example.themxoasuasanpham.adapter.UnitSpinnerAdapter;
import com.example.themxoasuasanpham.model.category.CategorySpinnerProduct;
import com.example.themxoasuasanpham.model.createunit.UnitCreate;
import com.example.themxoasuasanpham.model.spinner.CategorySpinner;
import com.example.themxoasuasanpham.model.addproduct.AddProduct;
import com.example.themxoasuasanpham.model.unit.UnitSpinner;
import com.example.themxoasuasanpham.network.API;
import com.example.themxoasuasanpham.viewmodel.AddProductViewModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddProductActivity extends AppCompatActivity {

    private Context context = AddProductActivity.this;
    private ImageView img_back;
    private Spinner spnCategory, spnCategoryUnit;
    private CategorySpinnerAdapter categoryAdapter;
    private UnitSpinnerAdapter unitAdapter;
    private ImageView img_add;
    private ImageView img_product;
    private EditText edt_productName, edt_description, edt_branch, edt_cost, edt_price, edt_stock_limit;
    private Button btn_addProduct;
    private AddProductViewModel addProductViewModel = new AddProductViewModel(context);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        edt_productName = findViewById(R.id.edt_productName);
        edt_description = findViewById(R.id.edt_description);
        edt_branch = findViewById(R.id.edt_branch);
        edt_price = findViewById(R.id.edt_price);
        edt_cost = findViewById(R.id.edt_cost);
        img_product = findViewById(R.id.img_product);
        edt_stock_limit = findViewById(R.id.edt_stock_limit);
        btn_addProduct = findViewById(R.id.btn_addProduct);
        spnCategory = findViewById(R.id.spn_category);

        spnCategoryUnit = findViewById(R.id.spn_categoryUnit);
        spnCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(AddProductActivity.this, categoryAdapter.getItem(i).getName(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spnCategoryUnit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(AddProductActivity.this, unitAdapter.getItem(i).getName(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        img_back = findViewById(R.id.img_back);
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddProductActivity.this, ProductActivity.class);
                startActivity(intent);
            }
        });

        Bundle bundle = getIntent().getExtras();
        String Version = bundle.getString("Version", "default");
        String device_type = bundle.getString("device_type");
        String accept_language = bundle.getString("accept_language");
        String accept = bundle.getString("accept");
        String x_authorization = bundle.getString("x_authorization");
        String authorization = bundle.getString("authorization");

        btn_addProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String productName = edt_productName.getText().toString();
                String description = edt_description.getText().toString();
                String branch = edt_branch.getText().toString();
                String price = edt_price.getText().toString();
                String cost = edt_cost.getText().toString();
                String stockLimit = edt_stock_limit.getText().toString();
                addProductViewModel.addTopics(Version, device_type, accept_language, accept, x_authorization, authorization,
                        productName, description, branch, price, cost, stockLimit);
                Intent intentProduct = new Intent(AddProductActivity.this, ProductActivity.class);
                startActivity(intentProduct);
            }
        });

        img_add = findViewById(R.id.img_add);
        img_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialogInsertVocabulary(Gravity.CENTER, Version, device_type, accept_language, accept, x_authorization, authorization);
            }
        });

        getUnit(Version, device_type, accept_language, accept, x_authorization, authorization);
        getCategory(Version, device_type, accept_language, accept, x_authorization, authorization);
    }

    private void getCategory(String version, String device_type, String accept_language, String accept, String x_authorization, String authorization) {
        API.api.getCategory(version, device_type, accept_language, accept, x_authorization, authorization).enqueue(new Callback<CategorySpinnerProduct>() {
            @Override
            public void onResponse(Call<CategorySpinnerProduct> call, Response<CategorySpinnerProduct> response) {
                CategorySpinnerProduct categorySpinnerProduct = response.body();
                String Add1 = categorySpinnerProduct.getData().get(0).getCateName();
                String Add2 = categorySpinnerProduct.getData().get(1).getCateName();
                String Add3 = categorySpinnerProduct.getData().get(2).getCateName();
                String Add4 = categorySpinnerProduct.getData().get(3).getCateName();
                String Add5 = categorySpinnerProduct.getData().get(4).getCateName();
                String Add6 = categorySpinnerProduct.getData().get(5).getCateName();
                String Add7 = categorySpinnerProduct.getData().get(6).getCateName();
                String Add8 = categorySpinnerProduct.getData().get(7).getCateName();
                String Add9 = categorySpinnerProduct.getData().get(8).getCateName();
                categoryAdapter = new CategorySpinnerAdapter(AddProductActivity.this, R.layout.item_selected, addProductViewModel.getListCategory(Add1, Add2, Add3, Add4, Add5, Add6, Add7, Add8, Add9));
                spnCategory.setAdapter(categoryAdapter);
            }

            @Override
            public void onFailure(Call<CategorySpinnerProduct> call, Throwable t) {
                Toast.makeText(AddProductActivity.this, "GET FAILED", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getUnit(String version, String device_type, String accept_language, String accept, String x_authorization, String authorization) {
        API.api.getUnit(version, device_type, accept_language, accept, x_authorization, authorization).enqueue(new Callback<UnitSpinner>() {
            @Override
            public void onResponse(Call<UnitSpinner> call, Response<UnitSpinner> response) {
                UnitSpinner unitSpinner = response.body();
                String Add1 = unitSpinner.getData().get(0).getUnitName();
                String Add2 = unitSpinner.getData().get(1).getUnitName();
                String Add3 = unitSpinner.getData().get(2).getUnitName();
                String Add4 = unitSpinner.getData().get(3).getUnitName();
                String Add5 = unitSpinner.getData().get(4).getUnitName();
                String Add6 = unitSpinner.getData().get(5).getUnitName();
                String Add7 = unitSpinner.getData().get(6).getUnitName();

                unitAdapter = new UnitSpinnerAdapter(AddProductActivity.this, R.layout.item_selected, addProductViewModel.getListCategoryUnit(Add1, Add2, Add3, Add4, Add5, Add6, Add7));
                spnCategoryUnit.setAdapter(unitAdapter);
            }

            @Override
            public void onFailure(Call<UnitSpinner> call, Throwable t) {
                Toast.makeText(AddProductActivity.this, "GET FAILED", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void openDialogInsertVocabulary(int gravity, String version, String device_type, String accept_language, String accept, String x_authorization, String authorization) {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_custom_unit);
        Window window = dialog.getWindow();
        if (window == null) {
            return;
        }
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        WindowManager.LayoutParams windowAttributes = window.getAttributes();
        windowAttributes.gravity = gravity;
        window.setAttributes(windowAttributes);

        if (Gravity.CENTER == gravity) {
            dialog.setCancelable(true);
        } else {
            dialog.setCancelable(false);
        }

        EditText edt_unit_name = dialog.findViewById(R.id.edt_unit_name);
        ConstraintLayout btnCancel = dialog.findViewById(R.id.btn_cancel);
        ConstraintLayout btnConfirm = dialog.findViewById(R.id.btn_confirm);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String unitName = edt_unit_name.getText().toString().trim();
                createUnit(version, device_type, accept_language, accept, x_authorization, authorization, unitName);
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    private void createUnit(String version, String device_type, String accept_language, String accept, String x_authorization, String authorization, String unitName) {
        API.api.createUnit(version, device_type, accept_language, accept, x_authorization, authorization, unitName).enqueue(new Callback<UnitCreate>() {
            @Override
            public void onResponse(Call<UnitCreate> call, Response<UnitCreate> response) {
                UnitCreate unitCreate = response.body();
                Toast.makeText(AddProductActivity.this, "INSERT PRODUCTS SUCCESS", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<UnitCreate> call, Throwable t) {
                Toast.makeText(AddProductActivity.this, "ADD FAILED", Toast.LENGTH_SHORT).show();
            }
        });
    }
}