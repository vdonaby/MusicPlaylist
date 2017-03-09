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
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

import java.awt.print.Pageable

@RestController
/**
-can be added.
@RequestMapping ("/account") --why

-Json file can be added as MediaType
 */
class AccountController {


    //connect to AccountService for receiving Jason data
    @Autowired
    AccountService accountService
    AccountController(AccountService accountService){
        this.accountService = accountService
    }

    //psot an account
    @PostMapping('/account')
    Account addAcount(@RequestBody Account account) {
        return accountService.addAcount(account)
    }


    /**
     Using response entity class to modify response header


     */

   /** @GetMapping('')
    Page list(Pageable pageable) {
        return postService.listPosts(pageable)
    }
 **/

    /**pass Pageable instance to Accountservice,
     which then pass it to AccountRepository
     check sorting lists

     diff way:
     //localhost:8080/playlists?page=0&size=2&sort=createdDate,desc
     @GetMapping('/playlists')
      Page playlist(Pageable pageable) {
      return PlaylistService.playlist(pageable)
      }
     */

    @GetMapping('/account/{accountId}/playlists')
    // return playlists pageable and sortable
    Page<Playlist> getPlayLists(Pageable request)
    {
        Page<Playlist> playList =  PlaylistService.getPlayLists(request)
        playList
    }

}