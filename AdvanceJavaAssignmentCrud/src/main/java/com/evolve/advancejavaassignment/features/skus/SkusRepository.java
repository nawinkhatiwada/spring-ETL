package com.evolve.advancejavaassignment.features.skus;

import com.evolve.advancejavaassignment.data.entity.Sku;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SkusRepository extends JpaRepository<Sku, Long> {

    Optional<Sku> findSkuByName(String name);
}
