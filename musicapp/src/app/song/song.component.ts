/**
 Search by Song

 SS1: Search results display each song as artist name, album name and song title
 Search by Track
 SS2: Clicking an individual song takes you to the Album details its a part of.

 */

/**
 ng g c song
   adding if required
   ng g c song/song-list
     ng g c song-list/one-song
   ng g c song/songs-detail
 *
 */

import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-song',
  templateUrl: './song.component.html',
  styleUrls: ['./song.component.css']
})
export class SongComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
