import {Component, OnInit, ViewChild} from '@angular/core';
import {SpotifyService} from "./service/spotify.service";
import {Router} from "@angular/router";
import {UserService} from "./service/user.service";


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],


})
export class AppComponent implements OnInit {

  playlistBody: any;
  playlist: any;

  onSubmit() {

    /**this.playlistBody = {"name": "myPlaylist12","account":{"name": "myPlaylist ","password": "Password1713","email": "vdonaby55@gmail.com"}};
    this.spotifyService.createPlaylist(this.playlistBody)
        .subscribe(playlist => {
          this.playlist = playlist;
        }) */
  }


  userService : UserService;
  model: any = {};

  constructor(userService: UserService,private router: Router) {
    this.userService = userService;
  }


  ngOnInit() {}

  saveUser() {
    console.log("************* " + this.model.Name)
    // this.userService.create(this.model)
    //     .subscribe(data => {
    //       this.router.navigate(['/playlist']);
    //     });
    this.router.navigate(['/createPlaylist']);

  }

}
