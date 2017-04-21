import { TestBed, inject } from '@angular/core/testing';
import { SpotifyService } from './spotify.service';
import {Http, Response, ResponseOptions, ConnectionBackend, HttpModule} from "@angular/http";
import {Observable} from "rxjs";
import {NO_ERRORS_SCHEMA} from "@angular/core";

describe('SpotifyService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpModule],
      schemas: [NO_ERRORS_SCHEMA],
      providers: [SpotifyService, Http, ConnectionBackend]
    });
  });

  it('should create service...', inject([SpotifyService], (service: SpotifyService) => {
    expect(service).toBeTruthy();
  }));

  it('should get artist...', inject([SpotifyService], (service: SpotifyService) => {
    let http = TestBed.get(Http);
    let response = new Response(new ResponseOptions());
    let responseJson = spyOn(response, 'json').and.returnValue.toString()

    let httpGet = spyOn(http, 'get').and.returnValue(Observable.of(response));
    service.getArtist("Lil Wayne");

    expect(httpGet).toHaveBeenCalledWith("https://api.spotify.com/v1/search?q=Lil Wayne&type=artist");
    expect(httpGet).toHaveBeenCalledTimes(1);

  }));

  it('should get album...', inject([SpotifyService], (service: SpotifyService) => {
    let http = TestBed.get(Http);
    let response = new Response(new ResponseOptions());
    let responseJson = spyOn(response, 'json').and.returnValue.toString()

    let httpGet = spyOn(http, 'get').and.returnValue(Observable.of(response));
    service.getAlbum("Revolver");

    expect(httpGet).toHaveBeenCalledWith("https://api.spotify.com/v1/search?q=Revolver&type=album");
    expect(httpGet).toHaveBeenCalledTimes(1);

  }));

  it('should get song...', inject([SpotifyService], (service: SpotifyService) => {
    let http = TestBed.get(Http);
    let response = new Response(new ResponseOptions());
    let responseJson = spyOn(response, 'json').and.returnValue.toString()

    let httpGet = spyOn(http, 'get').and.returnValue(Observable.of(response));

    service.getSong("Best Song Ever");

    expect(httpGet).toHaveBeenCalledWith("https://api.spotify.com/v1/search?q=Best Song Ever&type=track");
    expect(httpGet).toHaveBeenCalledTimes(1);

  }));

});
