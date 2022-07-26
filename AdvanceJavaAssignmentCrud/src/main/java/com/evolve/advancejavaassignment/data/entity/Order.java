package com.evolve.advancejavaassignment.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Order {
    @Id
    private Long id;
    private Long invoiceId;
    // sku id many to many
    // user id many to many
    private int quantity;
    private double grossAmount;
    @DateTimeFormat(pattern = ( "yyyy-mm-dd HH:mm:ss a"))
    private LocalDate transactionDate;
    private String status;
    @ManyToMany(mappedBy = "orders")
    private Set<User> orderedByUser;
    @ManyToMany
    @JoinTable(
            name = "order_sku",
            joinColumns = @JoinColumn(name = "sku_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id")
    )
    private Set<Sku> orderedSkus;
}
