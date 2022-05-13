package com.example.themxoasuasanpham.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.example.themxoasuasanpham.model.product.Success;
import com.example.themxoasuasanpham.model.product.SuccessProduct;

import java.util.ArrayList;
import java.util.List;

public class ListItemProductAdapter extends RecyclerView.Adapter<ListItemProductAdapter.ViewHolder> implements Filterable {
    private List<SuccessProduct> mListVocabulary;
    private List<SuccessProduct> mListVocabularyOld;
    private Context context;

    private String Version;
    private String device_type;
    private String accept_language;
    private String accept;
    private String x_authorization;
    private String authorization;

    public void setData(List<SuccessProduct> mListVocabulary) {
        this.mListVocabulary = mListVocabulary;
        this.mListVocabularyOld = mListVocabulary;
        notifyDataSetChanged();

    }

    public ListItemProductAdapter(Context context, String Version, String device_type, String accept_language,
                                  String accept, String x_authorization, String authorization) {
        this.context = context;
        this.Version = Version;
        this.device_type = device_type;
        this.accept_language = accept_language;
        this.accept = accept;
        this.x_authorization = x_authorization;
        this.authorization = authorization;

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_product_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        SuccessProduct successProduct = mListVocabulary.get(position);
        if (successProduct == null) {
            return;
        }
        if (successProduct != null || mListVocabulary != null ) {
            holder.tv_nameProduct.setText(mListVocabulary.get(position).getNameProduct());
            holder.tv_category.setText(mListVocabulary.get(position).getCateName());
            holder.tv_amountVariants.setText(mListVocabulary.get(position).getVariantCount().toString());
            holder.tv_price.setText(mListVocabulary.get(position).getPrice().toString());
            Glide.with(context).load(mListVocabulary.get(position).getImageProduct()).into(holder.img_product);


//            String word = mListVocabulary.get(position).getWord();
//            String mean = mListVocabulary.get(position).getMean();
            holder.layout_item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, VariantListActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("Version", Version);
                    bundle.putString("device_type", device_type);
                    bundle.putString("accept_language", accept_language);
                    bundle.putString("accept", accept);
                    bundle.putString("x_authorization", x_authorization);
                    bundle.putString("authorization", authorization);
                    bundle.putString("position", String.valueOf(position + 1));
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

        private LinearLayout layout_item;
        private ImageView img_product;
        private TextView tv_nameProduct;
        private TextView tv_category;
        private TextView tv_amountVariants;
        private TextView tv_price;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            layout_item = itemView.findViewById(R.id.layout_item);
            tv_nameProduct = itemView.findViewById(R.id.tv_nameProduct);
            tv_category = itemView.findViewById(R.id.tv_category);
            tv_amountVariants = itemView.findViewById(R.id.tv_amountVariants);
            tv_price = itemView.findViewById(R.id.tv_price);
            img_product = itemView.findViewById(R.id.img_product);
        }
    }

    public void release() {
        context = null;
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String strSearch = charSequence.toString();
                if (strSearch.isEmpty()) {
                    mListVocabulary = mListVocabularyOld;
                } else {
                    List<SuccessProduct> list = new ArrayList<>();
                    for (SuccessProduct successProduct : mListVocabularyOld) {
                        if (successProduct.getNameProduct().toLowerCase().contains(strSearch.toLowerCase())) {
                            list.add(successProduct);
                        }
                    }
                    mListVocabulary = list;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = mListVocabulary;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                mListVocabulary = (List<SuccessProduct>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }
}
