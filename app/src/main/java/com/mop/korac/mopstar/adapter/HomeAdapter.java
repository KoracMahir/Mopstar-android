package com.mop.korac.mopstar.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mop.korac.mopstar.Home.FeedData;
import com.mop.korac.mopstar.R;

import org.w3c.dom.Text;

public class HomeAdapter  extends RecyclerView.Adapter{

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_layout, parent, false);
        return new HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((HomeViewHolder) holder).bindView(position);
    }

    @Override
    public int getItemCount() {
        return FeedData.imagespath.length;
    }

    private class HomeViewHolder extends RecyclerView.ViewHolder {
        private ImageView profileimage;
        private TextView profilename;
        private TextView timeago;
        private TextView postcontent;
        public HomeViewHolder(View view) {
            super(view);
            profileimage = (ImageView) itemView.findViewById(R.id.profileimage);
            profilename = (TextView) itemView.findViewById(R.id.profilename);
            timeago = (TextView) itemView.findViewById(R.id.timeago);
            postcontent = (TextView) itemView.findViewById(R.id.postcontent);
        }
        public void bindView(int position){
            profileimage.setImageResource(FeedData.imagespath[position]);
            profilename.setText(FeedData.names[position]);
            timeago.setText(FeedData.timesago[position]);
            postcontent.setText(FeedData.postscontent[position]);
        }
        public void onClick(View view){

        }
    }
}
