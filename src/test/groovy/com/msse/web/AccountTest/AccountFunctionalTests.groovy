package com.msse.web.AccountTest

import com.msse.web.domain.Account
import com.msse.web.repository.AccountRepository
import com.msse.web.repository.PlaylistRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification
import org.springframework.http.ResponseEntity
import org.springframework.http.HttpStatus

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

    def "get account with valid data"() {
        setup:
        def account = new Account(Email: "abc@gmail.com", password: "lifeis1!", name: "ice")
        accountRepository.save(account)

        when:
        ResponseEntity <Map> responseEntity = testRestTemplate.getForEntity("/account", Map)

        then:
        responseEntity.statusCode == HttpStatus.OK

    }

}
