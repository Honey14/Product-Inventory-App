package com.myinventory.UI.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.myinventory.R;

import androidx.navigation.Navigation;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    ImageView image_addProduct, image_edit, image_invoice, image_customerDetails, image_report;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        image_addProduct = view.findViewById(R.id.image_addProduct);
        image_edit = view.findViewById(R.id.image_edit);
        image_invoice = view.findViewById(R.id.image_invoice);
        image_customerDetails = view.findViewById(R.id.image_customerDetails);
        image_report = view.findViewById(R.id.image_report);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        image_addProduct.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_homeFragment2_to_addProductFragment));
        image_edit.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_homeFragment2_to_viewEditFragment));
        image_invoice.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_homeFragment2_to_invoiceFragment));
        image_customerDetails.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_homeFragment2_to_customerDetailsFragment));
        image_report.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_homeFragment2_to_reportFragment));
    }
}
