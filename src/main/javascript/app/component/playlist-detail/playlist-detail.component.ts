import { Component, OnInit } from '@angular/core';
import {Router, ActivatedRoute} from "@angular/router";
import {Http} from "@angular/http";
import {SpotifyService} from "../../service/spotify.service";

@Component({
  selector: 'app-playlist-detail',
  templateUrl: './playlist-detail.component.html'
})
export class PlaylistDetailComponent implements OnInit {

  playlistName: string;
  playlist: any;

  constructor(
      private router: Router,
      private activatedRoute: ActivatedRoute,
      private http: Http,
      private spotifyService: SpotifyService
  ) {
    this.playlistName = activatedRoute.snapshot.params['playlistName'];
  }

  ngOnInit() {
    console.log("****** Play Name: " + this.playlistName)
    this.http.get('/playlist/' + this.playlistName).map(res => res.json())
        .subscribe(playlist => {
          this.playlist = playlist;
          console.log("&&&&&&& " + this.playlist.toString())
        })
  }

  deleteSong(songName) {
    console.log("hello" + songName)
    // this.userService.create(this.model)
    //     .subscribe(data => {
    //       this.router.navigate(['/playlist']);
    //     });

  }

}
