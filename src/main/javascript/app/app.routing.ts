
import {Routes, RouterModule} from "@angular/router";
import {SongComponent} from "./component/song/song.component";
import {AlbumComponent} from "./component/album/album.component";
import {ArtistComponent} from "./component/artist/artist.component";
import {AlbumDetailsComponent} from "./component/album-details/album-details.component";
import {PlaylistCreatorComponent} from "./component/playlist-creator/playlist-creator.component";
import {AppComponent} from "./app.component";
import {PlaylistDetailComponent} from "./component/playlist-detail/playlist-detail.component";
import {AddSongComponent} from "./component/add-song/add-song.component";


const APP_ROUTES: Routes = [
  {path: 'track/:id', component: SongComponent},
  {path: 'album', component: AlbumComponent},
  {path: 'artist', component: ArtistComponent},
  {path: 'song', component: SongComponent},
  {path: 'albumDetails/:href', component: AlbumDetailsComponent},
  {path: 'addSong/:playlistName', component: AddSongComponent},
  {path: 'createPlaylist/:name/:email/:password', component: PlaylistCreatorComponent},

  {path: 'PlaylistDetail', component: PlaylistDetailComponent }
  /** suggested routes
  {path: 'user/createplaylist', component: PlaylistCreatorComponent},
   {path: 'user/playlist/:name', component: PlaylistDetailComponent},

  */
]

export const routing = RouterModule.forRoot(APP_ROUTES);
