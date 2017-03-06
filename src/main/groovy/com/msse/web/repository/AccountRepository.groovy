package com.msse.web.repository

import com.msse.web.domain.Account
import org.springframework.data.repository.CrudRepository

/**
 * Created by z001hk8 on 2/9/17.
 */
interface AccountRepository extends CrudRepository<Account, Long> {

}