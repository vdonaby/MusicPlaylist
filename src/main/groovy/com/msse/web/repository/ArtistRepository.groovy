package com.msse.web.repository

import com.msse.web.domain.Artist
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

/**
 * Created by z001hk8 on 2/11/17.
 */
interface ArtistRepository extends CrudRepository<Artist, Long> {

    @Query("select a from Artist a where a.name like ?1%")
    List<Artist> findAllArtistThatMatchWildcardValue(String name)
}