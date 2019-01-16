package caw.db;

import java.util.List;

import caw.models.BookModel;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

public interface BookDao
{
  @SqlQuery("SELECT * FROM books")
  @RegisterBeanMapper(BookModel.class)
  List<BookModel> getAllBooks();

  @SqlQuery("SELECT * FROM books WHERE id = :id")
  @RegisterBeanMapper(BookModel.class)
  BookModel getBookById(@Bind("id") int id);

  // notice the use of query, this is to allow a non-void return type
  @SqlQuery("INSERT INTO books (title, author_id, copyright_year) " +
      "VALUES(:title, :authorId, :copyrightYear) RETURNING *; --")
  @RegisterBeanMapper(BookModel.class)
  BookModel insertBook(@BindBean BookModel bookModel);

  @SqlUpdate("UPDATE books SET title = :title, author_id = :authorId, copyright_year = :copyrightYear WHERE id = :id")
  void updateBook(@BindBean BookModel bookModel);

  @SqlUpdate("DELETE FROM books WHERE id = :id")
  void deleteBook(@Bind("id") int id);
}
