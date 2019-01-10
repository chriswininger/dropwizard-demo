package caw.resources;

import java.util.List;

import javax.validation.Valid;
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
import com.codahale.metrics.annotation.Timed;

@Path("api/authors")
@Produces(MediaType.APPLICATION_JSON)
public class AuthorResource
{
  private final AuthorDAO authorDAO;

  public AuthorResource(AuthorDAO authorDAO) {
    this.authorDAO = authorDAO;
  }

  @GET
  @Timed
  public List<AuthorModel> getAllAuthors() {
    return this.authorDAO.getAllAuthors();
  }

  @GET
  @Timed
  @Path("/{id}")
  public AuthorModel getAuthorById(@PathParam("id") final int id) {
    return this.authorDAO.getAuthorById(id);
  }

  @POST
  @Timed
  public AuthorModel insertAuthor(@Valid AuthorModel authorModel) {
    return this.authorDAO.insertAuthor(authorModel);
  }

  @PUT
  @Timed
  public void updateAuthor(@Valid AuthorModel authorModel) {
    this.authorDAO.updateAuthor(authorModel);
  }

  @DELETE
  @Timed
  @Path("/{id}")
  public void deleteAuthorById(@PathParam("id") final int id) {
    this.authorDAO.deleteAuthor(id);
  }
}
