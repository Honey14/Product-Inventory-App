package com.myinventory.UI.fragments;


import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.myinventory.R;
import com.myinventory.UI.dialogs.DialogAddCategory;
import com.myinventory.Utils.Utilities;
import com.myinventory.database.DatabaseHelper;
import com.myinventory.model.Product;

import java.util.ArrayList;
import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddProductFragment extends Fragment {

    ImageView btn_addCategory, btn_removeCategory;
    Button button_save;
    EditText editproduct, edit_sku, edit_man_cost, edit_selling_prics;
    DatabaseHelper helper;
    ArrayList<Product> productList = new ArrayList<>();

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
        editproduct = view.findViewById(R.id.editproduct);
        edit_sku = view.findViewById(R.id.edit_sku);
        edit_man_cost = view.findViewById(R.id.edit_man_cost);
        edit_selling_prics = view.findViewById(R.id.edit_selling_prics);
        button_save = view.findViewById(R.id.button_save);
        helper = new DatabaseHelper(getContext());
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
        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String productName = editproduct.getText().toString();
                String sku = edit_sku.getText().toString();

                if (TextUtils.isEmpty(productName) && TextUtils.isEmpty(sku) && TextUtils.isEmpty(edit_man_cost.getText().toString()) && TextUtils.isEmpty(edit_selling_prics.getText().toString())) {
                    Snackbar snackbar =
                            Snackbar
                                    .make(button_save, "Please fill all details", Snackbar.LENGTH_SHORT)
                                    .setAction("OK", null);

                    View view1 = snackbar.getView();
                    view1.setBackgroundColor(ContextCompat.getColor(view1.getContext(), android.R.color.holo_red_dark));
                    snackbar.show();
                } else {
                    int manufacturing_cost = Integer.parseInt(edit_man_cost.getText().toString());
                    int selling_price = Integer.parseInt(edit_selling_prics.getText().toString());

                    productList.add(new Product(0, productName, sku, manufacturing_cost, selling_price));
                    new insertProductTable().execute();

                }
            }
        });
    }

    class insertProductTable extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Utilities.showProgressDialog(getActivity(), getFragmentManager());
        }

        @Override
        protected Void doInBackground(Void... voids) {
            helper.insertProduct(productList);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            new insertProductTable().cancel(true);
            Utilities.dismissProgressDialog();
            // going back to previous fragment
            assert getFragmentManager() != null;
            getFragmentManager().popBackStack();
        }
    }
}