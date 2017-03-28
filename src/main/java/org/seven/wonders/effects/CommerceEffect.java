package org.seven.wonders.effects;

import lombok.Data;

@Data
public abstract class CommerceEffect extends HabilityEffect {

  protected final Type type = Type.COMMERCE;

  protected final SubType subType;

  protected final Condition condition;

  protected final Object value;

  public enum SubType {
    COST,
    DISCOUNT
  }

}
