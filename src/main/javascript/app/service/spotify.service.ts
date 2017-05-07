import { Injectable } from '@angular/core';
import {Http, Response, RequestOptions, Headers} from "@angular/http";
import {Observable} from "rxjs";

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import {Playlist} from "../component/playlist-creator/playlist-creater.model";

@Injectable()
export class SpotifyService {


  constructor(private http: Http) {
  }

  getArtist(name: String) {
    let artistUrl = 'https://api.spotify.com/v1/search?q=' + name + '&type=artist';
    return this.http
      .get(artistUrl)
      .map(res => res.json())
      .catch(this.handleError);
  }

  getAlbum(name: String) {
    let albumUrl = 'https://api.spotify.com/v1/search?q=' + name + '&type=album';
    console.log('****** ' + albumUrl)
    return this.http
      .get(albumUrl)
      .map(res => res.json())
      .catch(this.handleError);
  }

  getSong(name: String) {
    let songUrl = 'https://api.spotify.com/v1/search?q=' + name + '&type=track';
    console.log('****** ' + songUrl)
    return this.http
      .get(songUrl)
      .map(res => res.json())
      .catch(this.handleError);
  }

  getAlbumDetails(url: string) {
    let albumIdUrl = url;
    console.log('****** ' + url)
    return this.http
        .get(albumIdUrl)
        .map(res => res.json())
        .catch(this.handleError);

  }

  createPlaylist(playListBody: string) {
    console.log('calling playlist creator****** ')
    let headers = new Headers({'Content-Type': 'application/json' }); // ... Set content type to JSON
    let options = new RequestOptions({ headers: headers}); // Create a request option
    return this.http
        .post('/playlist', playListBody, options)
        .map(res => res.json())
        .catch(this.handleError);

  }

  /**
 save a playlist
   not forget to add playlist model to
   */
  savePlaylist(playlist: Playlist): Observable<Playlist>{
    console.log(JSON.stringify(playlist));
    return Observable.from([playlist])

  }


  private handleError (error: Response | any) {
    let errMsg: string;
    console.log("error mapping response")
    if (error instanceof Response) {
      const body = error.json() || '';
      const err = body.error || JSON.stringify(body);
      errMsg = `${error.status} - ${error.statusText || ''} ${err}`;
    } else {
      errMsg = error.message ? error.message : error.toString();
    }
    console.error(errMsg);
    return Observable.throw(errMsg);
  }

}
