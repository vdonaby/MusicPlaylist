package com.msse.web.repository

import com.msse.web.domain.Account
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.PagingAndSortingRepository

/**
 A4: Returns the playlists for an Account and is sortable and pageable
 */

interface AccountRepository extends PagingAndSortingRepository<Account, Long> {

    @Query("SELECT a from Account a WHERE a.email like ?1%")
    Account findByEmail(String email)
}