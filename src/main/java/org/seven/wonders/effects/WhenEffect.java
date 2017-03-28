package org.seven.wonders.effects;

import lombok.Data;

@Data
public abstract class WhenEffect implements Effect {

  private final Type type = Type.WHEN;

  private final Object value;

  private final When condition;

}
