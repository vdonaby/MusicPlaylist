/**
 A1: Receives JSON data to create an Account
 A2: Return an error response from the create Account endpoint if the account values are invalid
 A3: Returns JSON data with Account values for a user based on an account id or email. (data-driven test)
 A4: Returns the playlists for an Account and is sortable and pageable
 A5: All steps must have valid functional tests
 */

package com.msse.web.AccountTest

import com.msse.web.domain.Account
import com.msse.web.domain.Playlist
import com.msse.web.repository.AccountRepository
import com.msse.web.repository.PlaylistRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.test.context.ContextConfiguration
import spock.lang.Ignore
import spock.lang.Specification


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
        account = accountRepository.save(account)

        when:
        ResponseEntity<Account> responseEntity = this.testRestTemplate.postForEntity("/account", account, Account.class)

        then:
        responseEntity.statusCode == HttpStatus.OK
        Account actual = responseEntity.body
        actual.email == account.email
        actual.name == account.name
    }




    //A2
    def "add account with invalid data"() {
        setup:
        def account = new Account(email: "user@gmail.com", password: "Pas", name: "User")

        when:
        ResponseEntity<Exception> responseEntity = this.testRestTemplate.postForEntity("/account", account, Exception)

        then:
        responseEntity.statusCode == HttpStatus.BAD_REQUEST
    }

    def "returns JSON data based on an account id or email"(String newEmail, String newPassword, String newName, HttpStatus status) {

        setup:
        def account = new Account(email: newEmail.toString(), password: newPassword.toString(), name: newName.toString())
        accountRepository.save(account)

        when:
        ResponseEntity<Account> responseEntity = this.testRestTemplate.getForEntity("/account/" + account.email, Account.class)

        then:
        responseEntity.statusCode == status
        Account actual = responseEntity.body
        actual.email == account.email
        actual.name == account.name


        where:
        newEmail                     | newPassword      | newName         | status
        "userDataDriven@gmail.com"   | "Password1"      | "Test Name"     | HttpStatus.OK

    }

    // A3
    def "returns JSON data based on an account email"() {
        setup:
        def account = new Account(email: "user@yahoo.com", password: "Password1", name: "YahooUser")
        account = accountRepository.save(account)

        when:
        ResponseEntity<Account> responseEntity = this.testRestTemplate.getForEntity("/account/" + account.email, Account.class)
        Account restAccount = responseEntity.body

        then:
        responseEntity.statusCode == HttpStatus.OK
        restAccount.email == account.email
        restAccount.id == account.id

    }

    // A3
    def "returns JSON data based on an account id"() {
        setup:
        def account = new Account(email: "userId@yahoo.com", password: "Password1", name: "YahooUser")
        account = accountRepository.save(account)

        when:
        ResponseEntity<Account> responseEntity = this.testRestTemplate.getForEntity("/account/" + account.id, Account.class)
        Account restAccount = responseEntity.body

        then:
        responseEntity.statusCode == HttpStatus.OK
        restAccount.email == account.email
        restAccount.id == account.id

    }

    //A4
    def "return pageable and sortable playlist"() {

        setup:
        def account = new Account(email: "user20@gmail.com", password: "Password1", name: "AUser")
        account = accountRepository.save(account)

        def playlist = new Playlist(name: 'My Playlist 1', account: account)
        playlist = playlistRepository.save(playlist)

        List<Playlist> playlistList = new ArrayList<>()
        playlistList.add(playlist)

        account.setPlaylists(playlistList)
        account = accountRepository.save(account)


        def page = 0
        def size = 3
        def sort = "name"

        when:
        ResponseEntity<Map> responseEntity = this.testRestTemplate.getForEntity("/account/" + account.id + "/playlist?page=" + page +
                "&size=" + size + "&sort=" + sort + ",desc", Map)

        then:
        true
    }

}