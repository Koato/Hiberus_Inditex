package com.kato.hiberus.infraestucture.in.controllers;

import com.kato.hiberus.application.ports.in.RetrievePriceUseCase;
import com.kato.hiberus.infraestucture.in.dto.PriceDTO;
import com.kato.hiberus.infraestucture.in.mapper.PriceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/inditex")
public class PriceController {

    private final RetrievePriceUseCase retrievePriceUseCase;

    private final PriceMapper priceMapper;

    @GetMapping(value = "/price")
    public ResponseEntity<PriceDTO> getPrice(
            @RequestParam(value = "applicationDate", required = true)
            @DateTimeFormat(pattern = "yyyy-MM-dd-HH:mm:ss") LocalDateTime applicationDate,
            @RequestParam(value = "productId", required = true) Long productId,
            @RequestParam(value = "brandId", required = true) Long brandId) {
        return retrievePriceUseCase.getPrice(applicationDate, productId, brandId)
                .map(price -> new ResponseEntity<>(priceMapper.toEntity(price), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
