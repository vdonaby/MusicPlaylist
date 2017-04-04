/**
 Search by Artist, Album or Song

 S1: Search screen allows users to select what to search for (Artist, Album or Song)
 S2: Query against Spotify search API by selected type and search term.
 Spotify API Reference
 S3: Search results are displayed as list
 S4: Search results can be paged through

 */

import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app works!';
}
