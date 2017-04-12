import { Injectable } from '@angular/core';
import {Http, Response} from "@angular/http";

@Injectable()
export class SpotifyService {

  private artistUrl: string

  constructor(private http: Http) {

  }

  getArtist(id: String) {
    this.artistUrl = 'https://api.spotify.com/v1/artists/' + id;
    return this.http
      .get(this.artistUrl);
  }

  private extractData(res: Response) {
    let body = res.json().results;
    return body || {};
  }
}
