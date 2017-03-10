package com.msse.web.repository

import com.msse.web.domain.Account
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.PagingAndSortingRepository

/**
 A4: Returns the playlists for an Account and is sortable and pageable
 */

//extending CrudRepository to PagingAndSortingRepository
interface AccountRepository extends PagingAndSortingRepository<Account, Integer> {

   @Query("select a from Account a WHERE a.email =?1")
    Account findByEmail(String email)



}