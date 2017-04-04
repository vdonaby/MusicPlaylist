
/**
 Search Results by Album

 Album1: Search results list display each album as Artist name, Album name and album cover
 Album2: Clicking an individual album display Artist Name, Album Name, Album and cover and track listings, and release year
 Album3: Track listings should display track number, song title, and duration in minutes

 */

// ng g c album


import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AlbumComponent } from './album.component';

describe('AlbumComponent', () => {
  let component: AlbumComponent;
  let fixture: ComponentFixture<AlbumComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AlbumComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AlbumComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
