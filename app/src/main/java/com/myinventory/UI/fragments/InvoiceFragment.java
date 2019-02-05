package com.myinventory.UI.fragments;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.myinventory.R;
import com.myinventory.Utils.Utilities;
import com.myinventory.database.DatabaseHelper;
import com.myinventory.model.CustomerDetails;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class InvoiceFragment extends Fragment {

    EditText editCustomerName, edit_email, edit_mob_no, edit_city;
    Button button_invoice;
    ArrayList<CustomerDetails> customerDetails = new ArrayList<>();
    DatabaseHelper helper2;

    public InvoiceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_invoice, container, false);
        editCustomerName = view.findViewById(R.id.editCustomerName);
        edit_email = view.findViewById(R.id.edit_email);
        edit_mob_no = view.findViewById(R.id.edit_mob_no);
        edit_city = view.findViewById(R.id.edit_city);
        button_invoice = view.findViewById(R.id.button_invoice);
        helper2 = new DatabaseHelper(getContext());
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        button_invoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String custname = editCustomerName.getText().toString();
                String custEmail = edit_email.getText().toString();
                String custMobile = edit_mob_no.getText().toString();
                String custCity = edit_city.getText().toString();
                if (TextUtils.isEmpty(custname) && TextUtils.isEmpty(custEmail) && TextUtils.isEmpty(custMobile) && TextUtils.isEmpty(custCity)) {
                    Snackbar snackbar =
                            Snackbar
                                    .make(button_invoice, "Please fill all details", Snackbar.LENGTH_SHORT)
                                    .setAction("OK", null);

                    View view1 = snackbar.getView();
                    view1.setBackgroundColor(ContextCompat.getColor(view1.getContext(), android.R.color.holo_red_dark));
                    snackbar.show();
                } else {

                    customerDetails.add(new CustomerDetails(custname, custEmail, Integer.parseInt(custMobile), custCity));
                    new insertCustomerTable().execute();
                }
            }
        });
    }

    class insertCustomerTable extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Utilities.showProgressDialog(getActivity(), getFragmentManager());
        }

        @Override
        protected Void doInBackground(Void... voids) {
            helper2.insertCustomerDetails(customerDetails);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            new insertCustomerTable().cancel(true);
            Utilities.dismissProgressDialog();
            // going back to previous fragment
            assert getFragmentManager() != null;
            getFragmentManager().popBackStack();
        }
    }
}
