package com.msse.web.repository

import com.msse.web.domain.Songs
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

/**
 * Created by z001hk8 on 2/7/17.
 */

interface SongsRepository extends CrudRepository<Songs, Long> {

    @Query("select s from Songs s where s.title like ?1%")
    List<Songs> findAllSongsThatMatchWildcardValue(String wildcard)

}