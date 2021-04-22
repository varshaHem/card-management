package com.cts.card.util;

import com.cts.card.enums.AccountType;
import com.cts.card.enums.CardType;
import com.cts.card.model.CardDetails;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TestUtil {


    public static String createDummyDataAndGetJsonString() throws JsonProcessingException {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-d");
        String expiryDate = dtf.format(LocalDate.now());
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        LocalDate localDate = LocalDate.parse(expiryDate);
        CardDetails testCard = new CardDetails("V. Hemnani",
                "6734 0001 0014 3773 001",
                localDate,
                CardType.MAESTRO,
                "0100143773",
                AccountType.PERSONAL,
                new BigDecimal(500),
                new BigDecimal(2500));
        return mapper.writeValueAsString(testCard);
    }

    public static CardDetails createCardVisa() {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-d");
        String expiryDate = dtf.format(LocalDate.now());
        LocalDate localDate = LocalDate.parse(expiryDate);
        return new CardDetails("V. Hemnani",
                "4734 0001 0014  0001",
                localDate,
                CardType.VISA,
                "0100143773",
                AccountType.PERSONAL,
                new BigDecimal(500),
                new BigDecimal(1000));

    }

    public static CardDetails createCardMasterCard() {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-d");
        String expiryDate = dtf.format(LocalDate.now());
        LocalDate localDate = LocalDate.parse(expiryDate);
        return new CardDetails("V. Hemnani",
                "5734 0001 0014  0001",
                localDate,
                CardType.MASTERCARD,
                "0100140001",
                AccountType.PERSONAL,
                new BigDecimal(600),
                new BigDecimal(1000));

    }
}
