import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {ArticleListComponent} from "./album-list/album-list.component";
import {ArticleDetailComponent} from "./album-detail/album-detail.component";
import {ArticleService} from "./services/album.service";
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";
import {FormsModule} from "@angular/forms";
import {HttpModule} from "@angular/http";
import {ArticleRoutingModule} from "./artist-routing.module";

@NgModule({
  imports: [
    FormsModule,
    HttpModule,
    CommonModule,
    NgbModule.forRoot(),
    ArticleRoutingModule
  ],
  declarations: [ArticleListComponent, ArticleDetailComponent],
  providers: [ArticleService]
})
export class ArticleModule {
}
