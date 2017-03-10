package com.msse.web.repository

import com.msse.web.domain.Playlist
import com.msse.web.domain.Songs
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.PagingAndSortingRepository

import javax.transaction.Transactional

/**
 * Created by z001hk8 on 2/9/17.
 */
@Transactional
interface PlaylistRepository extends PagingAndSortingRepository<Playlist, Long> {

    @Query("SELECT p from Playlist p WHERE p.name = ?1")
    Playlist findPlaylistWithMatchingName(String name)
}