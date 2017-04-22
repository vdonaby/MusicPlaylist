import {ComponentFixture, TestBed} from '@angular/core/testing';

import { ArtistComponent } from './artist.component';

describe('ArtistComponent', () => {
  let component: ArtistComponent;
  //the result to provide feature for testing component
  let fixture: ComponentFixture<ArtistComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ ArtistComponent ]
    });
    //create instance of component, ArtistComponent
    fixture = TestBed.createComponent(ArtistComponent);
    component = fixture.componentInstance;
  });
   //select the target component and the toBeDefined method to do the test
 //it("artist is defined", () => {expect(component).toBeDefined()});

});

// To-do: testing data bindings

