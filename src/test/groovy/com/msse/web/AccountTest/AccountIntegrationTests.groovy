package com.msse.web.AccountTest

import com.msse.web.controller.AccountController
import com.msse.web.domain.Account
import com.msse.web.service.AccountService
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import com.fasterxml.jackson.databind.ObjectMapper
import spock.lang.Ignore
import spock.lang.Specification

/**
 A6: Create integration tests for Account
 */

@ContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AccountIntegrationTests extends Specification {

    @Ignore
    def "get account"() {
        setup:
        def accountService = Mock(AccountService)
        def accountController = new AccountController (accountService: accountService)
        def mockMvc = MockMvcBuilders.standaloneSetup(accountController).build()

        //check auto generated id if not, then added and getAccount(enter id here)
        def account = new Account(Email: "user@gmail.com", password: "3!321", name: "User")

        ObjectMapper mapper = ObjectMapper.newInstance()

        when:
        mockMvc.perform(get("/users/Email"))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(content().json(mapper.writeValueAsString(account)))

        then:
        1 * accountService.getAccount("user@gmail.com") >> account
    }

    @Ignore
    def "post account"(){
        setup:
        def accountService = Mock(AccountService)
        def accountController = new AccountController(accountService: accountService)
        def mockMvc = MockMvcBuilders.standaloneSetup(accountController).build()

        //check auto generated id if not, then added and getAccount(enter id here)
        def account = new Account(Email: "user@gmail.com", password: "3!321", name: "User")

        ObjectMapper mapper = ObjectMapper.newInstance()

        when:
        mockMvc.perform(post("/account")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(mapper.writeValueAsString(account)))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(content().json(mapper.writeValueAsString(account)))

        then:
        1 * accountService.addAccount(_) >> {
            return account
        }
    }



}
