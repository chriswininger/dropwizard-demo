import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs'
import { baseUrl, httpHeaders } from './Constants'
import { map } from 'rxjs/operators'
import { Injectable } from '@angular/core'
import { ChapterModel } from '../models/ChapterModel'

@Injectable()
export class ChapterService {
  constructor(private httpClient: HttpClient) {}

  getAllChaptersByBookId(bookId: number | string): Observable<ChapterModel []> {
    return this.httpClient
      .get(`${baseUrl}api/chapters/books/${bookId}`, {headers: httpHeaders })
      .pipe(
        map((chpRespObj: any []) => {
          return chpRespObj.map(chpRespObj => <ChapterModel>chpRespObj)
        })
      )
  }
}
