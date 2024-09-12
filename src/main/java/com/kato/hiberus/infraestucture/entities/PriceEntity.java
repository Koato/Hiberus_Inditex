package com.kato.hiberus.infraestucture.entities;

import com.kato.hiberus.domain.models.Price;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "PRICES")
public class PriceEntity  implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "BRAND_ID", nullable = false, length = 1)
    private Long brandId;

    @Column(name = "START_DATE", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "END_DATE", nullable = false)
    private LocalDateTime endDate;

    @Column(name = "PRICE_LIST", nullable = false, length = 1)
    private Integer priceList;

    @Column(name = "PRODUCT_ID", nullable = false, length = 5)
    private Long productId;

    @Column(name = "PRIORITY", nullable = false)
    private Integer priority;

    @Column(name = "PRICE", nullable = false, scale = 2)
    private BigDecimal price;

    @Column(name = "CURR", nullable = false, length = 3)
    private String curr;

    public static PriceEntity fromDomainModel(Price price) {
        return new PriceEntity(price.getId(), price.getBrandId(), price.getStartDate(),
                price.getEndDate(), price.getPriceList(), price.getProductId(),
                price.getPriority(), price.getPrice(), price.getCurr());
    }

    public Price toDomainModel(){
        return new Price(id, brandId, startDate, endDate, priceList, productId, priority, price, curr);
    }
}
