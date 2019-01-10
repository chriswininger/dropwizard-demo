package caw.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthorModel
{
  private int id;
  private String name;

  public AuthorModel() {}

  public AuthorModel(int id, String name) {
    this.id = id;
    this.name = name;
  }

  @JsonProperty
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @JsonProperty
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
