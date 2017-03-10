package com.msse.web.controller

import com.msse.web.domain.Account
import com.msse.web.domain.Artist
import com.msse.web.domain.Playlist
import com.msse.web.domain.Release
import com.msse.web.domain.Songs
import com.msse.web.repository.AccountRepository
import com.msse.web.repository.ArtistRepository
import com.msse.web.repository.PlaylistRepository
import com.msse.web.repository.ReleaseRepository
import com.msse.web.repository.SongsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

import java.awt.PageAttributes.MediaType
/**
 * Created by z001hk8 on 3/5/17.
 */

@ContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PlaylistControllerFunctionalTest extends Specification {

    @Autowired
    AccountRepository accountRepository

    @Autowired
    PlaylistRepository playlistRepository

    @Autowired
    ArtistRepository artistRepository

    @Autowired
    ReleaseRepository releaseRepository

    @Autowired
    SongsRepository songsRepository

    @Autowired
    private TestRestTemplate testRestTemplate

    /*
    Requirement P1
     */
    def "add a playlist"() {
        setup:
        def account = new Account(email: 'validplaylist@gmail.com', password: 'Password1', name: "Test Account")
        accountRepository.save(account)
        def myPlaylist = new Playlist(name: 'myPlaylist', account: account)
        playlistRepository.save(myPlaylist)

        when:
        ResponseEntity<Playlist> response = this.testRestTemplate.postForEntity("/playlist", myPlaylist, Playlist.class)

        then:
        response.statusCode == HttpStatus.OK
        Playlist actual = response.body
        actual.name == myPlaylist.name
        actual.account.id == account.id

    }

    /*
    Requirement P2
     */
    def "add a song to a playlist"() {

        setup:
        //Account to add song to
        def account = new Account(email: 'validplaylistForSongTest@gmail.com', password: 'Password7', name: "New Test Account")
        accountRepository.save(account)
        def myPlaylist = new Playlist(name: 'myPlaylist1', account: account)
        playlistRepository.save(myPlaylist)

        //Song to add to account
        def artist = new Artist(name: 'Super Kid')
        artistRepository.save(artist)
        def release = new Release(title: 'OK Computer', artist: artist, type: 'ReleaseType.ALBUM')
        releaseRepository.save(release)
        def mySong = new Songs(title: 'Help Wanted', release: release)
        mySong = songsRepository.save(mySong)

        when:
        ResponseEntity<Playlist> response = this.testRestTemplate.postForEntity("/playlist/name/myPlaylist1", mySong, Playlist.class)

        then:
        response.statusCode == HttpStatus.OK
        Playlist actual = response.body
        actual.name == myPlaylist.name
        actual.account.id == account.id
    }
}
