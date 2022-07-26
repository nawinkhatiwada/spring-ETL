package com.evolve.advancejavaassignment.features.skus;

import com.evolve.advancejavaassignment.data.dto.SkuDto;
import com.evolve.advancejavaassignment.data.entity.Sku;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.evolve.advancejavaassignment.util.Utils.formatDouble;

@Service
public class SkuService {
    private final SkusRepository repository;

    public SkuService(SkusRepository repository) {
        this.repository = repository;
    }

    public Optional<Sku> findSkuByName(String name) {
        return repository.findSkuByName(name);
    }

    public void addNewSku(SkuDto skuDto) {
        repository.save(Sku.builder()
                .name(skuDto.getName())
                .rlp(skuDto.getRlp())
                .rlpVat(skuDto.getRlp() * 1.13)
                .description(skuDto.getDescription())
                .active(true)
                .build());
    }

    public List<Sku> getAllSku() {
        return repository.findAll();
    }
}
