package com.mop.korac.mopstar.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mop.korac.mopstar.Data.EventData;
import com.mop.korac.mopstar.R;

public class EventAdapter extends RecyclerView.Adapter{

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_layout, parent, false);
        return new EventAdapter.EventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((EventAdapter.EventViewHolder) holder).bindView(position);
    }

    @Override
    public int getItemCount() {
        return EventData.eventname.length;
    }

    private class EventViewHolder extends RecyclerView.ViewHolder {
        private TextView eventname;
        private TextView date;
        public EventViewHolder(View view) {
            super(view);
            eventname = (TextView) itemView.findViewById(R.id.eventname);
            date = (TextView) itemView.findViewById(R.id.date);
        }
        public void bindView(int position){
            eventname.setText(com.mop.korac.mopstar.Data.EventData.eventname[position]);
            date.setText(com.mop.korac.mopstar.Data.EventData.date[position]);
        }
        public void onClick(View view){

        }
    }
}
