package com.kato.hiberus.infraestucture.controllers;

import com.kato.hiberus.application.services.PriceService;
import com.kato.hiberus.domain.models.Price;
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

    private final PriceService priceService;

    @GetMapping(value = "/price")
    public ResponseEntity<Price> getPrice(
            @RequestParam(value = "applicationDate", required = true)
            @DateTimeFormat(pattern = "yyyy-MM-dd-HH:mm:ss") LocalDateTime applicationDate,
            @RequestParam(value = "productId", required = true) Long productId,
            @RequestParam(value = "brandId", required = true) Long brandId) {
        return priceService.getPrice(applicationDate, productId, brandId)
                .map(price -> new ResponseEntity<>(price, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
