package com.msse.web.controller

import com.msse.web.domain.Playlist
import com.msse.web.service.PlaylistService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by z001hk8 on 1/27/17.
 */
@RestController
class PlaylistController {

    @Autowired
    PlaylistService playlistService

    @PostMapping("/playlist")
    Playlist addPlaylist(@RequestBody Playlist playlist) {
        return playlistService.addPlaylistService(playlist)
    }
}
