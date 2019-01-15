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

import caw.db.AuthorDAO;
import caw.models.AuthorModel;
import com.codahale.metrics.annotation.Metered;
import com.codahale.metrics.annotation.Timed;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Path("api/authors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Api(value = "/api/authors", description = "Operations on authors")
public class AuthorResource
{
  private final AuthorDAO authorDAO;

  public AuthorResource(AuthorDAO authorDAO) {
    this.authorDAO = authorDAO;
  }

  @GET
  @Metered
  @ApiOperation(value = "Get a list of all authors", response = AuthorModel.class, responseContainer = "List")
  public List<AuthorModel> getAllAuthors() {
    return this.authorDAO.getAllAuthors();
  }

  @GET
  @Timed
  @Path("/{id}")
  @ApiOperation(value = "Get a single author by id", response = AuthorModel.class)
  public AuthorModel getAuthorById(@PathParam("id") final int id) {
    return this.authorDAO.getAuthorById(id);
  }

  @POST
  @Timed
  @ApiOperation(value = "Insert new author", response = AuthorModel.class)
  public AuthorModel insertAuthor(@Valid AuthorModel authorModel) {
    return this.authorDAO.insertAuthor(authorModel);
  }

  @PUT
  @Timed
  @ApiOperation(value = "Update an existing author by id", response = void.class)
  public void updateAuthor(@Valid AuthorModel authorModel) {
    this.authorDAO.updateAuthor(authorModel);
  }

  @DELETE
  @Timed
  @Path("/{id}")
  @ApiOperation(value = "Delete an author by id", response = void.class)
  public void deleteAuthorById(@PathParam("id") final int id) {
    this.authorDAO.deleteAuthor(id);
  }
}
