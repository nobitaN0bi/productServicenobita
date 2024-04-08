package com.example.productservicenobita.models;

import java.util.ArrayList;
import java.util.Date;

public class Cart {
    private Long id;
    private Long userID;
    private Date date;
    private ArrayList<Cart> cart;

    public Cart() {
    }

    public Cart(Long id, Long userID, Date date, ArrayList<Cart> cart) {
        this.id = id;
        this.userID = userID;
        this.date = date;
        this.cart = cart;
    }
}
