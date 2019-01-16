package caw.db;

import java.util.List;

import caw.models.ChapterModel;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

public interface ChapterDAO
{
  @SqlQuery("SELECT * FROM chapters")
  @RegisterBeanMapper(ChapterModel.class)
  List<ChapterModel> getAllChapters();

  @SqlQuery("SELECT * FROM chapters WHERE book_id = :bookId")
  @RegisterBeanMapper(ChapterModel.class)
  List<ChapterModel> getChaptersByBookId(@Bind("bookId") final int bookId);

  @SqlQuery("SELECT * FROM chapters WHERE id = :id")
  @RegisterBeanMapper(ChapterModel.class)
  ChapterModel getChapterById(@Bind("id") int id);

  // notice the use of query, this is to allow a non-void return type
  @SqlQuery("INSERT INTO chapters (name, book_id) " +
      "VALUES(:name, :bookId) RETURNING *; --")
  @RegisterBeanMapper(ChapterModel.class)
  ChapterModel insertChapter(@BindBean ChapterModel chapterModel);

  @SqlUpdate("UPDATE chapters SET name = :name, book_id = :bookId WHERE id = :id")
  void updateChapter(@BindBean ChapterModel chapterModel);

  @SqlUpdate("DELETE FROM chapters WHERE id = :id")
  void deleteChapter(@Bind("id") int id);
}
