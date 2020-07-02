package com.codex.submission.newsstory;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContentAdapter extends RecyclerView.Adapter<ContentAdapter.ContentViewHolder> {

    private ArrayList<ContentDataModel> contentDataModels;
    private Context context;

    public ContentAdapter(ArrayList<ContentDataModel> contentDataModels, Context context) {
        this.contentDataModels = contentDataModels;
        this.context = context;
    }

    @NonNull
    @Override
    public ContentAdapter.ContentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_story_list, parent, false);
        return new ContentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContentAdapter.ContentViewHolder holder, int position) {

        ContentDataModel contentDataModel = contentDataModels.get(position);

        holder.tv_item_title.setText(contentDataModel.getContentTitle());
        holder.tv_item_total_comment.setText(String.valueOf(contentDataModel.getContentTotalComments()));
        holder.tv_item_score.setText(String.valueOf(contentDataModel.getContentScore()));
    }

    @Override
    public int getItemCount() {
        return contentDataModels.size();
    }

    public class ContentViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_item_title, tv_item_total_comment, tv_item_score;

        public ContentViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_item_title = itemView.findViewById(R.id.tvItemTitle);
            tv_item_total_comment = itemView.findViewById(R.id.tvItemComment);
            tv_item_score = itemView.findViewById(R.id.tvItemScore);
        }
    }
}
