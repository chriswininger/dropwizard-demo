package caw.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EnvironmentInfo
{
  private String environment;

  public EnvironmentInfo() {}
  public EnvironmentInfo(final String environment) {
    this.environment = environment;
  }

  @JsonProperty
  public String getEnvironment() {
    return this.environment;
  }
}
