import {ComponentFixture, TestBed} from '@angular/core/testing';

import { ArtistComponent } from './artist.component';
import {FormsModule} from "@angular/forms";
import {SpotifyService} from "../../service/spotify.service";
import createSpyObj = jasmine.createSpyObj;
import {ActivatedRoute, Router} from "@angular/router";
import {HttpModule} from "@angular/http";
import {NO_ERRORS_SCHEMA} from "@angular/core";

describe('ArtistComponent', () => {
  let component: ArtistComponent;
  //the result to provide feature for testing component
  let fixture: ComponentFixture<ArtistComponent>;
  let mockActivatedRoute = createSpyObj<ActivatedRoute>('mockActivatedRoute', ['toString']);
  //let mockTestService = new MockTestService();
  let mockRouter = createSpyObj<Router>('mockRouter', ['toString']);

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpModule, FormsModule],
      declarations: [ ArtistComponent],
      providers: [{provide: SpotifyService}, {
        provide: ActivatedRoute,
        useValue: mockActivatedRoute
      }, {provide: Router, useValue: mockRouter}],
      schemas: [NO_ERRORS_SCHEMA]}
    );
    //create instance of component, ArtistComponent
    fixture = TestBed.createComponent(ArtistComponent);
    component = fixture.componentInstance;
  });
   //select the target component and the toBeDefined method to do the test
  it("artist is defined", () => {expect(component).toBeDefined()});
});


