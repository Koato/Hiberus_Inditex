package com.kato.hiberus.infraestucture.config;

import com.kato.hiberus.application.services.PriceService;
import com.kato.hiberus.application.usecases.RetrievePriceUseCaseImpl;
import com.kato.hiberus.domain.ports.out.PriceRepositoryPort;
import com.kato.hiberus.infraestucture.repository.JpaPriceRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public PriceService priceService(PriceRepositoryPort priceRepositoryPort) {
        return new PriceService(new RetrievePriceUseCaseImpl(priceRepositoryPort));
    }

    @Bean
    public PriceRepositoryPort priceRepositoryPort(JpaPriceRepositoryAdapter jpaPriceRepositoryAdapter) {
        return jpaPriceRepositoryAdapter;
    }
}
