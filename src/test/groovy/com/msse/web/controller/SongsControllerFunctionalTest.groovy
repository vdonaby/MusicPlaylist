package com.msse.web.controller

import com.msse.web.domain.Artist
import com.msse.web.domain.Playlist
import com.msse.web.domain.Release
import com.msse.web.domain.Songs
import com.msse.web.repository.ArtistRepository
import com.msse.web.repository.ReleaseRepository
import com.msse.web.repository.SongsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.test.context.ContextConfiguration
import spock.lang.Ignore
import spock.lang.Specification

import java.time.LocalDate

/**
 * Created by z001hk8 on 3/9/17.
 */

@ContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SongsControllerFunctionalTest extends Specification {

    @Autowired
    ArtistRepository artistRepository

    @Autowired
    ReleaseRepository releaseRepository

    @Autowired
    SongsRepository songsRepository

    @Autowired
    private TestRestTemplate testRestTemplate

    /*
    Requirement S1
     */
    def "find a song based on title and artist"() {

        given:
        def artist = new Artist(name: 'Super Kid')
        artistRepository.save(artist)
        def release = new Release(title: 'OK Computer', artist: artist, type: 'ReleaseType.ALBUM')
        releaseRepository.save(release)
        def song = new Songs(title: 'Roger that', release: release)
        songsRepository.save(song)

        when:
        ResponseEntity<Songs> response = this.testRestTemplate.getForEntity("/song/title/" + song.title + "/artist/" + artist.name, Songs.class)

        then:
        response.statusCode == HttpStatus.OK
        Songs actual = response.body
        actual.release.title == release.title
        actual.release.artist.name == artist.name
        actual.title == song.title

    }

    /*
    Requirement S2
     */
    def "create a song, release, and artist"() {

        given:
        def artist = new Artist(name: 'Super Kid')
        artistRepository.save(artist)
        def release = new Release(title: 'OK Computer', artist: artist, type: 'ReleaseType.ALBUM')
        releaseRepository.save(release)
        def song = new Songs(title: 'Roger that', release: release)

        when:
        ResponseEntity<Songs> response = this.testRestTemplate.postForEntity("/song", song, Songs.class)

        then:
        response.statusCode == HttpStatus.OK
        Songs actual = response.body
        actual.release.title == release.title
        actual.release.artist.name == artist.name
        actual.title == song.title

    }

    /*
    Requirement S3
     */
    @Ignore
    def "add a song to an existing release"() {

        setup:
        def artist = new Artist(name: 'Super Kid')
        artistRepository.save(artist)
        def release = new Release(title: 'OK Computer', artist: artist, type: 'ReleaseType.ALBUM')
        release = releaseRepository.save(release)
        def song = new Songs(title: 'Test Song', release: release)
        song = songsRepository.save(song)

        when:
        ResponseEntity<Release> response = this.testRestTemplate.postForEntity("/song/releaseId/" + release.id, song, Release.class)

        then:
        response.statusCode == HttpStatus.OK
        Release actualRelease = response.body
        actualRelease.title == release.title
        actualRelease.songs.id == song.id
    }
}
