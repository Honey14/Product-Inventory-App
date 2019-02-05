package com.myinventory.UI.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.myinventory.MainActivity;
import com.myinventory.R;
import com.myinventory.UI.fragments.AddProductFragment;
import com.myinventory.model.Product;

import java.util.ArrayList;

public class EditViewAdapter extends RecyclerView.Adapter<EditViewAdapter.EditViewHolder> {
    ArrayList<Product> arrayList = new ArrayList<>();
    Context context;
    int serial_no_count = 0;
    public EditViewAdapter(Context context, ArrayList<Product> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public EditViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_editview, viewGroup, false);
        return new EditViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EditViewHolder holder, int i) {
        serial_no_count++;
        holder.text_prodName.setText(arrayList.get(i).getProduct_name());
        Log.d("serial_no_count", String.valueOf(serial_no_count));
        holder.text_count.setText(String.valueOf(serial_no_count));
        holder.imag_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity myActivity = (MainActivity) context;
                Fragment myFrag = new AddProductFragment();
//                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, myFrag).addToBackStack(null).commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class EditViewHolder extends RecyclerView.ViewHolder {
        ImageView imag_edit;
        TextView text_prodName, text_count;

        public EditViewHolder(@NonNull View itemView) {
            super(itemView);
            imag_edit = itemView.findViewById(R.id.imag_edit);
            text_prodName = itemView.findViewById(R.id.text_prodName);
            text_count = itemView.findViewById(R.id.text_count);
        }
    }
}
