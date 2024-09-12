package com.kato.hiberus.domain.ports.in;

import com.kato.hiberus.domain.models.Price;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface RetrievePriceUseCase {

    Optional<Price> getPrice(LocalDateTime applicationDate, Long productId, Long brandId);
    List<Price> getAllPrices();
}
