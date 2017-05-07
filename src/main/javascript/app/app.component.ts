import {Component, OnInit} from '@angular/core';
import {SpotifyService} from "./service/spotify.service";


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],

})
export class AppComponent implements OnInit {

  playlistBody: any;
  playlist: any;

  constructor(
      private spotifyService: SpotifyService
  ) {

  }

  ngOnInit() {

  }

  onSubmit() {

    this.playlistBody = {"name": "myPlaylist12","account":{"name": "myPlaylist ","password": "Password1713","email": "vdonaby55@gmail.com"}};
    this.spotifyService.createPlaylist(this.playlistBody)
        .subscribe(playlist => {
          this.playlist = playlist;
        })
  }

}
