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
import com.msse.web.repository.PlaylistRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
//import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

import javax.validation.ConstraintViolationException

@Service
class AccountService {

    @Autowired
    AccountRepository accountRepository

    @Autowired
    PlaylistRepository playlistRepository

    //A1
    Account addAccount(Account account) {
        try {
            accountRepository.save(account)
        } catch(ConstraintViolationException ex) {
            throw ex
        }

    }

    //A2&A3
    Account getAccount(String emailOrId) {
        return accountRepository.findByEmailOrAccountId(emailOrId)
    }



    //A4
    Page getPlayLists(String accountId, Pageable request) {

        Page result = accountRepository.findByEmailOrAccountId(accountId, request.getPageNumber(), request.getPageSize())
//        for(Account account: result.getContent()) {
//            if(!account.id == accountId) {
//                result.content.remove()
//            }
//        }
        return result

        /**

          Page getPlayLists(String accountId, Integer page, Integer size, Sort sort, Pageable request) {

          //1- find a playlist for an account
          Page result = accountRepository.findByEmailOrAccountId(accountId, request)

          if (result)
         {
           // 2- Returns the playlists for this Account and is sortable and pageable
           // how we customize page, size and sort
            return result.getContent().getSort()
         }
         */


    }
}