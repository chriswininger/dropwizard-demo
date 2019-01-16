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

import caw.db.BookDao;
import caw.models.BookModel;
import com.codahale.metrics.annotation.Timed;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Path("api/books")
@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Api(value = "api/books", description = "Operations on books")
public class BookResource
{
  private final BookDao bookDAO;
  
  public BookResource(final BookDao bookDAO) {
    this.bookDAO = bookDAO;
  }

  @GET
  @Timed
  @ApiOperation(value = "Get a list of all books", response = BookModel.class, responseContainer = "List")
  public List<BookModel> getAllBooks() {
    return this.bookDAO.getAllBooks();
  }

  @GET
  @Timed
  @Path("/{id}")
  @ApiOperation(value = "Get a single book by id", response = BookModel.class)
  public BookModel getBookById(@PathParam("id") final int id) {
    return this.bookDAO.getBookById(id);
  }

  @POST
  @Timed
  @ApiOperation(value = "Insert new book", response = BookModel.class)
  public BookModel insertBook(@Valid BookModel bookModel) {
    return this.bookDAO.insertBook(bookModel);
  }

  @PUT
  @Timed
  @ApiOperation(value = "Update an existing book by id", response = void.class)
  public void updateBook(@Valid BookModel bookModel) {
    this.bookDAO.updateBook(bookModel);
  }

  @DELETE
  @Timed
  @Path("/{id}")
  @ApiOperation(value = "Delete an book by id", response = void.class)
  public void deleteBookById(@PathParam("id") final int id) {
    this.bookDAO.deleteBook(id);
  }
}
