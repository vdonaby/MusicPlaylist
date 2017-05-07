import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import { SpotifyService } from "../../service/spotify.service";
import {Playlist} from "./playlist-creater.model";
import {NgForm} from '@angular/forms';
import {Http, Response} from '@angular/http';
import {UserService} from "../../service/user.service";

@Component({
  selector: 'app-playlist-creator',
  templateUrl: './playlist-creator.component.html'
})
export class PlaylistCreatorComponent implements OnInit {

  public playlist: any;
  public playlistName: string;
  public name: string;
  public playlistBody: any;
  submitted: boolean = false;
  playlistCreated: boolean = false;

  /**constructor(
      private activatedRoute: ActivatedRoute,
      private spotifyService: SpotifyService,
      private http: Http
  ) {
    this.playlistName = activatedRoute.snapshot.params['name'];
  }

  ngOnInit() {
    console.log(name)
    this.playlistBody = {"name": "myPlaylist12","account":{"name": "myPlaylist ","password": "Password1713","email": "vdonaby55@gmail.com"}};
    this.spotifyService.createPlaylist(this.playlistBody)
        .subscribe(playlist => {
          this.playlist = playlist;
        })
  }

  savePlaylist(playlist:Playlist){
    return this.spotifyService.savePlaylist(playlist);
  }

  /**submitPlaylist(form: NgForm){
    this.submitted= true;
    if (form.valid) {
      this.savePlaylist(this.playlist).subscribe(
          playlist => {
            this.playlist.clear();
            this.submitted = false;
          }
      )
    }
  }

   */

  ngOnInit() {}

  userService : UserService;
  model: any = {};

  constructor(userService: UserService,private router: Router) {
    this.userService = userService;
  }

  // submitPlaylist(form: NgForm){
  //   //this.submitted= true;
  //   if (form.valid) {
  //     console.log("************* " + this.model.Name)
  //     // this.userService.create(this.model)
  //     //     .subscribe(data => {
  //     //       this.router.navigate(['/playlist']);
  //     //     });
  //     this.router.navigate(['/addSong']);
  //
  //   }
  // }

  savePlaylist() {
    console.log("************* " + this.model.Name)
    // this.userService.create(this.model)
    //     .subscribe(data => {
    //       this.router.navigate(['/playlist']);
    //     });
    this.router.navigate(['/addSong']);

  }


  /**
   //create a playlist
   createPlaylist(playlistName) {
    return this.http.post('adduser/user/createplaylist/', playlistName).map((response: Response) => response.json());
  }
   */
}
