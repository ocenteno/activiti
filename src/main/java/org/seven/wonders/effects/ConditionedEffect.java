package org.seven.wonders.effects;

import lombok.Data;

@Data
public abstract class ConditionedEffect implements Effect {

  private final Type type = Type.CONDITIONED;

  private final Object value;

  private final Condition condition;

}
