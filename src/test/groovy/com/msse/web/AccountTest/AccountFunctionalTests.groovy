package com.msse.web.AccountTest

import com.msse.web.domain.Account
import com.msse.web.repository.AccountRepository
import com.msse.web.repository.PlaylistRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

import java.awt.PageAttributes.MediaType
/**
 A1: Receives JSON data to create an Account
 A2: Return an error response from the create Account endpoint if the account values are invalid
 A3: Returns JSON data with Account values for a user based on an account id or email. (data-driven test)
 A4: Returns the playlists for an Account and is sortable and pageable
 A5: All steps must have valid functional tests
 */


@ContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AccountFunctionalTests extends Specification {

    @Autowired
    TestRestTemplate testRestTemplate

    @Autowired
    AccountRepository accountRepository

    @Autowired
    PlaylistRepository playlistRepository



    //A1

    def "add account with valid data"() {
        setup:
        def account = new Account(email: "user@gmail.com", password: "Password1", name: "User")
        accountRepository.save(account)

        when:
        ResponseEntity <Account> responseEntity = this.testRestTemplate.postForEntity("/account",
                new Account(email: "user@gmail.com", password: "Password1", name: "User"), Account.class)

        then:
        responseEntity.statusCode == HttpStatus.OK
        responseEntity.headers.getContentType() == MediaType.APPLICATION_JSON_UTF8
        Account actual = responseEntity.body
        actual.Email == "user@gmail.com"
        actual.password == "3!321"
        actual.name == "User"

    }



    /**
     A2
     does A2 include A1 since there is a response's type. or test te response error 400
     HttpStatus.OK is 200 == means OK
     */

    def "get account"() {
        setup:
        def account = new Account(email: "user@gmail.com", password: "Password1", name: "User")
        accountRepository.save(account)

        when:
        ResponseEntity <Account> responseEntity = this.testRestTemplate.getForEntity("/account/user@gmail.com", Account)

        then:
        responseEntity.statusCode == HttpStatus.OK
        Account actual = responseEntity.body
        actual.Email == "user@gmail.com"
        actual.password == "3!321"
        actual.name == "User"
    }


    //A3
    /**
    A3
     modify it to data-driven test email or id
     */

    def "return account data based on email" () {

        setup:
        AccountRepository accountRepository = Mock(AccountRepository)
        context.getBean(AccountRepository).accountRepository = accountRepository

        when:
        def result = testRestTemplate.getForObject('/cars/{Email}', Account)

        then:
        1 * accountRepository.findByEmail("abc@gmail.com") >> new Account(name: "User", password: "Password1")
        1 * accountRepository.findByEmail("abc@gmail.com") >> new Account(name: "User", password: "Password1")
        result.name == "User"
        result.name == "3!321"

    }


    //A4
    //check if there is another way to test pageable and sortable
    def "get playlist pageable and sortable"() {

        setup:
            def account = new Account()
        when:
            (1..3).each{
            account = new Account(name:"User $it")}
        then:
        accountRepository.save(account)

        }

    }





