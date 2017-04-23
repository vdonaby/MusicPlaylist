import { Component, OnInit } from '@angular/core';
import {Router, ActivatedRoute} from "@angular/router";
import {SpotifyService} from "../../service/spotify.service";

@Component({
  selector: 'app-album-details',
  templateUrl: './album-details.component.html',
  styleUrls: ['./album-details.component.css']
})
export class AlbumDetailsComponent implements OnInit {

  href: string;
  album: any;

  constructor(
    private router: Router,
    private activatedRoute: ActivatedRoute,
    private spotifyService: SpotifyService
  ) {
    this.href = activatedRoute.snapshot.params['href'];
  }

  ngOnInit() {
    this.spotifyService.getAlbumDetails(this.href)
      .subscribe(album => {
        this.album = album;
      })
  }
}
