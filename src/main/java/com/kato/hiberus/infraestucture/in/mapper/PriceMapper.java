package com.kato.hiberus.infraestucture.in.mapper;

import com.kato.hiberus.domain.models.Price;
import com.kato.hiberus.infraestucture.in.dto.PriceDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PriceMapper {

    PriceDTO toEntity(Price price);
    List<Price> toPrices(List<PriceDTO> priceDTO);
}
