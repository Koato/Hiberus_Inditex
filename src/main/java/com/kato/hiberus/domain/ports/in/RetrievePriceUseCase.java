package com.kato.hiberus.domain.ports.in;

import com.kato.hiberus.domain.models.Price;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public interface RetrievePriceUseCase {

    Optional<Price> getPrice(LocalDateTime applicationDate, Long productId, Long brandId);
}
