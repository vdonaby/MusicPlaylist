/**
 * Created by Shorouq on 4/4/17.
 */
import {NgModule} from "@angular/core";
import {Routes, RouterModule} from "@angular/router";
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { AlbumComponent } from './components/album/album.component';
import { SongComponent } from './components/song/song.component';
import { ArtistComponent } from './components/artist/artist.component';
import { SearchComponent } from './components/search/search.component';
//import {HTTPPROVIDERS} from '@angular/http';

const routes: Routes = [
  {
    //home
    path: '',
    component: SearchComponent
  },

 /** not required {
    path: 'Header',
    component: HeaderComponent
  },
*/

  {
    path: 'song/album/:id',
    component: SongComponent,
    redirectTo: 'song/album',
    pathMatch: 'full'
  },

  {
    path: 'artist/:id',
    component: ArtistComponent,
    redirectTo: 'artist',
    pathMatch: 'full'
  },
  {
    path: 'album/:id',
    component: AlbumComponent,
    redirectTo: 'album',
    pathMatch: 'full'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
//export class AppRoutingModule =[
  //getRouting(routes);
//];
