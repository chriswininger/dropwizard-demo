import { Component, Input, OnInit } from '@angular/core';
import { ChapterService } from '../../services/ChapterService'
import { ChapterModel } from '../../models/ChapterModel'

@Component({
  selector: 'app-chapter-list',
  templateUrl: './chapter-list.component.html',
  styleUrls: ['./chapter-list.component.css']
})
export class ChapterListComponent implements OnInit {
  @Input() bookId: number | string

  public chapters: ChapterModel [] = []

  constructor(private chapterService: ChapterService) { }

  ngOnInit() {
    this.chapterService.getAllChaptersByBookId(this.bookId).subscribe(
      chapters => this.chapters = chapters
    )
  }

}
