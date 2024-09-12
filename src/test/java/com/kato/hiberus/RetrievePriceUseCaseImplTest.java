package com.kato.hiberus;

import com.kato.hiberus.application.usecases.RetrievePriceUseCaseImpl;
import com.kato.hiberus.domain.models.Price;
import com.kato.hiberus.domain.ports.out.PriceRepositoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

class RetrievePriceUseCaseImplTest {

    @InjectMocks
    RetrievePriceUseCaseImpl retrievePriceUseCase;

    @Mock
    PriceRepositoryPort priceRepositoryPort;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void test1() {
        List<Price> priceEntities = List.of(new Price());
        when(priceRepositoryPort.findAll()).thenReturn(priceEntities);
        List<Price> result = retrievePriceUseCase.getAllPrices();
        // Assert
        assertNotNull(result);
        assertEquals(priceEntities.size(), result.size());
    }

    @Test
    void test2() {
        Price prices = new Price();
        prices.setId(1L);
        prices.setPrice(new BigDecimal("25.45"));
        prices.setPriceList(1);
        prices.setStartDate(LocalDateTime.of(2020,6, 14, 15, 0, 0));
        prices.setEndDate(LocalDateTime.of(2020, 6, 14, 18, 30, 0));
        prices.setProductId(35455L);
        prices.setBrandId(1L);
        Optional<Price> oprices = Optional.of(prices);
        when(priceRepositoryPort.findPrice(LocalDateTime.of(2020,6, 14, 16, 0, 0), 35455L, 1L)).thenReturn(oprices);
        Optional<Price> result = retrievePriceUseCase.getPrice(LocalDateTime.of(2020, 6, 14, 0, 0, 0), 35455L, 1L);
        assertNotNull(result);
    }
}
