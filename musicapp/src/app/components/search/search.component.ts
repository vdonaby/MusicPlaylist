import { Component, OnInit } from '@angular/core';
import {SpotifyService} from '../../services/spotify.service';

@Component({
  selector: 'search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css'],
  providers:[SpotifyService]
})

export class SearchComponent  {

  searchString:string;
  searchArtist: Artist[];


  search(){
    this.spotifyService.search(this.searchString)
      .subscribe(res => {
        this.searchArtist = res.artists.items;
      })
}



  //constructor for inj. service
  constructor(private spotifyService:SpotifyService){
  }

}
