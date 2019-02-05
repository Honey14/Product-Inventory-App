package com.myinventory.database;

public interface DBConstants {
    String DB_NAME = "inventory.db";
    int DB_VERSION = 1;
    String TABLE_ADD_PRODUCT = "add_product";
    String TABLE_CUSTOMER_DETAILS = "customer_details";


    String TABLE_ADD_PRODUCT_QUERY = "CREATE TABLE " + TABLE_ADD_PRODUCT + "(" +
            "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "serial_no INTEGER," +
            "product_name TEXT," +
            "sku TEXT, " +
            "" +
            "manufacturing_cost INTEGER ," +
            "selling_price INTEGER " +
            "" +
            "" +
            ")";

    String TABLE_CUSTOMER_DETAILS_QUERY = "CREATE TABLE " + TABLE_CUSTOMER_DETAILS + "(" +
            "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "customer_name TEXT," +
            "email_id TEXT," +
            "mob_no INTEGER," +
            "city TEXT" +
            ")";
    String[] CREATE_TABLES = {TABLE_ADD_PRODUCT_QUERY,TABLE_CUSTOMER_DETAILS_QUERY};
}