package com.example.demo.repository;

public interface OrdersRepository {
    String read(String scriptFileName);

    String getProductName(String name);
}
