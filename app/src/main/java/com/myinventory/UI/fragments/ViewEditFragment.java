package com.myinventory.UI.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.myinventory.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ViewEditFragment extends Fragment {
    RecyclerView recyclerView_edit;

    public ViewEditFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_view_edit, container, false);
        recyclerView_edit = view.findViewById(R.id.recyclerView_edit);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext());
        recyclerView_edit.setLayoutManager(manager);
//        recyclerView_edit.setAdapter();
        return view;
    }

}
