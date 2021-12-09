package com.shop.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany
    private List<Product> product;
    @OneToOne(cascade = CascadeType.PERSIST.ALL)
    private User user;
    private Long count;
    private boolean confirm=false;
    @OneToMany(mappedBy = "cart")
    private List<CartNode> cartNodes;




}
