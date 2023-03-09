package com.example.booklibrary;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.booklibrary.databinding.RowCategoryUserBinding;

import java.util.ArrayList;

public class AdapterCategoryUser extends RecyclerView.Adapter<AdapterCategoryUser.HolderCategoryUser> implements Filterable {

    private Context context;
    public ArrayList<ModelCategory> categoryArrayList, filterList;

    private RowCategoryUserBinding binding;

    private FilterCategoryUser filter;

    public AdapterCategoryUser(Context context, ArrayList<ModelCategory> categoryArrayList) {
        this.context = context;
        this.categoryArrayList = categoryArrayList;
        this.filterList = categoryArrayList;

    }

    @NonNull
    @Override
    public HolderCategoryUser onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = RowCategoryUserBinding.inflate(LayoutInflater.from(context), parent, false);

        return new HolderCategoryUser(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull HolderCategoryUser holder, int position) {
        ModelCategory model = categoryArrayList.get(position);
        String id = model.getId();
        String categoryName = model.getCategoryName();
        String uid = model.getUid();
        long timestamp = model.getTimestamp();

        holder.categoryTxt.setText(categoryName);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ListPdfUserActivity.class);
                intent.putExtra("categoryId", id);
                intent.putExtra("categoryTitle", categoryName);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryArrayList.size();
    }

    @Override
    public Filter getFilter() {
        if (filter == null) {
            filter = new FilterCategoryUser(filterList, this);
        }
        return filter;
    }

    class HolderCategoryUser extends RecyclerView.ViewHolder {

        TextView categoryTxt;

        public HolderCategoryUser(@NonNull View itemView) {
            super(itemView);

            categoryTxt = binding.categoryTxt;
        }
    }
}
