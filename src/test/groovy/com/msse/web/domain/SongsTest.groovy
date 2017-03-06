package com.msse.web.domain

import com.msse.web.repository.ArtistRepository
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
class SongsTest extends Specification {

    @Autowired
    SongsRepository songsRepository

    @Autowired
    ReleaseRepository releaseRepository

    @Autowired
    ArtistRepository artistRepository

    /*
    Requirement S1
     */
    def 'saves a valid song'() {

        given:
        def artist = new Artist(name: 'Super Kid')
        artistRepository.save(artist)
        def release = new Release(date: LocalDate.now(), title: 'OK Computer', artist: artist, type: 'ReleaseType.ALBUM')
        releaseRepository.save(release)
        def song = new Songs(title: 'Roger that', release: release)
        def startingSongCount = songsRepository.count()

        when:
        song = songsRepository.save(song)

        then:
        song.id
        songsRepository.count() == startingSongCount + 1

        when:
        song = songsRepository.findOne(song.id)

        then:
        song.title == 'Roger that'
        song.release.id == release.id


    }

    /*
    Requirement S1
     */
    def 'saves a song with no title'() {

        given:
        def artist = new Artist(name: 'Super Kid')
        artistRepository.save(artist)
        def release = new Release(date: LocalDate.now(), title: 'OK Computer', artist: artist, type: 'ReleaseType.ALBUM')
        releaseRepository.save(release)
        def song = new Songs(release: release)

        when:
        songsRepository.save(song)

        then:
        thrown(ConstraintViolationException)
    }

    /*
    Requirement S1
     */
    def 'saves a song with no release'() {

        given:
        def song = new Songs(title: 'Hottest Song Out')

        when:
        songsRepository.save(song)

        then:
        thrown(ConstraintViolationException)
    }

    /*
    Requirement S2
     */
    def 'saves a valid release'() {

        def artist = new Artist(name: 'Super Kid')
        artistRepository.save(artist)
        def startingReleaseCount = releaseRepository.count()
        def release = new Release(date: LocalDate.now(), title: 'OK Computer', artist: artist, type: 'ReleaseType.ALBUM')

        when:
        release = releaseRepository.save(release)

        then:
        release.id
        releaseRepository.count() == startingReleaseCount + 1

        when:
        release = releaseRepository.findOne(release.id)

        then:
        release.artist.id == artist.id
        release.type == 'ReleaseType.ALBUM'
        release.title == 'OK Computer'
        release.artist.id == artist.id

    }

    /*
    Requirement S2
     */
    def 'saves a release without a title'() {

        def artist = new Artist(name: 'Super Kid')
        artistRepository.save(artist)
        def release = new Release(date: LocalDate.now(), artist: artist, type: 'ReleaseType.ALBUM')

        when:
        releaseRepository.save(release)

        then:
        thrown(ConstraintViolationException)

    }

    /*
    Requirement S2
     */
    def 'saves a release without a artist'() {

        def release = new Release(date: LocalDate.now(), title: 'OK Computer', type: 'ReleaseType.ALBUM')

        when:
        releaseRepository.save(release)

        then:
        thrown(ConstraintViolationException)

    }

    /*
    Requirement S2
     */
    def 'saves a release without a release type'() {

        def artist = new Artist(name: 'Super Kid')
        artistRepository.save(artist)
        def release = new Release(date: LocalDate.now(), title: 'OK Computer', artist: artist)

        when:
        releaseRepository.save(release)

        then:
        thrown(ConstraintViolationException)

    }

    /*
    Requirement S3
     */
    def 'a release can have an optional date field'() {

        def artist = new Artist(name: 'Super Kid')
        artistRepository.save(artist)
        def startingReleaseCount = releaseRepository.count()
        def release = new Release(title: 'OK Computer', artist: artist, type: 'ReleaseType.ALBUM')

        when:
        release = releaseRepository.save(release)

        then:
        release.id
        releaseRepository.count() == startingReleaseCount + 1

        when:
        release = releaseRepository.findOne(release.id)

        then:
        release.artist.id == artist.id
        release.type == 'ReleaseType.ALBUM'
        release.title == 'OK Computer'
        release.artist.id == artist.id

    }

    /*
    Requirement S4
     */

    def 'saves a artist with required name field'() {

        def artist = new Artist(name: 'Super Kid')
        def startingArtistCount = artistRepository.count()

        when:
        artist = artistRepository.save(artist)

        then:
        artist.id
        artistRepository.count() == startingArtistCount + 1

        when:
        artist = artistRepository.findOne(artist.id)

        then:
        artist.name == 'Super Kid'

    }

    /*
    Requirement S4
     */

    def 'saves a artist without required name field'() {

        def artist = new Artist()

        when:
        artistRepository.save(artist)

        then:
        thrown(ConstraintViolationException)
    }

    /*
    Requirement S5
     */

    def 'saves a artist with multiple release'() {

        def artist = new Artist(name: 'Super Kid')
        artistRepository.save(artist)

        def release1 = new Release(date: LocalDate.now(), title: 'OK Computer', artist: artist, type: 'ReleaseType.ALBUM')
        def release2 = new Release(date: LocalDate.now(), title: 'OK Desktop', artist: artist, type: 'ReleaseType.ALBUM')

        def startingReleaseCount = releaseRepository.count()

        when:
        releaseRepository.save(release1)
        releaseRepository.save(release2)


        then:
        release1.id
        release2.id
        releaseRepository.count() == startingReleaseCount + 2

        when:
        release1 = releaseRepository.findOne(release1.id)
        release2 = releaseRepository.findOne(release2.id)

        then:
        release1.artist.name == 'Super Kid'
        release2.artist.name == 'Super Kid'

    }

    /*
    Requirement S6
     */
    def 'search for a song by title with wildcard *Love*'() {

        given:
        def artist = new Artist(name: 'Super Kid')
        artistRepository.save(artist)
        def release = new Release(date: LocalDate.now(), title: 'OK Computer', artist: artist, type: 'ReleaseType.ALBUM')
        releaseRepository.save(release)
        def song = new Songs(title: 'Love is Here', release: release)
        def startingSongCount = songsRepository.count()

        when:
        song = songsRepository.save(song)

        then:
        song.id
        songsRepository.count() == startingSongCount + 1

        when:
        song = songsRepository.findAllSongsThatMatchWildcardValue("Love")

        then:
        song.title.toString() == '[Love is Here]'

    }

}

