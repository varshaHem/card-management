package com.cts.card.service;

import com.cts.card.model.CardDetails;

import java.util.List;

/**
 * Interface for CardManagement Service
 * @author varsha
 */
public interface CardManagementService {

     List<CardDetails> addCard(CardDetails cardDetails);
     void freezeCard();
     void cancelAndReplaceCard();

}
