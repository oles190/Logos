package com.shop.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name="products")
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private Long price;

    private Long capacity;

    @ManyToOne()
    private Category category;


    @OneToMany(mappedBy = "product")
    private List<CartNode> cart;






}

