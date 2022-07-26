package com.evolve.advancejavaassignment.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "skus")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class Sku {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private double rlp;
    private double rlpVat;
    private boolean active;
    @ManyToMany(mappedBy = "orderedSkus")
    private Set<Order> orderedSkus;
}
