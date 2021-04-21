package com.cts.card.controller;

import com.cts.card.model.CardDetails;
import com.cts.card.service.CardManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Rest Controller that maps all
 * incoming requests
 * @author varsha
 */

@RestController
@RequestMapping("api/card")
public class CardManagementController {

    @Autowired
    private CardManagementService cardManagementService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public List<CardDetails> addCard(@RequestBody CardDetails cardDetails) {
        return cardManagementService.addCard(cardDetails);
    }

}
