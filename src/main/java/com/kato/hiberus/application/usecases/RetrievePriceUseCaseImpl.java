package com.kato.hiberus.application.usecases;

import com.kato.hiberus.domain.models.Price;
import com.kato.hiberus.domain.ports.in.RetrievePriceUseCase;
import com.kato.hiberus.domain.ports.out.PriceRepositoryPort;
import lombok.RequiredArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class RetrievePriceUseCaseImpl implements RetrievePriceUseCase {

    private final PriceRepositoryPort priceRepositoryPort;

    @Override
    public Optional<Price> getPrice(LocalDateTime applicationDate, Long productId, Long brandId) {
        return priceRepositoryPort.findPrice(applicationDate, productId, brandId);
    }

    @Override
    public List<Price> getAllPrices() {
        return priceRepositoryPort.findAll();
    }
}
