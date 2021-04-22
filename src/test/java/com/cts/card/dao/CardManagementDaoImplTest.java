package com.cts.card.dao;

import com.cts.card.model.CardDetails;
import com.cts.card.util.TestUtil;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CardManagementDaoImplTest {

    @Mock
    List<CardDetails> cardDetailsList;

    @Test
    public void testAddCard() {
        val actualCardDetailList = Stream.of(TestUtil.createCardMasterCard(), TestUtil.createCardVisa())
                                          .collect(Collectors.toList());
        assertEquals(2, actualCardDetailList.size());

    }
}
