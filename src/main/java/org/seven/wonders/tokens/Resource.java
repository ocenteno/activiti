package org.seven.wonders.tokens;

public enum Resource {
  WOOD,
  CLAY,
  STONE,
  ORE,
  TEXTILE,
  GLASS,
  PAPYRUS,
  ALL,
  ANY;

  public boolean isRaw() {
    return ordinal() < 4;
  }

  public boolean isManufactured() {
    return !isRaw() && ordinal() < 7;
  }

}
