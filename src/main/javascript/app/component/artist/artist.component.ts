import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {SpotifyService} from "../../service/spotify.service";

@Component({
  selector: 'app-artist',
  templateUrl: './artist.component.html',
  styleUrls: ['./artist.component.css']
})
export class ArtistComponent implements OnInit {

  artistId: string;
  artist: any;

  constructor(
    private spotifyService: SpotifyService,
    private router: Router
  ) { }
  ngOnInit() {}

  searchArtist() {
    this.spotifyService.getArtist(this.artistId)
      .subscribe(artist => {
        this.artist = artist;
      })
  }

}
