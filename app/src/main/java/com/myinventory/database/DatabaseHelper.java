package com.myinventory.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.myinventory.model.CustomerDetails;
import com.myinventory.model.Product;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {


    public DatabaseHelper(Context context) {
        super(context, DBConstants.DB_NAME, null, DBConstants.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        for (String table : DBConstants.CREATE_TABLES) {
            db.execSQL(table);
//        db.execSQL(DBConstants.TABLE_ADD_PRODUCT_QUERY);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        for (String table : DBConstants.CREATE_TABLES) {
            db.execSQL("DROP TABLE IF EXISTS " + table);
        }
        onCreate(db);
    }

    public void insertProduct(ArrayList<Product> productArrayList) {
//        ArrayList<productsList> productArrayList = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        try {
            if (productArrayList != null) {
                for (int i = 0; i < productArrayList.size(); i++) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("serial_no", productArrayList.get(i).getSerial_no());
                    contentValues.put("product_name", productArrayList.get(i).getProduct_name());
                    contentValues.put("sku", productArrayList.get(i).getSku());
                    contentValues.put("manufacturing_cost", productArrayList.get(i).getManufacturing_cost());
                    contentValues.put("selling_price", productArrayList.get(i).getSelling_price());
                    sqLiteDatabase.insert(DBConstants.TABLE_ADD_PRODUCT, null, contentValues);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertCustomerDetails(ArrayList<CustomerDetails> customerDetailsArrayList) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        try {
            if (customerDetailsArrayList != null) {
                for (int i = 0; i < customerDetailsArrayList.size(); i++) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("customer_name", customerDetailsArrayList.get(i).getCustomer_name());
                    contentValues.put("email_id", customerDetailsArrayList.get(i).getEmail_id());
                    contentValues.put("mob_no", customerDetailsArrayList.get(i).getMob_no());
                    contentValues.put("city", customerDetailsArrayList.get(i).getCity());
                    sqLiteDatabase.insert(DBConstants.TABLE_CUSTOMER_DETAILS, null, contentValues);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Product> retrieveProduct() {
        ArrayList<Product> products = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = null;
        try {
            cursor = sqLiteDatabase.rawQuery("select * from add_product", null);
            if (cursor.moveToFirst()) {
                do {
                    Product product = new Product();
                    product.setSerial_no(cursor.getInt(1));
                    product.setProduct_name(cursor.getString(2));
                    product.setSku(cursor.getString(3));
                    product.setManufacturing_cost(cursor.getInt(4));
                    product.setSelling_price(cursor.getInt(5));
                    products.add(product);
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqLiteDatabase.close();
        }
        return products;
    }

    public ArrayList<CustomerDetails> retrieveCustomers() {
        ArrayList<CustomerDetails> customers = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = null;
        try {
            cursor = sqLiteDatabase.rawQuery("select * from customer_details", null);
            if (cursor.moveToFirst()) {
                do {
                    CustomerDetails customerDetails = new CustomerDetails();
                    customerDetails.setCustomer_name(cursor.getString(1));
                    customerDetails.setEmail_id(cursor.getString(2));
                    customerDetails.setMob_no(cursor.getInt(3));
                    customerDetails.setCity(cursor.getString(4));
                    customers.add(customerDetails);
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqLiteDatabase.close();
        }
        return customers;
    }
}
