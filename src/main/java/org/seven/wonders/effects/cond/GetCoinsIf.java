package org.seven.wonders.effects.cond;

import org.seven.wonders.effects.Condition;
import org.seven.wonders.effects.ConditionedEffect;
import org.seven.wonders.wonders.Wonder;

public class GetCoinsIf extends ConditionedEffect {

  private GetCoinsIf(int value, Condition condition) {
    super(value, condition);
  }

  public static GetCoinsIf instantiate(int value, Condition condition) {
    return new GetCoinsIf(value, condition);
  }

  @Override
  public void apply(Wonder... others) {
    for (Wonder wonder : others) {
      wonder.addCoins((int)getValue());
    }
  }

}
