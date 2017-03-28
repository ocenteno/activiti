package org.seven.wonders.effects;

import lombok.Data;

@Data
public abstract class DirectEffect implements Effect {

  private final Type type = Type.DIRECT;

  @Override
  public Object getValue() {
    return null;
  }

}
