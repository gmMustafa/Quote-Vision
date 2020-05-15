package com.gmmustafa.rxjava.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gmmustafa.rxjava.R;
import com.gmmustafa.rxjava.models.Quote;

import java.util.List;

public class QuoteAdapter extends RecyclerView.Adapter<QuoteAdapter.RepoViewHolder> {

    private List<Quote> dataset;

    public QuoteAdapter(List<Quote> dataset) {
        this.dataset = dataset;
    }

    @NonNull
    @Override
    public RepoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.quote_list_item, parent, false);
        return new RepoViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull RepoViewHolder holder, int position) {
        holder.text.setText(dataset.get(position).getText());
        if (dataset.get(position).getAuthor() != null) {
            if (dataset.get(position).getAuthor().equals("")) {
                holder.author.setText("Unknown");
            } else {
                holder.author.setText(dataset.get(position).getAuthor());
            }
        }
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public static class RepoViewHolder extends RecyclerView.ViewHolder {
        TextView text;
        TextView author;

        public RepoViewHolder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.text);
            author = itemView.findViewById(R.id.author);
        }
    }
}
