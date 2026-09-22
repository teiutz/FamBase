package com.wad.firstmvc.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingItem {

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int quantity;
    private String store;
    private Category category;
    private String importance;

    @Setter
    private boolean status;

    public ShoppingItem(String name, int quantity, String store, String importance, Category category) {
        this.name = name;
        this.quantity = quantity;
        this.store = store;
        this.category = category;
        this.importance = importance;
        this.status = false;
    }

    public boolean getStatus() {
        return this.status;
    }
}
