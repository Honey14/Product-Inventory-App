package com.myinventory.UI.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.myinventory.R;
import com.myinventory.UI.adapters.CustDetailsAdapter;
import com.myinventory.database.DatabaseHelper;
import com.myinventory.model.CustomerDetails;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class CustomerDetailsFragment extends Fragment {
    RecyclerView recyclerView_custDetails;
DatabaseHelper helper3;
    public CustomerDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_customer_details, container, false);
        recyclerView_custDetails = view.findViewById(R.id.recyclerView_custDetails);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext());
        recyclerView_custDetails.setLayoutManager(manager);
        helper3 = new DatabaseHelper(getActivity());
        ArrayList<CustomerDetails> arrayList = helper3.retrieveCustomers();
        CustDetailsAdapter custDetailsAdapter = new CustDetailsAdapter(getActivity(),arrayList);
        recyclerView_custDetails.setAdapter(custDetailsAdapter);
        return view;
    }

}
