package com.msse.web.repository

import com.msse.web.domain.Account
import org.springframework.data.repository.PagingAndSortingRepository

/**
 A4: Returns the playlists for an Account and is sortable and pageable
 */

//extending CrudRepository to PagingAndSortingRepository
interface AccountRepository extends PagingAndSortingRepository<Account, Integer> {

    Account findByEmail(String Email)

}