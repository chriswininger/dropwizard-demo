import { Component, Input, OnInit } from '@angular/core';
import { BookModel } from '../../models/BookModel'

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent implements OnInit {
  @Input() book: BookModel

  constructor() { }

  ngOnInit() {
  }

}
