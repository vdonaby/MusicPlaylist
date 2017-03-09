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

@Service
class AccountService {

    @Autowired
    AccountRepository accountRepository


    //A1
    Account addAccount(Account account) {


        return accountRepository.save(account)
    }


    //A2
    Account getAccount(String Email) {

        Account account = userRepository.findOne(Email)
        return postRespository.save(account)
    }

    //A3

    // Page<Playlist> listAllPlayLists (Pageable pageable)


    //A4


}