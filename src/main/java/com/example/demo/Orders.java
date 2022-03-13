package com.example.demo;

import java.util.Date;

public class Orders {
    private Date data;
    private int id;
    private String product_name;
    private int amount;

    public Orders( int id, Date data, String product_name, int amount) {
        this.data = data;
        this.id = id;
        this.product_name = product_name;
        this.amount = amount;
    }
    public Orders(String product_name){
        this.product_name = product_name;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
