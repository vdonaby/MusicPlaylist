package com.msse.web.service

import com.msse.web.domain.Artist
import com.msse.web.domain.Music
import com.msse.web.domain.Release
import com.msse.web.domain.Songs
import com.msse.web.repository.ArtistRepository
import com.msse.web.repository.ReleaseRepository
import com.msse.web.repository.SongsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created by z001hk8 on 3/10/17.
 */

@Service
class SearchRepositoryService {

    @Autowired
    ArtistRepository artistRepository

    @Autowired
    ReleaseRepository releaseRepository

    @Autowired
    SongsRepository songsRepository

    Music music = new Music()

    List<Artist> artists = new ArrayList<>()

    List<Release> releases = new ArrayList<>()

    List<Songs> songs = new ArrayList<>()

    Music search(String wildcard) {


        artists = artistRepository.findAllArtistThatMatchWildcardValue(wildcard)

        releases = releaseRepository.findAllReleasesThatMatchWildcardValue(wildcard)

        songs = songsRepository.findAllSongsThatMatchWildcardValue(wildcard)

        if(artists != null) {
            System.out.print("****** " + artists)
            music.artists = artists
        }

        if(releases != null) {
            System.out.print("****** " + releases)
            music.releases = releases
        }

        if(songs != null) {
            System.out.print("****** " + songs)
            music.songsList = songs
        }

        return music
    }

}
