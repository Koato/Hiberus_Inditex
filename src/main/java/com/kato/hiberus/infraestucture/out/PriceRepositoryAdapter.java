package com.kato.hiberus.infraestucture.out;

import com.kato.hiberus.application.ports.out.PriceRepositoryPort;
import com.kato.hiberus.infraestucture.in.dto.PriceDTO;
import com.kato.hiberus.infraestucture.out.mapper.PricePersistenceMapper;
import com.kato.hiberus.infraestucture.out.repository.PriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;

@RequiredArgsConstructor
@Component
public class PriceRepositoryAdapter implements PriceRepositoryPort {

    private final PriceRepository priceRepository;

    private final PricePersistenceMapper mapper;

    @Override
    public List<PriceDTO> findAll() {
        return priceRepository.findAll().stream().map(mapper::toDomain).toList();
    }
}
