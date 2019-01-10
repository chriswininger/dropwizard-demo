package caw.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import caw.api.EnvironmentInfo;
import com.codahale.metrics.annotation.Timed;

@Path("/app-info")
@Produces(MediaType.APPLICATION_JSON)
public class AppInfoResource
{
  private final String environment;

  public AppInfoResource(String environment) {
    this.environment = environment;
  }

  @GET
  @Timed
  @Path("/environment")
  public EnvironmentInfo getEnvironmentInfo() {
    return new EnvironmentInfo(environment);
  }
}
