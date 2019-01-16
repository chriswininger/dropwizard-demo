package caw.resources;

import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import caw.db.ChapterDAO;
import caw.models.ChapterModel;
import com.codahale.metrics.annotation.Timed;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Path("api/chapters")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Api(value = "/api/chapters", description = "Operations on chapters")
public class ChapterResource
{
  private final ChapterDAO chapterDAO;

  public ChapterResource(ChapterDAO chapterDAO) {
    this.chapterDAO = chapterDAO;
  }

  @GET
  @Timed
  @ApiOperation(value = "Get a list of all chapters", response = ChapterModel.class, responseContainer = "List")
  public List<ChapterModel> getAllChapters() {
    return this.chapterDAO.getAllChapters();
  }

  @GET
  @Timed
  @ApiOperation(value = "Get a list of chapters by book id", response = ChapterModel.class, responseContainer = "List")
  @Path("/books/{bookId}")
  public List<ChapterModel> getChaptersByBookId(@PathParam("bookId") final int bookId) {
    return this.chapterDAO.getChaptersByBookId(bookId);
  }

  @GET
  @Timed
  @Path("/{id}")
  @ApiOperation(value = "Get a single chapter by id", response = ChapterModel.class)
  public ChapterModel getChapterById(@PathParam("id") final int id) {
    return this.chapterDAO.getChapterById(id);
  }

  @POST
  @Timed
  @ApiOperation(value = "Insert new chapter", response = ChapterModel.class)
  public ChapterModel insertChapter(@Valid ChapterModel chapterModel) {
    return this.chapterDAO.insertChapter(chapterModel);
  }

  @PUT
  @Timed
  @ApiOperation(value = "Update an existing chapter by id", response = void.class)
  public void updateChapter(@Valid ChapterModel chapterModel) {
    this.chapterDAO.updateChapter(chapterModel);
  }

  @DELETE
  @Timed
  @Path("/{id}")
  @ApiOperation(value = "Delete an chapter by id", response = void.class)
  public void deleteChapterById(@PathParam("id") final int id) {
    this.chapterDAO.deleteChapter(id);
  }
}
