package com.kato.hiberus.infraestucture.repository;

import com.kato.hiberus.domain.models.Price;
import com.kato.hiberus.domain.ports.out.PriceRepositoryPort;
import com.kato.hiberus.infraestucture.entities.PriceEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@RequiredArgsConstructor
@Component
public class JpaPriceRepositoryAdapter implements PriceRepositoryPort {

    private final JpaPriceRepository jpaPriceRepository;

    @Override
    public List<Price> findAll() {
        return jpaPriceRepository.findAll().stream().map(PriceEntity::toDomainModel).toList();
    }

    @Override
    public Optional<Price> findPrice(LocalDateTime applicationDate, Long productId, Long brandId) {
        Predicate<Price> filterPredicate = x -> x.getStartDate().isBefore(applicationDate) && x.getEndDate().isAfter(applicationDate)
                && x.getProductId().equals(productId) && x.getBrandId().equals(brandId);
        var prices = findAll().parallelStream().filter(filterPredicate).toList();
        return prices.stream().max(Comparator.comparing(Price::getPriority));
    }
}
