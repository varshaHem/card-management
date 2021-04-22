package com.cts.card.model;

import com.cts.card.enums.AccountType;
import com.cts.card.enums.CardType;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Entity class for Storing Card Details
 * @author varsha
 */
@Data
@AllArgsConstructor
public class CardDetails {
    @NotNull
    private String customerName;
    @NotNull
    @NotEmpty
    private String cardNumber;
    @NotNull
    private LocalDate expiryDate;
    @NotNull
    private CardType cardType;
    @NotNull
    private String accountNo;
    @NotNull
    private AccountType accountType;
    @NotNull
    private BigDecimal withdrawalLimit;
    @NotNull
    private BigDecimal dailyPaymentLimit;

}
