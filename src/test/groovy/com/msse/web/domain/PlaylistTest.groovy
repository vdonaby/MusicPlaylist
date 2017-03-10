package com.msse.web.domain

import com.msse.web.repository.AccountRepository
import com.msse.web.repository.ArtistRepository
import com.msse.web.repository.PlaylistRepository
import com.msse.web.repository.ReleaseRepository
import com.msse.web.repository.SongsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

import javax.validation.ConstraintViolationException
import java.time.LocalDate

/**
 * Created by z001hk8 on 2/7/17.
 */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PlaylistTest extends Specification {

    @Autowired
    PlaylistRepository playlistRepository

    @Autowired
    AccountRepository accountRepository

    @Autowired
    SongsRepository songsRepository

    @Autowired
    ReleaseRepository releaseRepository

    @Autowired
    ArtistRepository artistRepository

    /*
    Requirement P1
     */
    def 'saves a valid playlist'() {

        given:

        def account = new Account(email: 'accountplaylist@gmail.com', password: 'Password1', name: "Test Account")
        accountRepository.save(account)
        def playlist = new Playlist(name: 'myPlaylist', account: account)
        def startingPlaylistCount = playlistRepository.count()

        when:
        playlist = playlistRepository.save(playlist)

        then:
        playlist.id
        playlistRepository.count() == startingPlaylistCount + 1

        when:
        playlist = playlistRepository.findOne(playlist.id)

        then:
        playlist.name == "myPlaylist"
        playlist.account.id == account.id
    }

    /*
    Requirement P1
     */
    def 'saves a playlist without a name'() {

        given:

        def account = new Account(email: 'withoutname@gmail.com', password: 'Password1', name: "Test Account")
        accountRepository.save(account)
        def playlist = new Playlist(account: account)

        when:
        playlist = accountRepository.save(playlist)

        then:
        thrown(ConstraintViolationException)
    }

    /*
    Requirement P1
     */
    def 'saves a playlist without a account'() {

        given:

        def playlist = new Playlist(name: "My Account")

        when:
        playlist = accountRepository.save(playlist)

        then:
        thrown(ConstraintViolationException)
    }


    /*
    Requirement P2 and P3
     */
    def 'saves a song to multiple playlist'() {

        given:
        def account = new Account(email: 'multiplesongs@gmail.com', password: 'Password1', name: "Test Account")
        accountRepository.save(account)
        def artist = new Artist(name: 'Super Kid')
        artistRepository.save(artist)
        def release = new Release(date: LocalDate.now(), title: 'OK Computer', artist: artist, type: 'ReleaseType.ALBUM')
        releaseRepository.save(release)
        def songs = new ArrayList<Songs>()
        def song = new Songs(title: 'Roger that', release: release)
        songsRepository.save(song)
        songs.add(song)

        def playlist1 = new Playlist(name: 'My Playlist 1', account: account, songs: songs)
        def playlist2 = new Playlist(name: 'My Playlist 2', account: account, songs: songs)
        def startingPlaylistCount = playlistRepository.count()

        when:
        playlist1 = playlistRepository.save(playlist1)
        playlist2 = playlistRepository.save(playlist2)

        then:
        playlist1.id
        playlist2.id
        playlistRepository.count() == startingPlaylistCount + 2

        when:
        playlist1 = playlistRepository.findOne(playlist1.id)
        playlist2 = playlistRepository.findOne(playlist2.id)

        then:
        playlist1.name == "My Playlist 1"
        playlist1.account.id == account.id
        playlist2.name == "My Playlist 2"
        playlist2.account.id == account.id

    }
}
