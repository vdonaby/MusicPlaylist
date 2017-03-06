package com.msse.web.controller

import com.msse.web.repository.AccountRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.ResponseBody

//import org.springframework.data.domain.Sort
//import javax.swing.JTabbedPane.Page
//import java.awt.print.Pageable
//import org.springframework.data.domain.PageRequest

//import com.msse.web.domain.Account

/**
 A1: Receives JSON data to create an Account
 A2: Return an error response from the create Account endpoint if the account values are invalid
 A3: Returns JSON data with Account values for a user based on an account id or email. (data-driven test)
 A4: Returns the playlists for an Account and is sortable and pageable
 A5: All steps must have valid functional tests
 A6: Create integration tests for Account
 */

@RestController
@RequestMapping ("/createAccount")
class AccountRestController {


    AccountRepository accountRepo

    @RequestMapping(value = "/account" , method = RequestMethod.POST)
    @ResponseBody

//json data =

    @Autowired
    public AccountController(AccountRepository accountRepo) {

        this.accountRepo = accountRepo

    }

    /**sortable and pageable example

     Page page = postService.listPosts(new PageRequest(request.pageNumber,
     request.pageSize, new Sort(Sort.Direction.DESC, "createdDate")))

     */

}