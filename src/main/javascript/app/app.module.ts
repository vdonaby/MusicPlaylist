import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import {SpotifyService} from "./service/spotify.service";
import { ArtistComponent } from './component/artist/artist.component';
import { AlbumComponent } from './component/album/album.component';
import { SongComponent } from './component/song/song.component';
import {routing} from "./app.routing";
import { AlbumDetailsComponent } from './component/album-details/album-details.component';
import { SongDetailsComponent } from './component/song-details/song-details.component';
import { PlaylistCreatorComponent } from './component/playlist-creator/playlist-creator.component';
import { PlaylistSongComponent } from './component/playlist-song/playlist-song.component';
import { PlaylistDetailComponent } from './component/playlist-detail/playlist-detail.component';
import { AddSongComponent } from './component/add-song/add-song.component';
import {UserService} from "./service/user.service";
//import {UserRegisterComponent} from "./component/user/user-register/user-register.component";

@NgModule({
  declarations: [
    AppComponent,
    ArtistComponent,
    AlbumComponent,
    SongComponent,
    AlbumDetailsComponent,
    SongDetailsComponent,
    PlaylistCreatorComponent,
    PlaylistSongComponent,
    PlaylistDetailComponent,
    AddSongComponent,
    //UserRegisterComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    routing
  ],
  providers: [SpotifyService, UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
