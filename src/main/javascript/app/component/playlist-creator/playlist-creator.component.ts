import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from "@angular/router";
import { SpotifyService } from "../../service/spotify.service";

@Component({
  selector: 'app-playlist-creator',
  templateUrl: './playlist-creator.component.html',
  styleUrls: ['./playlist-creator.component.css']
})
export class PlaylistCreatorComponent implements OnInit {

  playlist: any;
  playlistName: string;
  name: string;
  playlistBody: any;

  constructor(
      private activatedRoute: ActivatedRoute,
      private spotifyService: SpotifyService
  ) {
    this.playlistName = activatedRoute.snapshot.params['name'];
  }

  ngOnInit() {
    this.playlistBody = {"name": "myPlaylist12","account":{"name": "myPlaylist ","password": "Password1713","email": "vdonaby55@gmail.com"}};
    this.spotifyService.createPlaylist(this.playlistBody)
        .subscribe(playlist => {
          this.playlist = playlist;
        })
  }

}
