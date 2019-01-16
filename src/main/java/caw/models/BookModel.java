package caw.models;

public class BookModel
{
  private Integer id;
  private String title;
  private int authorId;
  private Integer copyrightYear;

  public BookModel() {}

  public BookModel(
      Integer id,
      String title,
      int authorId,
      Integer copyrightYear
  ) {
    this.id = id;
    this.title = title;
    this.authorId = authorId;
    this.copyrightYear = copyrightYear;
  }

  public Integer getId() {
    return id;
  }

  public void setId(final Integer id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(final String title) {
    this.title = title;
  }

  public int getAuthorId() {
    return authorId;
  }

  public void setAuthorId(final int authorId) {
    this.authorId = authorId;
  }

  public Integer getCopyrightYear() {
    return copyrightYear;
  }

  public void setCopyrightYear(final Integer copyrightYear) {
    this.copyrightYear = copyrightYear;
  }
}
