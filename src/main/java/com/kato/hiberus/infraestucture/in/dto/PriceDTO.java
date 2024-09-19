package com.kato.hiberus.infraestucture.in.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PriceDTO (

        @JsonIgnore
        Long id,
        Long brandId,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd-HH:mm:ss")
        LocalDateTime startDate,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd-HH:mm:ss")
        LocalDateTime endDate,
        Integer priceList,
        Long productId,
        @JsonIgnore
        Integer priority,
        BigDecimal price,
        @JsonIgnore
        String currency
) implements Serializable {

    /**
     *
     */
    @Serial
    private static final long serialVersionUID = 1L;

}
