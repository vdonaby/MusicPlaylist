import { Component, OnInit } from '@angular/core';
import {SpotifyService} from "../../service/spotify.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-artist',
  templateUrl: './artist.component.html',
  styleUrls: ['./artist.component.css']
})
export class ArtistComponent implements OnInit {

  constructor() { }

  ngOnInit() {}

}
