package com.example.headphonesapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    private List<MainModel> mainModelList;

    MainAdapter(List<MainModel> mainModelList) {
        this.mainModelList = mainModelList;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MainViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.head_phone_items, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        holder.imageView.setImageResource(mainModelList.get(position).getImages());
    }

    @Override
    public int getItemCount() {
        return mainModelList.size();
    }

    public class MainViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;

        MainViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageItem);
        }
    }

}
