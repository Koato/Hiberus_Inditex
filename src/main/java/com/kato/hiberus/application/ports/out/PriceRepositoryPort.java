package com.kato.hiberus.application.ports.out;

import com.kato.hiberus.infraestucture.in.dto.PriceDTO;
import java.util.List;

public interface PriceRepositoryPort {

    List<PriceDTO> findAll();
}
