import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BookService } from './services/BookService';
import { BookListComponent } from './components/book-list/book-list.component'
import { HttpClientModule } from '@angular/common/http';
import { BookComponent } from './components/book/book.component'
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ChapterListComponent } from './components/chapter-list/chapter-list.component'
import { ChapterService } from './services/ChapterService'
import { AuthorService } from './services/AuthorService'

@NgModule({
  declarations: [
    AppComponent,
    BookListComponent,
    BookComponent,
    ChapterListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    NgbModule
  ],
  providers: [
    BookService,
    ChapterService,
    AuthorService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
