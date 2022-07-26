package com.evolve.advancejavaassignment.data.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SkuDto {
    private Long id;
    private String name;
    private String description;
    private double rlp;
    private double rlpVat;
    private boolean active;
    @JsonIgnoreProperties
    private boolean isAddedToOrder;
}
