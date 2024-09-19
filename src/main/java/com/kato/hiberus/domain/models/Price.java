package com.kato.hiberus.domain.models;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public record Price (

        Long id,
        Long brandId,
        LocalDateTime startDate,
        LocalDateTime endDate,
        Integer priceList,
        Long productId,
        Integer priority,
        BigDecimal price,
        String currency
) implements Serializable {

    /**
     *
     */
    @Serial
    private static final long serialVersionUID = 1L;

}
