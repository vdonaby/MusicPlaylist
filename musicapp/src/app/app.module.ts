import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { AlbumComponent } from './components/album/album.component';
import { SongComponent } from './components/song/song.component';
import { ArtistComponent } from './components/artist/artist.component';
import {SpotifyService} from './services/spotify.service';
import { SearchComponent } from './components/search/search.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    AlbumComponent,
    SongComponent,
    ArtistComponent,
    SpotifyService,
    SearchComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
