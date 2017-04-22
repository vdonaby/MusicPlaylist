
import {Routes, RouterModule} from "@angular/router";
import {SongComponent} from "./component/song/song.component";
import {AlbumComponent} from "./component/album/album.component";
import {ArtistComponent} from "./component/artist/artist.component";

const APP_ROUTES: Routes = [
  {path: 'albumDetails/:href', component: AlbumComponent},
  {path: 'track/:id', component: SongComponent},
  {path: 'album', component: AlbumComponent},
  {path: 'artist', component: ArtistComponent},
  {path: 'song', component: SongComponent}
]

export const routing = RouterModule.forRoot(APP_ROUTES);
