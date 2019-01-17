import { Injectable } from '@angular/core'
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs'
import { baseUrl, httpHeaders } from './Constants'
import { map } from 'rxjs/operators'
import { AuthorModel } from '../models/AuthorModel'

@Injectable()
export class AuthorService {
  constructor(private httpClient: HttpClient) {}

  getAuthorById(authorId: number | string): Observable<AuthorModel> {
    return this.httpClient
      .get(`${baseUrl}api/authors/${authorId}`, {headers: httpHeaders })
      .pipe(
        map(authorRespObj => {
          return <AuthorModel>authorRespObj
        })
      )
  }
}
