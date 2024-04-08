package com.example.productservicenobita.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Category {

    private Long id;
    private String name;

    public Category() {
    }

    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }

}