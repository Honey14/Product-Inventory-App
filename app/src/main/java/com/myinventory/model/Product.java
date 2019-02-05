package com.myinventory.model;

public class Product {
    int serial_no;
    String product_name;
    String sku;
    // array of cateogry
    int manufacturing_cost;
    int selling_price;
    // array of size
    // array of quantity

    public Product() {
    }

    public Product(int serial_no,String product_name, String sku, int manufacturing_cost, int selling_price) {
        this.serial_no = serial_no;
        this.product_name = product_name;
        this.sku = sku;
        this.manufacturing_cost = manufacturing_cost;
        this.selling_price = selling_price;
    }

    public int getSerial_no() {
        return serial_no;
    }

    public void setSerial_no(int serial_no) {
        this.serial_no = serial_no;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public int getManufacturing_cost() {
        return manufacturing_cost;
    }

    public void setManufacturing_cost(int manufacturing_cost) {
        this.manufacturing_cost = manufacturing_cost;
    }

    public int getSelling_price() {
        return selling_price;
    }

    public void setSelling_price(int selling_price) {
        this.selling_price = selling_price;
    }
}
