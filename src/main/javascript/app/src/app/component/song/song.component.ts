import { Component, OnInit } from '@angular/core';
import {Router, ActivatedRoute} from "@angular/router";
import {SpotifyService} from "../../service/spotify.service";
import {Album} from "../album/album";

@Component({
  selector: 'app-song',
  templateUrl: './song.component.html',
  styleUrls: ['./song.component.css']
})
export class SongComponent implements OnInit {

  id: string;
  album: Album;

  constructor(private router: Router,
              private activatedRoute: ActivatedRoute,
              private spotifyService: SpotifyService) {

    this.id = activatedRoute.snapshot.params['id'];
  }

  ngOnInit() {
    this.spotifyService.getAlbum(this.id)
      .subscribe(album => {
        this.album = album;
        console.log("******** service is being called")
      })
  }


}
