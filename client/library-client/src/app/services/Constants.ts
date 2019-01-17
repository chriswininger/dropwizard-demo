import { HttpHeaders } from '@angular/common/http'

export const httpHeaders = new HttpHeaders()
  .append('Content-Type', 'application/json')
  .append( 'Accept', 'application/json')
  .append('Access-Control-Allow-Origin', '*')


export const baseUrl = 'http://localhost:8080/'
