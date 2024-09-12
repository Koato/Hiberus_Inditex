package com.kato.hiberus.infraestucture.repository;

import com.kato.hiberus.infraestucture.entities.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaPriceRepository extends JpaRepository<PriceEntity, Long> {
}
