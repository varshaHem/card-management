package com.cts.card.service;

import com.cts.card.dao.CardManagementDao;
import com.cts.card.model.CardDetails;
import com.cts.card.util.TestUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CardManagementServiceImplTest {

    @Mock
    CardManagementDao cardManagementDao;

    @InjectMocks
    CardManagementService cardManagementService = new CardManagementServiceImpl();


    @DisplayName("Test add Card Service")
    @Test
    void testAddCard() {
        doNothing().when(cardManagementDao).addCard(any(CardDetails.class));
        cardManagementService.addCard(TestUtil.createCardVisa());
        verify(cardManagementDao, times(1)).addCard(TestUtil.createCardVisa());
    }

}
