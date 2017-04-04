import {NgModule} from "@angular/core";
import {Routes, RouterModule} from "@angular/router";
import {ArticleDetailComponent} from "./album-detail/album-detail.component";
import {ArticleDetailResolverService} from "./album-detail/album-detail-resolver.service";
import {ArticleListComponent} from "./album-list/album-list.component";
import {ArticleListResolverService} from "./album-list/album-list-resolver.service";


const routes: Routes = [
  {
    path: 'articles/:category/:time/:id',
    component: ArticleDetailComponent,
    resolve: {
      article: ArticleDetailResolverService
    }
  },
  {
    path: 'articles/:category/:time',
    component: ArticleListComponent,
    resolve: {
      articleList: ArticleListResolverService
    }
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
  providers: [ArticleDetailResolverService, ArticleListResolverService]
})
export class ArticleRoutingModule {
}
