package com.example.bank_app;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private List<Compte_bank> dataList;
    private Context context;
    public CustomAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.CustomViewHolder holder, int position) {

    }


    public CustomAdapter(Context context, List<Compte_bank> dataList){
        this.context = context;
        this.dataList = dataList;
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        public final View mView;

        TextView txtTitle;
        private ImageView coverImage;

        CustomViewHolder(View itemView) {
            super(itemView);
            mView = itemView;

            txtTitle = mView.findViewById(R.id.title);
            //coverImage = mView.findViewById(R.id.coverImage);
        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }


}
