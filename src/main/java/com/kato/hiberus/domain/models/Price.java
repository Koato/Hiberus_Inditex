package com.kato.hiberus.domain.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Price {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @JsonIgnore
    private Long id;
    private Long brandId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd-HH:mm:ss")
    private LocalDateTime startDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd-HH:mm:ss")
    private LocalDateTime endDate;
    private Integer priceList;
    private Long productId;
    @JsonIgnore
    private Integer priority;
    private BigDecimal price;
    @JsonIgnore
    private String curr;
}
