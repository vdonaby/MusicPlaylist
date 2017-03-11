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

import javax.validation.ConstraintViolationException

@Service
class AccountService {

    @Autowired
    AccountRepository accountRepository

    //A1
    Account addAccount(Account account) {
        try {
            accountRepository.save(account)
        } catch(ConstraintViolationException e) {
            throw e
            return new ResponseEntity([error: e.message], e.statusCode)
        }

    }


    //A2&A3
    Account getAccount(String email) {

       // Account account = accountRepository.findOne(Email)
        return accountRepository.save(account)


        try{
            account = accountRepository.findByEmail(email)
            System.out.println("Account returned from repo: " + account)
        } catch(Exception e) {
            System.out.println("Error message: " + e.getMessage())
        }
        return account
    }

}