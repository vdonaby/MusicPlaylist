/**
 Search by Artist, Album or Song

 S1: Search screen allows users to select what to search for (Artist, Album or Song)
 S2: Query against Spotify search API by selected type and search term.
 Spotify API Reference
 S3: Search results are displayed as list
 S4: Search results can be paged through
*/

//import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';

import { SearchComponent } from './components/search/search.component';
import { AlbumComponent } from './components/album/album.component';
import { SongComponent } from './components/song/song.component';
import { ArtistComponent } from './components/artist/artist.component';
import {SpotifyService} from './services/spotify.service';

import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  directives: [HeaderComponent],
  precompile:[SearchComponent],
  providers:[SpotifyService]
})
export class AppComponent {
  //title = 'app works!';
}
