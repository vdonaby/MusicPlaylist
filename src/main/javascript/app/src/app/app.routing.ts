
import {Routes, RouterModule} from "@angular/router";
import {AppComponent} from "./app.component";
import {SongComponent} from "./component/song/song.component";
import {AlbumComponent} from "./component/album/album.component";

const APP_ROUTES: Routes = [
  { path: 'albumDetails/:href', component: AlbumComponent},
  { path: 'track/:id', component: SongComponent}
]

export const routing = RouterModule.forRoot(APP_ROUTES);
