package com.example.themxoasuasanpham.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.themxoasuasanpham.R;
import com.example.themxoasuasanpham.VariantListActivity;
import com.example.themxoasuasanpham.VariantUpdateActivity;
import com.example.themxoasuasanpham.model.itemlistvariant.SuccessItemVariant;
import com.example.themxoasuasanpham.model.product.SuccessProduct;

import java.util.ArrayList;
import java.util.List;

public class VariantListItemAdapter extends RecyclerView.Adapter<VariantListItemAdapter.ViewHolder> {
    private List<SuccessItemVariant> mListVocabulary;
    private List<SuccessItemVariant> mListVocabularyOld;
    private Context context;

    private String Version;
    private String device_type;
    private String accept_language;
    private String accept;
    private String x_authorization;
    private String authorization;
    private String positionBundle;

    public void setData(List<SuccessItemVariant> mListVocabulary) {
        this.mListVocabulary = mListVocabulary;
        this.mListVocabularyOld = mListVocabulary;
        notifyDataSetChanged();

    }

    public VariantListItemAdapter(Context context, String Version, String device_type, String accept_language, String accept, String x_authorization, String authorization, String positionBundle) {
        this.context = context;
        this.Version = Version;
        this.device_type = device_type;
        this.accept_language = accept_language;
        this.accept = accept;
        this.x_authorization = x_authorization;
        this.authorization = authorization;
        this.positionBundle = positionBundle;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_variant_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        SuccessItemVariant successItemVariant = mListVocabulary.get(position);
        String image = mListVocabulary.get(position).getImageVariant();
        String color = mListVocabulary.get(position).getColorVariant();
        String size = mListVocabulary.get(position).getSizeVariant().toString();
        String price = mListVocabulary.get(position).getPriceVariant().toString();
        String cost = "50000";
        String totalStock = mListVocabulary.get(position).getTotalStockVariant();
        String limitStock = mListVocabulary.get(position).getCartStockVariant();

        String item_id = mListVocabulary.get(position).getItem_id();
        String id = mListVocabulary.get(position).getId();

        if (successItemVariant == null) {
            return;
        }
        if (successItemVariant != null || mListVocabulary != null) {
            holder.tv_nameProduct.setText(mListVocabulary.get(position).getNameVariant());
            holder.tv_price.setText(mListVocabulary.get(position).getPriceVariant().toString());
            holder.tv_total_stock.setText(mListVocabulary.get(position).getTotalStockVariant().toString());
            holder.tv_cart_stock.setText(mListVocabulary.get(position).getCartStockVariant().toString());
            holder.tv_size.setText(mListVocabulary.get(position).getSizeVariant().toString());
            holder.tv_color.setText(mListVocabulary.get(position).getColorVariant().toString());
            Glide.with(context).load(mListVocabulary.get(position).getImageVariant()).into(holder.img_product_variant);

            holder.layout_edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, VariantUpdateActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("Version", Version);
                    bundle.putString("device_type", device_type);
                    bundle.putString("accept_language", accept_language);
                    bundle.putString("accept", accept);
                    bundle.putString("x_authorization", x_authorization);
                    bundle.putString("authorization", authorization);
                    bundle.putString("position", positionBundle);

                    bundle.putString("image", image);
                    bundle.putString("color", color);
                    bundle.putString("size", size);
                    bundle.putString("cost", cost);
                    bundle.putString("price", price);
                    bundle.putString("totalStock", totalStock);
                    bundle.putString("limitStock", limitStock);
                    bundle.putString("item_id", item_id);
                    bundle.putString("id", id);

                    intent.putExtras(bundle);
                    context.startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        if (mListVocabulary != null) {
            return mListVocabulary.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout layout_item, layout_edit;
        private ImageView img_product_variant;
        private TextView tv_nameProduct;
        private TextView tv_price;
        private ImageView img_edit;
        private TextView tv_total_stock;
        private TextView tv_cart_stock;
        private TextView tv_size;
        private TextView tv_color;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img_edit = itemView.findViewById(R.id.img_edit);
            layout_item = itemView.findViewById(R.id.layout_item);
            layout_edit = itemView.findViewById(R.id.layout_edit);
            tv_nameProduct = itemView.findViewById(R.id.tv_nameProduct);
            tv_price = itemView.findViewById(R.id.tv_price);
            tv_total_stock = itemView.findViewById(R.id.tv_total_stock);
            tv_cart_stock = itemView.findViewById(R.id.tv_cart_stock);
            tv_size = itemView.findViewById(R.id.tv_size);
            tv_color = itemView.findViewById(R.id.tv_color);
            img_product_variant = itemView.findViewById(R.id.img_product_variant);
        }
    }

    public void release() {
        context = null;
    }

//    @Override
//    public Filter getFilter() {
//        return new Filter() {
//            @Override
//            protected FilterResults performFiltering(CharSequence charSequence) {
//                String strSearch = charSequence.toString();
//                if (strSearch.isEmpty()) {
//                    mListVocabulary = mListVocabularyOld;
//                } else {
//                    List<SuccessProduct> list = new ArrayList<>();
//                    for (SuccessProduct successProduct : mListVocabularyOld) {
//                        if (successProduct.getNameProduct().toLowerCase().contains(strSearch.toLowerCase())) {
//                            list.add(successProduct);
//                        }
//                    }
//                    mListVocabulary = list;
//                }
//                FilterResults filterResults = new FilterResults();
//                filterResults.values = mListVocabulary;
//                return filterResults;
//            }
//
//            @Override
//            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
//                mListVocabulary = (List<SuccessProduct>) filterResults.values;
//                notifyDataSetChanged();
//            }
//        };
//    }
}
