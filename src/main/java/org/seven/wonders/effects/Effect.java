package org.seven.wonders.effects;

import java.io.Serializable;

import org.seven.wonders.wonders.Wonder;

public interface Effect extends Serializable {

  public Type getType();

  public Object getValue();

  public void apply(Wonder... wonder);

  public static enum Type {
    WHEN,
    ACTION,
    DIRECT,
    DOUBLE,
    END_VPS,
    COMMERCE,
    CONDITIONED;
  }

}
