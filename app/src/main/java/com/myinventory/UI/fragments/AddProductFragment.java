package com.myinventory.UI.fragments;


import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.myinventory.R;
import com.myinventory.UI.dialogs.DialogAddCategory;

import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddProductFragment extends Fragment {

    ImageView btn_addCategory, btn_removeCategory;

    public AddProductFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_product, container, false);
        btn_addCategory = view.findViewById(R.id.btn_addCategory);
        btn_removeCategory = view.findViewById(R.id.btn_removeCategory);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btn_addCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogAddCategory dialogAddCategory = new DialogAddCategory();
                dialogAddCategory.setCancelable(false);
                dialogAddCategory.show(Objects.requireNonNull(getActivity()).getSupportFragmentManager(), "Category");
            }
        });
        btn_removeCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
