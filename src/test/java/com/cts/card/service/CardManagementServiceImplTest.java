package com.cts.card.service;

import com.cts.card.dao.CardManagementDao;
import com.cts.card.enums.CardType;
import com.cts.card.model.CardDetails;
import com.cts.card.util.TestUtil;
import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CardManagementServiceImplTest {

    @Mock
    CardManagementDao cardManagementDao;

    @InjectMocks
    CardManagementService cardManagementService = new CardManagementServiceImpl();

    @DisplayName("Test add Card Service")
    @Test
    void testAddCard() {
        val responseList = Stream.of(TestUtil.createCardVisa()).collect(Collectors.toList());
        when(cardManagementDao.addCard(any(CardDetails.class))).thenReturn(responseList);
        val cardList = cardManagementService.addCard(TestUtil.createCardVisa());
        assertEquals(CardType.VISA, cardList.get(0).getCardType());
    }

}
