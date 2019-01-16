package caw.models;

public class ChapterModel
{
  public Integer id;
  public String name;
  public int bookId;

  public Integer getId() {
    return id;
  }

  public void setId(final Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  public int getBookId() {
    return bookId;
  }

  public void setBookId(final int bookId) {
    this.bookId = bookId;
  }
}
