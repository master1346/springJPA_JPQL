package com.example.demo.repository;


import com.example.demo.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class JdbcOrdersRepository implements OrdersRepository {

    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public JdbcOrdersRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getProductName(String name){
        String lineRequest = read("data.sql");
        List<Orders> orders = jdbcTemplate.query(lineRequest,
                (rs, rowNum) -> new Orders(rs.getString("product_name")),name);

        if(orders.isEmpty()) return "No products about this name";

        ArrayList<String> product = new ArrayList<>();
        for(int i = 0; i < orders.stream().toArray().length; i++){
            product.add(orders.get(i).getProduct_name());
        }

        return product.toString();
    }
}
