package com.msse.web.controller

import com.msse.web.domain.Account
import com.msse.web.domain.Playlist
import com.msse.web.domain.Songs
import com.msse.web.repository.AccountRepository
import com.msse.web.repository.PlaylistRepository
import com.msse.web.repository.SongsRepository
import com.msse.web.service.PlaylistService
import org.hibernate.mapping.Collection
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

/**
 * Created by z001hk8 on 1/27/17.
 */
@RestController
class PlaylistController {

    @Autowired
    PlaylistService playlistService

    @Autowired
    AccountRepository accountRepository

    @Autowired
    SongsRepository songsRepository

    @Autowired
    PlaylistRepository playlistRepository

    @PostMapping("/playlist")
    Playlist addPlaylist(@RequestBody Playlist playlist) {
        accountRepository.save(playlist.getAccount());
        return playlistService.addPlaylistService(playlist)
    }

    @PostMapping("/playlist/name/{playlistName}")
    Playlist addSongToPlaylist(@RequestBody Songs songs, @PathVariable String playlistName) {
        def playlist = playlistRepository.findPlaylistWithMatchingName(playlistName)
        playlist.songs.add(songs)
        return playlistRepository.save(playlist)
    }
}
