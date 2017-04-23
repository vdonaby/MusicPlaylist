import { Component, OnInit } from '@angular/core';
import {Router, ActivatedRoute} from "@angular/router";
import {SpotifyService} from "../../service/spotify.service";

@Component({
  selector: 'app-album',
  templateUrl: './album.component.html',
  styleUrls: ['./album.component.css']
})
export class AlbumComponent implements OnInit {

  href: string;
  album: any;

  albumId: string;

  constructor(
    private router: Router,
    private activatedRoute: ActivatedRoute,
    private spotifyService: SpotifyService
  ) {
    this.href = activatedRoute.snapshot.params['href'];
  }

  ngOnInit() {
  }

  searchAlbum() {
    this.spotifyService.getAlbum(this.albumId)
      .subscribe(album => {
        this.album = album;
      })
  }

}
