package com.msse.web.repository

import com.msse.web.domain.Account
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.PagingAndSortingRepository
//import org.springframework.data.domain.Sort

/**
 A4: Returns the playlists for an Account and is sortable and pageable
 */

interface AccountRepository extends PagingAndSortingRepository<Account, String> {

    //   Page result = accountRepository.findByEmailOrAccountId(accountId, request.getPageNumber(), request.getPageSize())
    @Query("SELECT a from Account a WHERE a.email like ?1% OR a.id like ?1%")
    Account findByEmailOrAccountId(String emailOrId, Integer page, Integer size)

    /**
     @Query("SELECT a from PlayList a WHERE a.email like ?1% OR a.id like ?1%")
      Account findByEmailOrAccountId(String emailOrId, Pageable)
     */


}