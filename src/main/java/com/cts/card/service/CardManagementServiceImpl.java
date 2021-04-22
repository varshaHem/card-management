package com.cts.card.service;

import com.cts.card.dao.CardManagementDao;
import com.cts.card.model.CardDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardManagementServiceImpl implements CardManagementService {

    private static final Logger logger = LoggerFactory.getLogger(CardManagementServiceImpl.class);

    @Autowired
    CardManagementDao cardManagementDao;

    @Override
    public void addCard(CardDetails cardDetails) {
        cardManagementDao.addCard(cardDetails);
    }

}
