package com.msse.web.repository

import com.msse.web.domain.Playlist
import org.springframework.data.repository.PagingAndSortingRepository

/**
 * Created by z001hk8 on 2/9/17.
 */
interface PlaylistRepository extends PagingAndSortingRepository<Playlist, Long> {

}