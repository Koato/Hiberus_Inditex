package com.kato.hiberus.application.usecases;

import com.kato.hiberus.application.ports.in.RetrievePriceUseCase;
import com.kato.hiberus.application.ports.out.PriceRepositoryPort;
import com.kato.hiberus.domain.models.Price;
import com.kato.hiberus.infraestucture.in.dto.PriceDTO;
import com.kato.hiberus.infraestucture.in.mapper.PriceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Optional;
import java.util.function.Predicate;

@RequiredArgsConstructor
@Component
public class RetrievePriceUseCaseImpl implements RetrievePriceUseCase {

    private final PriceRepositoryPort priceRepositoryPort;

    private final PriceMapper mapper;

    @Override
    public Optional<Price> getPrice(LocalDateTime applicationDate, Long productId, Long brandId) {
        Predicate<PriceDTO> filterPredicate = x -> x.startDate().isBefore(applicationDate) && x.endDate().isAfter(applicationDate)
                && x.productId().equals(productId) && x.brandId().equals(brandId);
        var prices = mapper.toPrices(priceRepositoryPort.findAll().parallelStream().filter(filterPredicate).toList());
        return prices.stream().max(Comparator.comparing(Price::priority));
    }
}
