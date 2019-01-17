import { Component, OnInit } from '@angular/core';
import { BookService } from '../../services/BookService'
import { BookModel } from '../../models/BookModel'
import { AuthorService } from '../../services/AuthorService'
import { AuthorModel } from '../../models/AuthorModel'
import { forkJoin } from 'rxjs'
import { tap } from 'rxjs/operators'

interface AuthorByBookId {
  [s: string]: AuthorModel
}

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css']
})
export class BookListComponent implements OnInit {
  public books: BookModel [] = []
  public booksByAuthor: AuthorByBookId = {}
  public error: string = null
  public loading = true

  constructor(
    private bookService: BookService,
    private authorService: AuthorService
  ) {}

  ngOnInit() {
    this.bookService.getAllBooks().subscribe(
      books => {
        this.books = books
        this.books.map(book => {
          this.authorService.getAuthorById(book.authorId).subscribe(
            author => this.booksByAuthor[book.id] = author
          )
        })

        this.loading = false
      },
        err => this.error = err
    )
  }

}
