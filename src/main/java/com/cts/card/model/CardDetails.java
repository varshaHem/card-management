package com.cts.card.model;

import com.cts.card.enums.AccountType;
import com.cts.card.enums.CardType;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

/**
 * Entity class for Storing Card Details
 * @author varsha
 */
@Data
@AllArgsConstructor
public class CardDetails {

    private String customerName;
    private String cardNumber;
    private LocalDate expiryDate;
    private CardType cardType;
    private String accountNo;
    private AccountType accountType;
    private double withdrawalLimit;
    private double dailyPaymentLimit;

}
