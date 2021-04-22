package com.cts.card.controller;

import com.cts.card.model.CardDetails;
import com.cts.card.service.CardManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Rest Controller that maps all
 * incoming requests
 * @author varsha
 */

@RestController
@Validated
@RequestMapping("api/card")
public class CardManagementController {

    @Autowired
    private CardManagementService cardManagementService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addCard(@RequestBody @Valid CardDetails cardDetails) {
         cardManagementService.addCard(cardDetails);
    }

}
