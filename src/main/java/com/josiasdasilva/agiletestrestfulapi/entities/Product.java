package com.josiasdasilva.agiletestrestfulapi.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.lang.annotation.Target;


@Entity
@Table(name = "products")
public class Product {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Getter
    @Setter
    @Column
    @NotNull(message = "Product name is required")
    protected String name;

    @Getter
    @Setter
    @Column
    @NotNull(message = "Description can´t be null")
    protected String description;

    @Getter
    @Setter
    @Column
    @NotNull
    protected Double price;

}