package org.seven.wonders.effects.cond;

import org.seven.wonders.effects.Condition;
import org.seven.wonders.effects.ConditionedEffect;
import org.seven.wonders.wonders.Wonder;

public class PushDebtIf extends ConditionedEffect {

  private PushDebtIf(int value, Condition condition) {
    super(value, condition);
  }

  public static PushDebtIf instantiate(int value, Condition condition) {
    return new PushDebtIf(value, condition);
  }

  @Override
  public void apply(Wonder... others) {
    for (Wonder wonder : others) {
      wonder.debt((int)getValue());
    }
  }

}
