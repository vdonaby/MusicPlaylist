import {Component, OnInit} from '@angular/core';
import {SpotifyService} from "./service/spotify.service";
import {Artist} from "./component/artist/artist";
import {Album} from "./component/album/album";
import {Song} from "./component/song/song";
import {Router} from "@angular/router";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']

})
export class AppComponent {

  artistId: string;
  albumId: string;
  songId: string;

  artist: Artist;
  album: Album;
  song: Song;

  constructor(
    private spotifyService: SpotifyService,
    private router: Router
  ) { }

  searchArtist() {
    this.spotifyService.getArtist(this.artistId)
      .subscribe(artist => {
        this.artist = artist;
      })
  }

  searchAlbum() {
    this.spotifyService.getAlbum(this.albumId)
      .subscribe(album => {
        this.album = album;
      })
  }

  searchSong() {
    this.spotifyService.getSong(this.songId)
      .subscribe(song => {
        this.song = song;
      })
  }

}
