package com.kato.hiberus.infraestucture.out.repository;

import com.kato.hiberus.infraestucture.out.entities.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository extends JpaRepository<PriceEntity, Long> {

}
