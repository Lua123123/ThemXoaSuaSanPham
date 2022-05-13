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
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.bumptech.glide.Glide;
import com.example.themxoasuasanpham.model.updateItemVariant.UpdateItemVariant;
import com.example.themxoasuasanpham.network.API;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VariantUpdateActivity extends AppCompatActivity {

    private ImageView img_back, imvVariantUp;
    private EditText etColorVarUp, etSizeVarUp, etPriceVarUp, etCostVarUp, etTotalStockVarUp, etLimitStockVarUp;
    private Button btnAddVarUp;
    private String imageEditDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_variant_update);
        imvVariantUp = findViewById(R.id.edt_image_update);
        etColorVarUp = findViewById(R.id.etColorVarUp);
        etSizeVarUp = findViewById(R.id.etSizeVarUp);
        etPriceVarUp = findViewById(R.id.etPriceVarUp);
        etCostVarUp = findViewById(R.id.etCostVarUp);
        etTotalStockVarUp = findViewById(R.id.etTotalStockVarUp);
        etLimitStockVarUp = findViewById(R.id.etLimitStockVarUp);
        btnAddVarUp = findViewById(R.id.btnAddVarUp);

        Bundle bundle = getIntent().getExtras();
        String Version = bundle.getString("Version", "default");
        String device_type = bundle.getString("device_type");
        String accept_language = bundle.getString("accept_language");
        String accept = bundle.getString("accept");
        String x_authorization = bundle.getString("x_authorization");
        String authorization = bundle.getString("authorization");
        String position = bundle.getString("position");
        imageEditDialog = bundle.getString("image");
        String color = bundle.getString("color");
        String size = bundle.getString("size");
        String cost = bundle.getString("cost");
        String price = bundle.getString("price");
        String totalStock = bundle.getString("totalStock");
        String limitStock = bundle.getString("limitStock");
        String item_id = bundle.getString("item_id");
        String id = bundle.getString("id");

        etColorVarUp.setText(color);
        etSizeVarUp.setText(size);
        etPriceVarUp.setText(price);
        etCostVarUp.setText(cost);
        etTotalStockVarUp.setText(totalStock);
        etLimitStockVarUp.setText(limitStock);
        Glide.with(this).load(imageEditDialog).into(imvVariantUp);

        imvVariantUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String editColor = etColorVarUp.getText().toString().trim();
                String editSize = etSizeVarUp.getText().toString().trim();
                String editPrice = etPriceVarUp.getText().toString().trim();
                String editCost = etCostVarUp.getText().toString().trim();
                String editTotal = etTotalStockVarUp.getText().toString().trim();
                String editLimit = etLimitStockVarUp.getText().toString().trim();
                openDialogInsertVocabulary(Gravity.CENTER);
                //, Version, device_type, accept, x_authorization, authorization,
                //                        editColor, editSize, editPrice, editCost, editTotal, editLimit, item_id, id, accept_language, position
            }
        });

        btnAddVarUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String editColor = etColorVarUp.getText().toString().trim();
                String editSize = etSizeVarUp.getText().toString().trim();
                String editPrice = etPriceVarUp.getText().toString().trim();
                String editCost = etCostVarUp.getText().toString().trim();
                String editTotal = etTotalStockVarUp.getText().toString().trim();
                String editLimit = etLimitStockVarUp.getText().toString().trim();

                openDialogUpdate(Gravity.CENTER, Version, device_type, accept, x_authorization, authorization,
                        editColor, editSize, editPrice, editCost, editTotal, editLimit, item_id, id,
                        accept_language, position);
            }
        });

        img_back = findViewById(R.id.img_back);
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VariantUpdateActivity.this, VariantListActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("Version", Version);
                bundle.putString("device_type", device_type);
                bundle.putString("accept_language", accept_language);
                bundle.putString("accept", accept);
                bundle.putString("x_authorization", x_authorization);
                bundle.putString("authorization", authorization);
                bundle.putString("position", position);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    //, String version, String device_type,String accept, String x_authorization, String authorization,
    //                                           String editColor, String editSize, String editPrice, String editCost, String editTotal, String editLimit,
    //                                           String item_id, String id, String accept_language, String position
    public void openDialogInsertVocabulary(int gravity) {
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

        EditText edt_unit_name = dialog.findViewById(R.id.edt_image_link);
        edt_unit_name.setText(imageEditDialog);
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
                imageEditDialog = edt_unit_name.getText().toString().trim();
//                updateItemVariant(version, device_type, accept, x_authorization, authorization,
//                        editColor, editSize, editPrice, editCost, editTotal, editLimit, item_id, id, imageEditDialog, accept_language, position);
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    public void openDialogUpdate(int gravity, String Version, String device_type, String accept, String x_authorization, String authorization,
                                 String editColor, String editSize, String editPrice, String editCost, String editTotal, String editLimit,
                                 String item_id, String id, String accept_language, String position) {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.layout_dialog_update_variant);
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

        ConstraintLayout btnCancel = dialog.findViewById(R.id.btn_cancelUpdate);
        ConstraintLayout btnOKUpdate = dialog.findViewById(R.id.btn_confirmUpdate);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        btnOKUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateItemVariant(Version, device_type, accept, x_authorization, authorization,
                        editColor, editSize, editPrice, editCost, editTotal, editLimit, item_id, id, imageEditDialog, accept_language, position);
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    private void updateItemVariant(String version, String device_type, String accept, String x_authorization, String authorization,
                                   String editColor, String editSize, String editPrice, String editCost, String editTotal, String editLimit,
                                   String item_id, String id, String imageEditDialog, String accept_language, String position) {
        API.api.updateItemVariant(version, device_type, accept, x_authorization, authorization,
                "1", item_id, id,
                editColor, editSize, editPrice, editCost, editTotal, editLimit, imageEditDialog).enqueue(new Callback<UpdateItemVariant>() {
            @Override
            public void onResponse(Call<UpdateItemVariant> call, Response<UpdateItemVariant> response) {
                UpdateItemVariant updateItemVariant = response.body();
                Intent intentListVariant = new Intent(VariantUpdateActivity.this, VariantListActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("Version", version);
                bundle.putString("device_type", device_type);
                bundle.putString("accept_language", accept_language);
                bundle.putString("accept", accept);
                bundle.putString("x_authorization", x_authorization);
                bundle.putString("authorization", authorization);
                bundle.putString("position", position);
                intentListVariant.putExtras(bundle);
                startActivity(intentListVariant);
            }

            @Override
            public void onFailure(Call<UpdateItemVariant> call, Throwable t) {
                Toast.makeText(VariantUpdateActivity.this, "ADD FAILED", Toast.LENGTH_SHORT).show();
            }
        });
    }
}