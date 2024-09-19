package com.kato.hiberus.infraestucture.out.mapper;

import com.kato.hiberus.infraestucture.in.dto.PriceDTO;
import com.kato.hiberus.infraestucture.out.entities.PriceEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PricePersistenceMapper {

    PriceDTO toDomain(PriceEntity priceEntity);
}
