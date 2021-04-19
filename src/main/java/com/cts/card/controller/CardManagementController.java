package com.cts.card.controller;

import com.cts.card.service.CardManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest Controller that maps all
 * incoming requests
 * @author varsha
 */

@RestController
@RequestMapping("api/cards")
public class CardManagementController {

    @Autowired
    CardManagementService cardManagementService;

}
