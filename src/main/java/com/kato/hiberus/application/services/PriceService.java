package com.kato.hiberus.application.services;

import com.kato.hiberus.domain.models.Price;
import com.kato.hiberus.domain.ports.in.RetrievePriceUseCase;
import lombok.RequiredArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class PriceService implements RetrievePriceUseCase {

    private final RetrievePriceUseCase retrievePriceUseCase;

    @Override
    public Optional<Price> getPrice(LocalDateTime applicationDate, Long productId, Long brandId) {
        return retrievePriceUseCase.getPrice(applicationDate, productId, brandId);
    }

    @Override
    public List<Price> getAllPrices() {
        return retrievePriceUseCase.getAllPrices();
    }
}
