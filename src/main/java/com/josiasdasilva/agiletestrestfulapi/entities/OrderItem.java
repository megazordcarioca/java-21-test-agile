package com.josiasdasilva.agiletestrestfulapi.entities;


import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Embeddable
@Table(name = "order_x_items")
public class OrderItem {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;


    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Getter
    @Setter
    @Column
    @NotNull
    private Integer quantity;

    public @NotNull Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(@NotNull Integer quantity) {
        this.quantity = quantity;
    }

    @Transient
    public @NotNull Double getTotalCost() {
        return product.getPrice() * quantity;
    }
}