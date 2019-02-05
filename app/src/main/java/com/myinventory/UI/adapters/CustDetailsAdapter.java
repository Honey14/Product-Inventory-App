package com.myinventory.UI.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.myinventory.R;
import com.myinventory.model.CustomerDetails;


import java.util.ArrayList;

public class CustDetailsAdapter extends RecyclerView.Adapter<CustDetailsAdapter.CustDetailsViewHolder> {
    ArrayList<CustomerDetails> arrayList = new ArrayList<>();
    Context context;

    public CustDetailsAdapter(Context context, ArrayList<CustomerDetails> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public CustDetailsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_custdetails, viewGroup, false);
        return new CustDetailsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustDetailsViewHolder holder, int position) {
        holder.text_cName_value.setText(arrayList.get(position).getCustomer_name());
        holder.text_email_value.setText(arrayList.get(position).getEmail_id());
        holder.text_mobValue.setText(String.valueOf(arrayList.get(position).getMob_no()));
        holder.text_cityValue.setText(arrayList.get(position).getCity());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class CustDetailsViewHolder extends RecyclerView.ViewHolder {
        TextView text_cName_value, text_email_value, text_mobValue, text_cityValue;


        public CustDetailsViewHolder(@NonNull View itemView) {
            super(itemView);
            text_cName_value = itemView.findViewById(R.id.text_cName_value);
            text_email_value = itemView.findViewById(R.id.text_email_value);
            text_mobValue = itemView.findViewById(R.id.text_mobValue);
            text_cityValue = itemView.findViewById(R.id.text_cityValue);

        }
    }
}
