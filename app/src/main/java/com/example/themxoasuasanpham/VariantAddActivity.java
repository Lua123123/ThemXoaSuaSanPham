package com.example.themxoasuasanpham;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.themxoasuasanpham.model.createunit.UnitCreate;
import com.example.themxoasuasanpham.model.itemlistvariant.SuccessItemVariant;
import com.example.themxoasuasanpham.model.updateItemVariant.UpdateItemVariant;
import com.example.themxoasuasanpham.network.API;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Field;

public class VariantAddActivity extends AppCompatActivity {

    private Button btnPrev, btnAddVar;
    private EditText etColorVar, etSizeVar, etPriceVar, etCostVar, etTotalStockVar, etLimitStockVar;
    private ImageView imvVariant;
    private String imageLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_variant_add);
        etColorVar = findViewById(R.id.etColorVar);
        etSizeVar = findViewById(R.id.etSizeVar);
        etPriceVar = findViewById(R.id.etPriceVar);
        etCostVar = findViewById(R.id.etCostVar);
        etTotalStockVar = findViewById(R.id.etTotalStockVar);
        etLimitStockVar = findViewById(R.id.etLimitStockVar);

        Bundle bundle = getIntent().getExtras();
        SuccessItemVariant successItemVariant = (SuccessItemVariant) bundle.getSerializable("successItemVariant");
        String item_id = successItemVariant.getItem_id();
        String Version = bundle.getString("Version");
        String device_type = bundle.getString("device_type");
        String accept_language = bundle.getString("accept_language");
        String accept = bundle.getString("accept");
        String x_authorization = bundle.getString("x_authorization");
        String authorization = bundle.getString("authorization");
        String position = bundle.getString("position");

        btnAddVar = findViewById(R.id.btnAddVar);
        btnAddVar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intentPre = new Intent(VariantAddActivity.this, VariantListActivity.class);
//                startActivity(intentPre);
                String color = etColorVar.getText().toString().trim();
                String size = etSizeVar.getText().toString().trim();
                String price = etPriceVar.getText().toString().trim();
                String cost = etCostVar.getText().toString().trim();
                String total = etTotalStockVar.getText().toString().trim();
                String limit = etLimitStockVar.getText().toString().trim();
                createItemVariant(Version, device_type, accept, x_authorization, authorization, item_id,
                        color, size, price, cost, total, limit, imageLink, accept_language, position);
            }
        });

        imvVariant = findViewById(R.id.imvVariant);
        imvVariant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String color = etColorVar.getText().toString().trim();
                String size = etSizeVar.getText().toString().trim();
                String price = etPriceVar.getText().toString().trim();
                String cost = etCostVar.getText().toString().trim();
                String total = etTotalStockVar.getText().toString().trim();
                String limit = etLimitStockVar.getText().toString().trim();
                openDialogInsertVocabulary(Gravity.CENTER, Version, device_type, accept, x_authorization, authorization, item_id,
                        color, size, price, cost, total, limit);
            }
        });

        btnPrev = findViewById(R.id.btnPrev);
        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentPre = new Intent(VariantAddActivity.this, VariantListActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("Version", Version);
                bundle.putString("device_type", device_type);
                bundle.putString("accept_language", accept_language);
                bundle.putString("accept", accept);
                bundle.putString("x_authorization", x_authorization);
                bundle.putString("authorization", authorization);
                bundle.putString("position", position);
                intentPre.putExtras(bundle);
                startActivity(intentPre);
            }
        });

    }

    public void openDialogInsertVocabulary(int gravity, String version, String device_type, String accept, String x_authorization, String authorization, String item_id,
                                           String color, String size, String price, String cost, String total, String limit) {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_custom_image);
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

        EditText edt_image_link = dialog.findViewById(R.id.edt_image_link);
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
                imageLink = edt_image_link.getText().toString().trim();
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    private void createItemVariant(String version, String device_type, String accept, String x_authorization, String authorization, String item_id,
                                   String color, String size, String price, String cost, String total, String limit, String imageLink, String accept_language, String position) {
        API.api.createItemVariant(version, device_type, accept, x_authorization, authorization,
                "1", item_id, color, size, price, cost, total, limit, imageLink).enqueue(new Callback<UpdateItemVariant>() {
            @Override
            public void onResponse(Call<UpdateItemVariant> call, Response<UpdateItemVariant> response) {
                UpdateItemVariant updateItemVariant = response.body();
                Intent intent2 = new Intent(VariantAddActivity.this, VariantListActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("Version", version);
                bundle.putString("device_type", device_type);
                bundle.putString("accept_language", accept_language);
                bundle.putString("accept", accept);
                bundle.putString("x_authorization", x_authorization);
                bundle.putString("authorization", authorization);
                bundle.putString("position", position);
                intent2.putExtras(bundle);
                startActivity(intent2);
            }

            @Override
            public void onFailure(Call<UpdateItemVariant> call, Throwable t) {
                Toast.makeText(VariantAddActivity.this, "ADD FAILED", Toast.LENGTH_SHORT).show();
            }
        });
    }

}