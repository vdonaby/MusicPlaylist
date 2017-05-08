import { Component, OnInit } from '@angular/core';
import {UserService} from "../../service/user.service";
import {Router, ActivatedRoute} from "@angular/router";
import {SpotifyService} from "../../service/spotify.service";
import {Response, Http} from "@angular/http";

@Component({
  selector: 'app-add-song',
  templateUrl: './add-song.component.html'
})
export class AddSongComponent implements OnInit {

  userService : UserService;
  model: any = {};
  songName: string;
  album: any;
  playlistName: string;
  artistName: string;
  releaseTitle: string;
  releaseType: string;
  songTitle: string;

  songId: string;
  song: any;
  playlist: any;

  constructor(
      userService: UserService,
      private router: Router,
      private activatedRoute: ActivatedRoute,
      private spotifyService: SpotifyService,
      private http: Http
  ) {
    this.userService = userService;
    this.playlistName = activatedRoute.snapshot.params['playlistName'];
  }

  ngOnInit() {
  }

  saveSong(artistName, songTitle) {
    console.log("hello" + songTitle + " playlistName: " + this.playlistName)
    this.http.post('/playlist/name/' + this.playlistName, {title: songTitle}).map((response: Response) => response.json())
        .subscribe(playlist => {
          this.playlist = playlist;
        })

  }

  searchSong() {
    this.spotifyService.getSong(this.songId)
        .subscribe(song => {
          this.song = song;
        })
  }

  showPlaylist() {
    console.log("************* " + this.model.Name)
    // this.userService.create(this.model)
    //     .subscribe(data => {
    //       this.router.navigate(['/playlist']);
    //     });
    this.router.navigate(['/playlistDetail']);

  }

}
