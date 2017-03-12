package com.msse.web.AccountTest

import com.msse.web.controller.AccountController
import com.msse.web.domain.Account
import com.msse.web.service.AccountService
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import com.fasterxml.jackson.databind.ObjectMapper
import spock.lang.Specification
import org.springframework.http.MediaType
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

/**
 A6: Create integration tests for Account
 */

@ContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AccountIntegrationTests extends Specification {

    def "get account"() {

        setup:
        def mockAccountService = Mock(AccountService)
        AccountController accountController = new AccountController(accountService: mockAccountService)
        def mockMvc = MockMvcBuilders.standaloneSetup(accountController).build()
        //check auto generated id if not, then added and getAccount(enter id here)
        def account = new Account(email: "user@gmail.com", password: "password1", name: "User")

        ObjectMapper mapper = ObjectMapper.newInstance()

        when:
        mockMvc.perform(get("/account/" + account.email).accept(MediaType.parseMediaType("application/json;charset=UTF-8")))


        then:
        true
        1 * mockAccountService.getAccount('user@gmail') >> account

    }
}
