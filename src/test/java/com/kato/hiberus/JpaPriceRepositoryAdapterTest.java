package com.kato.hiberus;

import com.kato.hiberus.domain.models.Price;
import com.kato.hiberus.infraestucture.entities.PriceEntity;
import com.kato.hiberus.infraestucture.repository.JpaPriceRepository;
import com.kato.hiberus.infraestucture.repository.JpaPriceRepositoryAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class JpaPriceRepositoryAdapterTest {

    @InjectMocks
    JpaPriceRepositoryAdapter jpaPriceRepositoryAdapter;

    @Mock
    JpaPriceRepository jpaPriceRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void test1() {
        // Arrange
        List<PriceEntity> priceEntities = List.of(new PriceEntity()); // Mock data
        when(jpaPriceRepository.findAll()).thenReturn(priceEntities);

        // Act
        List<Price> result = jpaPriceRepositoryAdapter.findAll();

        // Assert
        assertNotNull(result);
        assertEquals(priceEntities.size(), result.size());
    }

    @Test
    void test2() {
        // Arrange
        LocalDateTime applicationDate = LocalDateTime.of(2020,6, 14, 21, 0, 0);
        Long productId = 1L;
        Long brandId = 1L;

        PriceEntity priceEntity1 = new PriceEntity();
        priceEntity1.setPriority(1);
        priceEntity1.setProductId(productId);
        priceEntity1.setStartDate(LocalDateTime.of(2020,6, 14, 15, 0, 0));
        priceEntity1.setEndDate(LocalDateTime.of(2020, 6, 14, 18, 30, 0));
        priceEntity1.setBrandId(brandId);

        PriceEntity priceEntity2 = new PriceEntity();
        priceEntity2.setProductId(productId);
        priceEntity2.setBrandId(brandId);
        priceEntity2.setStartDate(LocalDateTime.of(2020, 6, 14, 0, 0, 0));
        priceEntity2.setEndDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59));
        priceEntity2.setPriority(2); // Higher priority

        List<PriceEntity> priceEntities = List.of(priceEntity1, priceEntity2);
        when(jpaPriceRepository.findAll()).thenReturn(priceEntities);

        // Act
        Optional<Price> result = jpaPriceRepositoryAdapter.findPrice(applicationDate, productId, brandId);

        // Assert
        assertFalse(result.isEmpty());
        verify(jpaPriceRepository, times(1)).findAll();
    }

    @Test
    void test3() {
        // Arrange
        LocalDateTime applicationDate = LocalDateTime.of(2020,6, 14, 21, 0, 0);
        Long productId = 1L;
        Long brandId = 1L;

        PriceEntity priceEntity1 = new PriceEntity();
        priceEntity1.setPriority(1);
        priceEntity1.setProductId(productId);
        priceEntity1.setBrandId(brandId);
        priceEntity1.setStartDate(LocalDateTime.of(2020, 6, 14, 0, 0, 0));
        priceEntity1.setEndDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59));

        PriceEntity priceEntity2 = new PriceEntity();
        priceEntity2.setProductId(productId);
        priceEntity2.setBrandId(brandId);
        priceEntity2.setStartDate(LocalDateTime.of(2020,6, 14, 15, 0, 0));
        priceEntity2.setEndDate(LocalDateTime.of(2020, 6, 14, 18, 30, 0));
        priceEntity2.setPriority(2); // Higher priority

        List<PriceEntity> priceEntities = List.of(priceEntity1, priceEntity2);
        when(jpaPriceRepository.findAll()).thenReturn(priceEntities);

        // Act
        Optional<Price> result = jpaPriceRepositoryAdapter.findPrice(applicationDate, productId, brandId);

        // Assert
        assertFalse(result.isEmpty());
        verify(jpaPriceRepository, times(1)).findAll();
    }

    @Test
    void test4() {
        // Arrange
        LocalDateTime applicationDate = LocalDateTime.of(2020,6, 14, 21, 0, 0);
        Long productId = 1L;
        Long brandId = 1L;

        PriceEntity priceEntity1 = new PriceEntity();
        priceEntity1.setPriority(1);
        priceEntity1.setProductId(productId);
        priceEntity1.setBrandId(brandId);
        priceEntity1.setStartDate(LocalDateTime.of(2020, 6, 14, 0, 0, 0));
        priceEntity1.setEndDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59));

        PriceEntity priceEntity2 = new PriceEntity();
        priceEntity2.setProductId(2L);
        priceEntity2.setBrandId(brandId);
        priceEntity2.setStartDate(LocalDateTime.of(2020,6, 14, 15, 0, 0));
        priceEntity2.setEndDate(LocalDateTime.of(2020, 6, 14, 18, 30, 0));
        priceEntity2.setPriority(2); // Higher priority

        List<PriceEntity> priceEntities = List.of(priceEntity1, priceEntity2);
        when(jpaPriceRepository.findAll()).thenReturn(priceEntities);

        // Act
        Optional<Price> result = jpaPriceRepositoryAdapter.findPrice(applicationDate, productId, brandId);

        // Assert
        assertFalse(result.isEmpty());
        verify(jpaPriceRepository, times(1)).findAll();
    }

    @Test
    void test5() {
        // Arrange
        LocalDateTime applicationDate = LocalDateTime.of(2020,6, 14, 21, 0, 0);
        Long productId = 1L;
        Long brandId = 1L;

        PriceEntity priceEntity1 = new PriceEntity();
        priceEntity1.setPriority(1);
        priceEntity1.setProductId(productId);
        priceEntity1.setBrandId(brandId);
        priceEntity1.setStartDate(LocalDateTime.of(2020, 6, 14, 0, 0, 0));
        priceEntity1.setEndDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59));

        PriceEntity priceEntity2 = new PriceEntity();
        priceEntity2.setProductId(2L);
        priceEntity2.setBrandId(2L);
        priceEntity2.setStartDate(LocalDateTime.of(2020,6, 14, 15, 0, 0));
        priceEntity2.setEndDate(LocalDateTime.of(2020, 6, 14, 18, 30, 0));
        priceEntity2.setPriority(2); // Higher priority

        List<PriceEntity> priceEntities = List.of(priceEntity1, priceEntity2);
        when(jpaPriceRepository.findAll()).thenReturn(priceEntities);

        // Act
        Optional<Price> result = jpaPriceRepositoryAdapter.findPrice(applicationDate, productId, brandId);

        // Assert
        assertFalse(result.isEmpty());
        verify(jpaPriceRepository, times(1)).findAll();
    }

    @Test
    void test6() {
        PriceEntity priceEntity1 = new PriceEntity();
        priceEntity1.setPriority(1);
        priceEntity1.setProductId(1L);
        priceEntity1.setStartDate(LocalDateTime.of(2020, 6, 14, 0, 0, 0));
        priceEntity1.setEndDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59));
        var price = PriceEntity.fromDomainModel(
                new Price(1L, 1L, LocalDateTime.now(), LocalDateTime.now(), 1, 1L, 1, new BigDecimal("1.0"), ""));
        assertNotNull(price);
    }
}
