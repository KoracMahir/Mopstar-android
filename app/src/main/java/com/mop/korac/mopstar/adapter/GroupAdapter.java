package com.mop.korac.mopstar.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mop.korac.mopstar.Data.GroupData;
import com.mop.korac.mopstar.R;

public class GroupAdapter  extends RecyclerView.Adapter{

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.group_layout, parent, false);
        return new GroupViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((GroupViewHolder) holder).bindView(position);
    }

    @Override
    public int getItemCount() {
        return GroupData.names.length;
    }

    private class GroupViewHolder extends RecyclerView.ViewHolder {
        private TextView groupname;
        private TextView members;
        public GroupViewHolder(View view) {
            super(view);
            groupname = (TextView) itemView.findViewById(R.id.groupname);
            members = (TextView) itemView.findViewById(R.id.members);
        }
        public void bindView(int position){
            groupname.setText(com.mop.korac.mopstar.Data.GroupData.names[position]);
            members.setText(com.mop.korac.mopstar.Data.GroupData.members[position]);
        }
        public void onClick(View view){

        }
    }
}

