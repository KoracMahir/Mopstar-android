package com.mop.korac.mopstar.fragments.profile;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mop.korac.mopstar.R;
import com.mop.korac.mopstar.adapter.HomeAdapter;

public class Posts_Fragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.posts, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycleview);

        HomeAdapter homeAdapter = new HomeAdapter();
        recyclerView.setAdapter(homeAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL, false);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(layoutManager);
        return view;
    }
}
