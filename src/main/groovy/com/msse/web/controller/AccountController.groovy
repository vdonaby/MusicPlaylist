/**
 A1: Receives JSON data to create an Account
 A2: Return an error response from the create Account endpoint if the account values are invalid
 A3: Returns JSON data with Account values for a user based on an account id or email. (data-driven test)
 A4: Returns the playlists for an Account and is sortable and pageable
 A5: All steps must have valid functional tests
 A6: Create integration tests for Account
 */

package com.msse.web.controller

import com.msse.web.domain.Account
import com.msse.web.domain.Playlist
import com.msse.web.service.AccountService
import com.msse.web.service.PlaylistService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate

import javax.servlet.http.HttpServletResponse
import java.awt.print.Pageable

@RestController
/**
-can be added.
@RequestMapping ("/account")

-Json file can be added as MediaType
 */
class AccountController {


    //connect to AccountService for receiving Jason data
    @Autowired
    AccountService accountService
    AccountController (AccountService accountService){
        this.accountService = accountService
    }


    //A1
    @PostMapping("/account")
    Account addAccount() {
        RestTemplate restTemplate = new RestTemplate()
        Account account = restTemplate.postForObject("http://localhost:8080/static/accountData.json", Account.class)
        return accountService.addAccount(account)
    }

    /**

    Note for A1:

    @PostMapping("/account")
     Account addAcount(@RequestBody Account account) {
     return accountService.addAcount(account)
     }

     //A1
     /**Receives JSON data to create an Account

     @PostMapping("/account")
      ResponseEntity<Account> set() {

      Account account = new Account();
      account.setEmail("user@gmail.com");
      account.setPassword("3!321");
      account.setName("User");

      //Using response entity class to modify response header
      return new ResponseEntity<Account>(account, HttpStatus.OK);


      }
     */


    //A2 and A3

    @GetMapping("/account/{Email}")
    Account getAccount(@PathVariable String Email, HttpServletResponse response) {
        RestTemplate restTemplate = new RestTemplate()
        Account account = restTemplate.getForObject("http://localhost:8080/static/accountData.json", Account.class)
        if (!account) {
            response.setStatus(400)
        }
        return accountService.getAccount(Email)
    }

    /**

     Note for A2:

     - add exception for invalid data 400 bad request

     - diff way:
     // check which works better "try and catch" vs. throw
     @GetMapping("/account")
      Account getAccountData() {
      try {
      RestTemplate restTemplate = new RestTemplate()
      Account account = restTemplate.getForObject("http://localhost:8080/static/accountData.json", Account.class)
      return account
      }
      catch (HttpClientErrorException ex) {
      return new ResponseEntity([error: ex.message], ex.statusCode)
      }
      }
     */


    //A4

    @GetMapping("/account/playlist?page=0&size=3&sort=createdDate,desc")
    /** return playlist pageable and sortable
     */
    Page<Playlist> getPlayLists(Pageable request)
    {
        Page<Playlist> playList =  PlaylistService.getPlayLists(request)
        playList
    }

}
/**
 /**pass Pageable instance to Accountservice,
 which then pass it to AccountRepository
 check sorting lists

 Q: since each account has its playlist,
 do we need to include @PathVariable String Email
 then @GetMapping('/account/{Email}/playlists')

 diff way:
 //localhost:8080/playlists?page=0&size=2&sort=createdDate,desc
 @GetMapping('/playlists')
  Page playlist(Pageable pageable) {
  return PlaylistService.playlist(pageable)
  }

  example/
 @GetMapping('')
  Page list(Pageable pageable) {
  return postService.listPosts(pageable)
  }
 */


