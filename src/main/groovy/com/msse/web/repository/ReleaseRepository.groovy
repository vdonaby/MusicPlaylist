package com.msse.web.repository

import com.msse.web.domain.Release
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

/**
 * Created by z001hk8 on 2/8/17.
 */

interface ReleaseRepository extends CrudRepository<Release, Long> {

    @Query("select r from Release r where r.title like ?1%")
    List<Release> findAllReleasesThatMatchWildcardValue(String title)
}