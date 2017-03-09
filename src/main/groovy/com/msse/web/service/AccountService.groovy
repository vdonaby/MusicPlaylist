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
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.client.RestTemplate

import javax.servlet.http.HttpServletResponse

@Service
class AccountService {

    @Autowired
    AccountRepository accountRepository


    Account addAccount(Account account) {
        return accountRepository.save(account)
    }

    //A1
    /**Receives JSON data to create an Account

     @PostMapping("/account")
     ResponseEntity<Account> set() {

     Account account = new Account();
     account.setEmail("user@gmail.com");
     account.setPassword("3!321");
     account.setName("User");

     return new ResponseEntity<Account>(account, HttpStatus.OK);
     }
     */


    //A1
    @PostMapping("/account")
    Account setAccountData() {
        RestTemplate restTemplate = new RestTemplate()
        Account account = restTemplate.postForObject("http://localhost:8080/data/accountData.json", Account.class)
        return account
    }

    //A2

    /**a
     - add exception for invalid data 400 bad request

     - diff way:
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
     */
     @GetMapping('/account/{Email}')
      Account getAccount(@PathVariable String Email, HttpServletResponse response) {
      RestTemplate restTemplate = new RestTemplate()
      Account aacount = restTemplate.getForObject("http://localhost:8080/data/accountData.json", Account.class)
      if (!aacount) {
      response.setStatus(400)
      }
      return aacount
      }


    //A3

    // Page<Playlist> listAllPlayLists (Pageable pageable)


    //A4




}