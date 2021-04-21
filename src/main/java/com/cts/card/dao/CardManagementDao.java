package com.cts.card.dao;

import com.cts.card.model.CardDetails;

import java.util.List;

/**
 * Persistence Layer of CardDetails
 * @author varsha
 */
public interface CardManagementDao {

    List<CardDetails> addCard(CardDetails cardDetails);
    void freezeCard();
    void cancelAndReplaceCard();

}
