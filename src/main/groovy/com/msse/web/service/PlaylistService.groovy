package com.msse.web.service

import com.msse.web.domain.Playlist
import com.msse.web.repository.PlaylistRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.stereotype.Service

import java.awt.print.Pageable
/**
 * Created by z001hk8 on 3/5/17.
 */

@Service
class PlaylistService {

    @Autowired
    PlaylistRepository playlistRepository

    Playlist addPlaylistService(Playlist playlist) {
        return playlistRepository.save(playlist)
    }
}
