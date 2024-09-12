package com.kato.hiberus.domain.ports.out;

import com.kato.hiberus.domain.models.Price;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface PriceRepositoryPort {
    List<Price> findAll();
    Optional<Price> findPrice(LocalDateTime applicationDate, Long productId, Long brandId);
}
