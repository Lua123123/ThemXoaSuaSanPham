package com.example.themxoasuasanpham.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.themxoasuasanpham.R;
import com.example.themxoasuasanpham.model.spinner.CategorySpinner;

import java.util.List;

public class CategorySpinnerAdapter extends ArrayAdapter<CategorySpinner> {

    public CategorySpinnerAdapter(@NonNull Context context, int resource, @NonNull List<CategorySpinner> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_selected, parent, false);
        TextView tvSelected = convertView.findViewById(R.id.tv_selected);

        CategorySpinner category = this.getItem(position);
        if (category != null) {
            tvSelected.setText(category.getName());
        }
        return convertView;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false);
        TextView tvCategory = convertView.findViewById(R.id.tv_category);

        CategorySpinner category = this.getItem(position);
        if (category != null) {
            tvCategory.setText(category.getName());
        }
        return convertView;
    }
}
