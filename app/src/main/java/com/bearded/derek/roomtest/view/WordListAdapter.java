package com.bearded.derek.roomtest.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bearded.derek.roomtest.R;
import com.bearded.derek.roomtest.model.Word;

import java.util.List;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.ViewHolder> {

    class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView wordView;

        private ViewHolder(View itemView) {
            super(itemView);
            wordView = itemView.findViewById(R.id.textView);
        }
    }

    private final LayoutInflater inflater;
    private List<Word> words; // cached copy of words


    public WordListAdapter(Context context) {
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public WordListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.recyclerview_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull WordListAdapter.ViewHolder holder, int position) {
        if (words != null) {
            Word current = words.get(position);
            holder.wordView.setText(current.getWord());
        } else {
            holder.wordView.setText("No Word");
        }
    }

    public void setWords(List<Word> words) {
        this.words = words;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        if (words != null) {
            return words.size();
        } else return 0;
    }
}
