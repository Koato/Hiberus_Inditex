package com.kato.hiberus;

import com.kato.hiberus.infraestucture.in.dto.PriceDTO;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HiberusApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Order(1)
    @Test
    void test1() {
        String url = "http://localhost:" + port + "/api/inditex/price?applicationDate=2020-06-14-10:00:00&productId=35455&brandId=1";

        ResponseEntity<PriceDTO> response = restTemplate.getForEntity(url, PriceDTO.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().price()).isEqualTo("35.50");
    }
}
