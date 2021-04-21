package com.cts.card.service;

import com.cts.card.dao.CardManagementDao;
import com.cts.card.model.CardDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardManagementServiceImpl implements CardManagementService {

    @Autowired
    CardManagementDao cardManagementDao;

    @Override
    public List<CardDetails> addCard(CardDetails cardDetails) {
        return cardManagementDao.addCard(cardDetails);
    }

    @Override
    public void freezeCard() {

    }

    @Override
    public void cancelAndReplaceCard() {

    }
}
