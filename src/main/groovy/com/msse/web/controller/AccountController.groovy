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
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

import javax.validation.ConstraintViolationException
import java.awt.print.Pageable

@RestController
class AccountController {

    //connect to AccountService for receiving Jason data
    @Autowired
    AccountService accountService

    AccountController(AccountService accountService) {
        this.accountService = accountService
    }

    //A1 and A2
    //Account addAccount(@RequestBody Account account, HttpServletResponse response)
    @PostMapping("/account")
    Account addAccount(@RequestBody Account account) {
        try {
            accountService.addAccount(account)
        } catch (ConstraintViolationException ex) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST, ex.message)
        }
        return accountService.addAccount(account)
    }

    /**

     Note for A1:

     //A1
     /**Receives JSON data to create an Account

     @PostMapping ( " / a c c o u n t " )
      ResponseEntity < Account >  set() {

      Account account = new Account();
      account.setEmail("user@gmail.com");
      account.setPassword("3!321");
      account.setName("User");

      //Using response entity class to modify response header
      return new ResponseEntity<Account>(account, HttpStatus.OK);

      }
     */



    //A3
    @GetMapping("/account/{email}")
    Account getAccount(@PathVariable String email) {
        def account = accountService.getAccount(email)
        System.out.println("name:" + account.name + "email: " + account.email + " password " + account.password)
        return account
    }


    /**

     Note for A2:

     - add exception for invalid data 400 bad request

     - diff way:
     @GetMapping("/account/{email}")
      Account getAccount(@PathVariable String email, HttpServletResponse response) {
      Account account = accountService.getAccount(email)
      if (!account) {
      response.setStatus(404)
      }
      return account
      }
    */


    //A4
    ///account/playlist?page=0&size=3&sort=createdDate,desc
    @GetMapping("/account/playlist")
    Page<Playlist> getPlayLists(Pageable request)
    {
        Page<Playlist> playList =  PlaylistService.getPlayLists(request)
        playList
    }




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
}
