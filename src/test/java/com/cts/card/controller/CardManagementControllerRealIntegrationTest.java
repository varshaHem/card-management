package com.cts.card.controller;

import com.cts.card.model.CardDetails;
import com.cts.card.util.TestUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CardManagementControllerRealIntegrationTest {

    // bind the above RANDOM_PORT
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private String getRootUrl() {
        return "http://localhost:" + port;
    }

    private String getUrl() {

        return getRootUrl() + "api/card";
    }

    @Test
    public void testAddCardWhenInvalidInput() {
        CardDetails mockCard = TestUtil.createCardVisa();
        mockCard.setCardNumber("");
        ResponseEntity<Void> responseEntity = restTemplate.postForEntity(getUrl(), mockCard, Void.class);
       assertEquals(HttpStatus.BAD_REQUEST.value(), responseEntity.getStatusCodeValue());

    }


    @Test
    public void testAddCard() {
        CardDetails mockCard = TestUtil.createCardVisa();
        ResponseEntity<Void> responseEntity = restTemplate.postForEntity(getUrl(), mockCard, Void.class);
        assertEquals(HttpStatus.CREATED.value(), responseEntity.getStatusCode().value());

    }

}
