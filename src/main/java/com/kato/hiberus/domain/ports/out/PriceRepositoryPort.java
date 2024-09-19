package com.kato.hiberus.domain.ports.out;

import com.kato.hiberus.infraestucture.in.dto.PriceDTO;
import java.util.List;

public interface PriceRepositoryPort {

    List<PriceDTO> findAll();
}
