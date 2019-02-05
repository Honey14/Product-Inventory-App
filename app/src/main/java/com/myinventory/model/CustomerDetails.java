package com.myinventory.model;

public class CustomerDetails {
    String customer_name;
    String email_id;
    int mob_no;
    String city;

    public CustomerDetails() {
    }

    public CustomerDetails(String customer_name, String email_id, int mob_no, String city) {
        this.customer_name = customer_name;
        this.email_id = email_id;
        this.mob_no = mob_no;
        this.city = city;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public int getMob_no() {
        return mob_no;
    }

    public void setMob_no(int mob_no) {
        this.mob_no = mob_no;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
