import { Component, OnInit } from '@angular/core';
import {UserService} from "../../service/user.service";
import {Router, ActivatedRoute} from "@angular/router";
import {SpotifyService} from "../../service/spotify.service";

@Component({
  selector: 'app-add-song',
  templateUrl: './add-song.component.html'
})
export class AddSongComponent implements OnInit {

  userService : UserService;
  model: any = {};
  songName: string;
  album: any;

  songId: string;
  song: any;

  constructor(
      userService: UserService,
      private router: Router,
      private activatedRoute: ActivatedRoute,
      private spotifyService: SpotifyService
  ) {
    this.userService = userService;
  }

  ngOnInit() {
  }

  saveSong(songName) {
    console.log("hello" + songName)
    // this.userService.create(this.model)
    //     .subscribe(data => {
    //       this.router.navigate(['/playlist']);
    //     });

  }

  searchSong() {
    this.spotifyService.getSong(this.songId)
        .subscribe(song => {
          this.song = song;
        })
  }



}
