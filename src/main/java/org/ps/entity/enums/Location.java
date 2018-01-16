package org.ps.entity.enums;

/**
 * Created by vepa on 22/9/17.
 */
public enum Location {
  LOCATION_1("Location 01"), LOCATION_2("Location 02");

  private String description;

  private Location(String desc) {
    this.description = desc;
  }

  public String getDescription() {
    return this.description;
  }

}
