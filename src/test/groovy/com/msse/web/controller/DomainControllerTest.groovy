package com.msse.web.controller

import com.msse.web.domain.Artist
import com.msse.web.domain.Music
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
import spock.lang.Specification

import java.time.LocalDate

/**
 * Created by z001hk8 on 3/10/17.
 */

@ContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DomainControllerTest extends Specification {

    @Autowired
    ArtistRepository artistRepository

    @Autowired
    ReleaseRepository releaseRepository

    @Autowired
    SongsRepository songsRepository

    @Autowired
    private TestRestTemplate testRestTemplate

    /*
    Requirement G1
     */

    def "find artists, releases, and songs based on wildcard"() {

        List<Artist> artists = new ArrayList<>();
        List<Release> releases = new ArrayList<>();
        List<Songs> songs = new ArrayList<>();

        given:
        def artist = new Artist(name: 'Super Kid')
        artist = artistRepository.save(artist)
        artists.add(artist)
        def release = new Release(title: 'Supernatural', artist: artist, type: 'ReleaseType.ALBUM')
        release = releaseRepository.save(release)
        releases.add(release)
        def song = new Songs(title: 'Super Song', release: release)
        song = songsRepository.save(song)
        songs.add(song)

        when:
        ResponseEntity<Music> response = this.testRestTemplate.getForEntity("/music/name/Sup", Music.class)

        then:
        response.statusCode == HttpStatus.OK
        Music music = response.body
        music.artists.get(0).id == artists.get(0).id
        music.releases.get(0).id == releases.get(0).id
        music.songsList.get(0).id == songs.get(0).id
    }
}