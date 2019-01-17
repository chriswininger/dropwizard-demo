import { Injectable } from '@angular/core'
import { HttpClient, HttpHeaders } from '@angular/common/http'
import { Observable } from 'rxjs'
import { BookModel } from '../models/BookModel'
import { map } from 'rxjs/operators'
import { baseUrl, httpHeaders } from './Constants'

@Injectable()
export class BookService {
  constructor(private httpClient: HttpClient) {}

  getAllBooks(): Observable<BookModel []> {
    return this.httpClient
      .get(`${baseUrl}api/books`, {headers: httpHeaders })
      .pipe(
        map((booksRespObj: any []) => {
          return booksRespObj.map(booksRespObj => <BookModel>booksRespObj)
        })
      )
  }
}
