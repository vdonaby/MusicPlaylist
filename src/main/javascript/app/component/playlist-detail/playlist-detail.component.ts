import { Component, OnInit } from '@angular/core';
import {Router, ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-playlist-detail',
  templateUrl: './playlist-detail.component.html'
})
export class PlaylistDetailComponent implements OnInit {

  constructor(
      private router: Router,
      private activatedRoute: ActivatedRoute
  ) { }

  ngOnInit() {
  }

  deleteSong(songName) {
    console.log("hello" + songName)
    // this.userService.create(this.model)
    //     .subscribe(data => {
    //       this.router.navigate(['/playlist']);
    //     });

  }

}
