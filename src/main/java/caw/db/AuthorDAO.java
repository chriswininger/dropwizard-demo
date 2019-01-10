package caw.db;

import java.util.List;

import caw.models.AuthorModel;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

public interface AuthorDAO {

  @SqlQuery("SELECT * FROM authors")
  @RegisterBeanMapper(AuthorModel.class)
  List<AuthorModel> getAllAuthors();

  @SqlQuery("SELECT * FROM authors WHERE id = :id")
  @RegisterBeanMapper(AuthorModel.class)
  AuthorModel getAuthorById(@Bind("id") int id);

  // notice the use of query, this is to allow a non-void return type
  @SqlQuery("INSERT INTO authors (name) VALUES(:name) RETURNING *; --")
  @RegisterBeanMapper(AuthorModel.class)
  AuthorModel insertAuthor(@BindBean AuthorModel authorModel);

  @SqlUpdate("UPDATE authors SET name = :name WHERE id = :id")
  void updateAuthor(@BindBean AuthorModel authorModel);

  @SqlUpdate("DELETE FROM authors WHERE id = :id")
  void deleteAuthor(@Bind("id") int id);
}
