package com.mop.korac.mopstar.fragments;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.mop.korac.mopstar.R;
import com.mop.korac.mopstar.adapter.GroupAdapter;
import com.mop.korac.mopstar.register.RegisterActivity;

public class Group_Fragment extends Fragment {
    Button button;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.group_fragment, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.grouprecyclerview);

        GroupAdapter homeAdapter = new GroupAdapter();
        recyclerView.setAdapter(homeAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerView recyclerView2 = (RecyclerView) view.findViewById(R.id.yourgroups);

        recyclerView2.setAdapter(homeAdapter);
        RecyclerView.LayoutManager layoutManager2 = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL, false);
        recyclerView2.setLayoutManager(layoutManager2);


        button = view.findViewById(R.id.addbtn);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent barIntent = new Intent(getActivity(), AddGroup.class);
                startActivity(barIntent);
            }
        });
        return view;

    }

}
