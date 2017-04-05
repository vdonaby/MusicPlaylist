/**
 * Created by Shorouq on 4/5/17.
 */
import {Injectable} from '@angular/core';
import {Http, Headers} from '@angular/http';
import 'rxjs/add/operator/map';

@Injectable()
export class SpotifyService{
  private searchUrl: string;
  private artistUrl: string;
  private albumsUrl: string;
  private albumUrl: string;

  constructor(private _http:Http){

  }

  searchMusic(str:string, type='artist'){
    this.searchUrl = 'https://api.spotify.com/v1/search?query='+str+'&offset=0&limit=20&type='+type+'&market=US';
    return this._http.get(this.searchUrl)
      //return json data from observable
      .map(res => res.json());
  }


}
