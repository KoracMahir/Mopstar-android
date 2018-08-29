package com.mop.korac.mopstar.fragments;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mop.korac.mopstar.R;
import com.mop.korac.mopstar.adapter.EventAdapter;
import com.mop.korac.mopstar.adapter.GroupAdapter;

public class Event_Fragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.event_fragment, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.myevents);

        EventAdapter homeAdapter = new EventAdapter();
        recyclerView.setAdapter(homeAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerView recyclerView2 = (RecyclerView) view.findViewById(R.id.upcomingevents);

        recyclerView2.setAdapter(homeAdapter);
        RecyclerView.LayoutManager layoutManager2 = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL, false);
        recyclerView2.setLayoutManager(layoutManager2);
        return view;
    }
}
