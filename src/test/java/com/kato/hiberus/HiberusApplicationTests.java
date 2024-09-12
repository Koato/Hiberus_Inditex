package com.kato.hiberus;

import com.kato.hiberus.application.services.PriceService;
import com.kato.hiberus.domain.models.Price;
import com.kato.hiberus.infraestucture.controllers.PriceController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class HiberusApplicationTests {

    @InjectMocks
    private PriceController priceController;

    @Mock
    private PriceService priceService;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(priceController).build();
    }

    @Order(1)
    @Test
    void test1() throws Exception {
        Price prices = new Price();
        prices.setId(1L);
        prices.setPrice(new BigDecimal("35.50"));
        prices.setPriceList(1);
        prices.setStartDate(LocalDateTime.of(2020, 6, 14, 0, 0, 0));
        prices.setEndDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59));
        prices.setProductId(35455L);
        prices.setBrandId(1L);
        Optional<Price> oprices = Optional.of(prices);
        when(priceService.getPrice(LocalDateTime.of(2020,6, 14, 10, 0, 0), 35455L, 1L)).thenReturn(oprices);

        mockMvc.perform(get("/api/inditex/price")
                        .param("applicationDate", "2020-06-14-10:00:00")
                        .param("productId", "35455")
                        .param("brandId", "1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.startDate").value("2020-06-14-00:00:00"))
                .andExpect(jsonPath("$.endDate").value("2020-12-31-23:59:59"))
                .andExpect(jsonPath("$.productId").value("35455"))
                .andExpect(jsonPath("$.priceList").value("1"))
                .andExpect(jsonPath("$.brandId").value("1"))
                .andExpect(jsonPath("$.price").value(new BigDecimal("35.5")));
    }

    @Order(2)
    @Test
    void test2() throws Exception {
        Price prices = new Price();
        prices.setId(1L);
        prices.setPrice(new BigDecimal("25.45"));
        prices.setPriceList(1);
        prices.setStartDate(LocalDateTime.of(2020,6, 14, 15, 0, 0));
        prices.setEndDate(LocalDateTime.of(2020, 6, 14, 18, 30, 0));
        prices.setProductId(35455L);
        prices.setBrandId(1L);
        Optional<Price> oprices = Optional.of(prices);

        when(priceService.getPrice(LocalDateTime.of(2020,6, 14, 16, 0, 0), 35455L, 1L)).thenReturn(oprices);

        mockMvc.perform(get("/api/inditex/price")
                        .param("applicationDate", "2020-06-14-16:00:00")
                        .param("productId", "35455")
                        .param("brandId", "1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.startDate").value("2020-06-14-15:00:00"))
                .andExpect(jsonPath("$.endDate").value("2020-06-14-18:30:00"))
                .andExpect(jsonPath("$.productId").value("35455"))
                .andExpect(jsonPath("$.priceList").value("1"))
                .andExpect(jsonPath("$.price").value(new BigDecimal("25.45")))
                .andExpect(jsonPath("$.brandId").value(1));
    }

    @Order(3)
    @Test
    void test3() throws Exception {
        Price prices = new Price();
        prices.setId(1L);
        prices.setPrice(new BigDecimal("35.50"));
        prices.setPriceList(1);
        prices.setStartDate(LocalDateTime.of(2020,6, 14, 0, 0, 0));
        prices.setEndDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59));
        prices.setProductId(35455L);
        prices.setBrandId(1L);
        Optional<Price> oprices = Optional.of(prices);

        when(priceService.getPrice(LocalDateTime.of(2020,6, 14, 21, 0, 0), 35455L, 1L)).thenReturn(oprices);

        mockMvc.perform(get("/api/inditex/price")
                        .param("applicationDate", "2020-06-14-21:00:00")
                        .param("productId", "35455")
                        .param("brandId", "1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.startDate").value("2020-06-14-00:00:00"))
                .andExpect(jsonPath("$.endDate").value("2020-12-31-23:59:59"))
                .andExpect(jsonPath("$.productId").value("35455"))
                .andExpect(jsonPath("$.priceList").value("1"))
                .andExpect(jsonPath("$.price").value(new BigDecimal("35.5")))
                .andExpect(jsonPath("$.brandId").value(1));
    }

    @Order(4)
    @Test
    void test4() throws Exception {
        Price prices = new Price();
        prices.setId(1L);
        prices.setPrice(new BigDecimal("35.50"));
        prices.setPriceList(1);
        prices.setStartDate(LocalDateTime.of(2020,6, 15, 0, 0, 0));
        prices.setEndDate(LocalDateTime.of(2020, 6, 15, 11, 0, 0));
        prices.setProductId(35455L);
        prices.setBrandId(1L);
        Optional<Price> oprices = Optional.of(prices);

        when(priceService.getPrice(LocalDateTime.of(2020,6, 15, 10, 0, 0), 35455L, 1L)).thenReturn(oprices);

        mockMvc.perform(get("/api/inditex/price")
                        .param("applicationDate", "2020-06-15-10:00:00")
                        .param("productId", "35455")
                        .param("brandId", "1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.startDate").value("2020-06-15-00:00:00"))
                .andExpect(jsonPath("$.endDate").value("2020-06-15-11:00:00"))
                .andExpect(jsonPath("$.productId").value("35455"))
                .andExpect(jsonPath("$.priceList").value("1"))
                .andExpect(jsonPath("$.price").value(new BigDecimal("35.5")))
                .andExpect(jsonPath("$.brandId").value(1));
    }

    @Order(5)
    @Test
    void test5() throws Exception {
        Price prices = new Price();
        prices.setId(1L);
        prices.setPrice(new BigDecimal("38.95"));
        prices.setPriceList(1);
        prices.setStartDate(LocalDateTime.of(2020,6, 15, 16, 0, 0));
        prices.setEndDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59));
        prices.setProductId(35455L);
        prices.setBrandId(1L);
        Optional<Price> oprices = Optional.of(prices);

        when(priceService.getPrice(LocalDateTime.of(2020,6, 16, 21, 0, 0), 35455L, 1L)).thenReturn(oprices);

        mockMvc.perform(get("/api/inditex/price")
                        .param("applicationDate", "2020-06-16-21:00:00")
                        .param("productId", "35455")
                        .param("brandId", "1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.startDate").value("2020-06-15-16:00:00"))
                .andExpect(jsonPath("$.endDate").value("2020-12-31-23:59:59"))
                .andExpect(jsonPath("$.productId").value("35455"))
                .andExpect(jsonPath("$.priceList").value("1"))
                .andExpect(jsonPath("$.price").value(new BigDecimal("38.95")))
                .andExpect(jsonPath("$.brandId").value(1));
    }
}
