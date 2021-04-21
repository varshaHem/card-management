package com.cts.card.dao;

import com.cts.card.model.CardDetails;
import lombok.val;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Implementation class for CardManagementDao
 * @author varsha
 */
@Repository
public class CardManagementDaoImpl implements CardManagementDao {


    @Override
    public List<CardDetails> addCard(CardDetails cardDetails) {
        return Stream.of(cardDetails).collect(Collectors.toList());
    }

    @Override
    public void freezeCard() {

    }

    @Override
    public void cancelAndReplaceCard() {

    }
}
