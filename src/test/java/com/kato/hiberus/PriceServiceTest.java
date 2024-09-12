package com.kato.hiberus;

import com.kato.hiberus.application.services.PriceService;
import com.kato.hiberus.domain.models.Price;
import com.kato.hiberus.domain.ports.in.RetrievePriceUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class PriceServiceTest {

    @InjectMocks
    PriceService priceService;

    @Mock
    RetrievePriceUseCase retrievePriceUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void test1() {
        Price prices = new Price();
        prices.setId(1L);
        prices.setPrice(new BigDecimal("25.45"));
        prices.setPriceList(1);
        prices.setStartDate(LocalDateTime.of(2020,6, 14, 15, 0, 0));
        prices.setEndDate(LocalDateTime.of(2020, 6, 14, 18, 30, 0));
        prices.setProductId(35455L);
        prices.setBrandId(1L);
        Optional<Price> oprices = Optional.of(prices);
        when(retrievePriceUseCase.getPrice(any(), any(), any())).thenReturn(oprices);
        var result = priceService.getPrice(LocalDateTime.of(2020,6, 14, 15, 0, 0), 1L, 1L);
        assertNotNull(result);
    }

    @Test
    void test2() {
        List<Price> prices = List.of(new Price());
        when(retrievePriceUseCase.getAllPrices()).thenReturn(prices);
        var result = priceService.getAllPrices();
        assertNotNull(result);
    }
}
