
import {Routes, RouterModule} from "@angular/router";
import {AppComponent} from "./app.component";
import {SongComponent} from "./component/song/song.component";

const APP_ROUTES: Routes = [
  { path: 'track/:id', component: SongComponent},
  { path: '', component: AppComponent }
]

export const routing = RouterModule.forRoot(APP_ROUTES);
