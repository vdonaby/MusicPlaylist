import { Injectable } from '@angular/core';
import {Http, Response} from "@angular/http";
import {Observable} from "rxjs";

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

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
