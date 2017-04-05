/**
 Search Results by Album

 Album1: Search results list display each album as Artist name, Album name and album cover
 Album2: Clicking an individual album display Artist Name, Album Name, Album and cover and track listings, and release year
 Album3: Track listings should display track number, song title, and duration in minutes

 */

// ng g c album


import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-album',
  templateUrl: './album.component.html',
  styleUrls: ['./album.component.css']
})
export class AlbumComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
