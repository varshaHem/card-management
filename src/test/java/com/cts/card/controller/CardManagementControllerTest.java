package com.cts.card.controller;

import com.cts.card.CardApplication;
import com.cts.card.enums.AccountType;
import com.cts.card.enums.CardType;
import com.cts.card.util.TestUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * Integration test using Junit 5
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = CardApplication.class)
@WebAppConfiguration
public class CardManagementControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    private static final String CONTENT_TYPE = "application/json";
    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    public void testAddCard() throws Exception {
        String content = TestUtil.createDummyDataAndGetJsonString();
        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/card")
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .content(content)
                                        .accept(MediaType.APPLICATION_JSON)).andDo(print())
                                        .andExpect(MockMvcResultMatchers.status().isCreated())
                                        .andExpect(MockMvcResultMatchers.content().contentType(CONTENT_TYPE))
                                        .andExpect(MockMvcResultMatchers.jsonPath("$[0].accountType").value(AccountType.PERSONAL.toString()))
                                        .andExpect(MockMvcResultMatchers.jsonPath("$[0].cardType").value(CardType.MAESTRO.toString()));

    }




}
