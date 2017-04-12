import { TestBed, inject } from '@angular/core/testing';
import { SpotifyService } from './spotify.service';
import {Http, Response, ResponseOptions} from "@angular/http";
import {Observable} from "rxjs";

describe('SpotifyService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [SpotifyService]
    });
  });

  it('should create service...', inject([SpotifyService], (service: SpotifyService) => {
    expect(service).toBeTruthy();
  }));

  it('should get artist...', inject([SpotifyService], (service: SpotifyService) => {
    let http = TestBed.get(Http);
    let response = new Response(new ResponseOptions());
    let responeJson = spyOn(response, 'json').and.returnValue({results: [{id:1},{id:2}]});

    let httpGet = spyOn(http, 'get').and.returnValue(Observable.of(response))

  }));

});
