/**
 Search by Artist Results

 SA1: Search results display each artist as Artist name, and related image
 SA2: Clicking an individual artist routes to page that displays Artist name, image, genres and number of followers

 */

//ng g c artist

import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-artist',
  templateUrl: './artist.component.html',
  styleUrls: ['./artist.component.css']
})
export class ArtistComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
