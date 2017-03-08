/**
 A1: Receives JSON data to create an Account
 A2: Return an error response from the create Account endpoint if the account values are invalid
 A3: Returns JSON data with Account values for a user based on an account id or email. (data-driven test)
 A4: Returns the playlists for an Account and is sortable and pageable
 A5: All steps must have valid functional tests
 A6: Create integration tests for Account
 */


package com.msse.web.service

import com.msse.web.domain.Account
import com.msse.web.repository.AccountRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.client.HttpClientErrorException
import org.springframework.web.client.RestTemplate

@Service
class AccountService {

    @Autowired
    AccountRepository accountRepository


    Account addAccount(Account account) {
        return accountRepository.save(account)
    }

    //A1
    // Receives JSON data to create an Account


    @PostMapping("/account")
    Account setAccountData() {
        RestTemplate restTemplate = new RestTemplate()
        Account account = restTemplate.postForObject("http://localhost:8080/data/accountData.json", Account.class)
        return account
    }

    //A2
    //add exception for invalid data 400 bad request
    // check which works better "try and catch" vs. throw
    @GetMapping("/account")
    Account getAccountData() {
        try {
            RestTemplate restTemplate = new RestTemplate()
            Account account = restTemplate.getForObject("http://localhost:8080/data/accountData.json", Account.class)
            return account
        }
        catch (HttpClientErrorException ex) {
            return new ResponseEntity([error: ex.message], ex.statusCode)
        }
    }

    //A3

       // Page<Playlist> listAllPlayLists (Pageable pageable)


    //A4




}