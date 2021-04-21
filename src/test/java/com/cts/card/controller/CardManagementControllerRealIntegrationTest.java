package com.cts.card.controller;

import com.cts.card.enums.CardType;
import com.cts.card.model.CardDetails;
import com.cts.card.model.CardDetailsList;
import com.cts.card.util.TestUtil;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
    public void testAddCard() {
        CardDetails mockCard = TestUtil.createCardVisa();
        ResponseEntity<CardDetailsList> listResponseEntity = restTemplate.postForEntity(getUrl(), mockCard, CardDetailsList.class);
        assertEquals(HttpStatus.CREATED, listResponseEntity.getStatusCode());
        assertNotNull(listResponseEntity.getBody());
        assertEquals(CardType.VISA, listResponseEntity.getBody().get(0).getCardType());

    }

}
