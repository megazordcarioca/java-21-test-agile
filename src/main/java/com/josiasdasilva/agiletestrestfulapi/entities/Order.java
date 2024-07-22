package com.josiasdasilva.agiletestrestfulapi.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table (name = "orders")
public class Order {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Getter
    @Setter
    @Column(nullable = false, updatable = false)
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    protected LocalDateTime createdDate;

    @Getter
    @Setter
    @Column
    @LastModifiedBy
    @Null
    @Temporal(TemporalType.TIMESTAMP)
    protected LocalDateTime updatedDate;

    @Getter
    @Setter
    @NotNull
    @Column
    protected String orderStatus;


    public Order() {

    }

    public void getOrderDate(Date date) {
    }

}
