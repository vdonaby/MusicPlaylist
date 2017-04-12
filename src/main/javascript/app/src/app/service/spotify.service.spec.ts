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
    let responeJson = spyOn(response, 'json').and.returnValue({results: [{id:1},{id:2}]});

    let httpGet = spyOn(http, 'get').and.returnValue(Observable.of(response))

  }));

});
