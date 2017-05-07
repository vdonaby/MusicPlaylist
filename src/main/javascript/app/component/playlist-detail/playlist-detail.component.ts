import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-playlist-detail',
  templateUrl: './playlist-detail.component.html'
})
export class PlaylistDetailComponent implements OnInit {

  constructor() { }

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
