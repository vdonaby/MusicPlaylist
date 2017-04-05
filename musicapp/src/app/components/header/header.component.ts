/**
 * Created
 */

import { Component } from '@angular/core';

@Component({
  selector: 'header',
  templateUrl: './header.component.html'
})
export class HeaderComponent {

  private projectName:string;

  constructor(){
    this.projectName = 'MusicApp';
  }

}



