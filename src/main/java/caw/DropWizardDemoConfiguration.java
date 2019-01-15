package caw;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.db.DataSourceFactory;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import org.hibernate.validator.constraints.*;

import javax.validation.Valid;
import javax.validation.constraints.*;

public class DropWizardDemoConfiguration extends Configuration {
  @NotEmpty
  private String environment;

  @JsonProperty
  public String getEnvironment() {
    return this.environment;
  }

  @Valid
  @NotNull
  @JsonProperty
  private DataSourceFactory database = new DataSourceFactory();

  @JsonProperty("swagger")
  public SwaggerBundleConfiguration swaggerBundleConfiguration;

  public DataSourceFactory getDataSourceFactory() {
    return database;
  }

  @JsonProperty
  public void setEnvironment(final String environment) {
    this.environment = environment;
  }
}
