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
import com.msse.web.service.AccountService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.*

import javax.servlet.http.HttpServletResponse
import javax.validation.ConstraintViolationException

@RestController
class AccountController {

    //connect to AccountService for receiving Jason data
    @Autowired
    AccountService accountService

    //A1 and A2
    @PostMapping("/account")
    Account addAccount(@RequestBody Account account, HttpServletResponse response) {
        try {
            accountService.addAccount(account)
        } catch (ConstraintViolationException ex) {
            return response.setStatus(400)
        }
        return accountService.addAccount(account)
    }

    //A3
    @GetMapping("/account/{email}")
    Account getAccount(@PathVariable String email) {
        def account = accountService.getAccount(email)
        return account
    }

    //A4
    ///account/playlist?page=0&size=3&sort=createdDate,desc
    @GetMapping("/account/{accountId}/playlist")
    Page getPlayLists(@PathVariable String accountId, Pageable request)
    {
        return accountService.getPlayLists(request, accountId)
    }
}
