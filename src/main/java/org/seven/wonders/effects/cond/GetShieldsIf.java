package org.seven.wonders.effects.cond;

import org.seven.wonders.effects.Condition;
import org.seven.wonders.effects.ConditionedEffect;
import org.seven.wonders.wonders.Wonder;

public class GetShieldsIf extends ConditionedEffect {

  private GetShieldsIf(int value, Condition condition) {
    super(value, condition);
  }

  public static GetShieldsIf instantiate(int shields, Condition condition) {
    return new GetShieldsIf(shields, condition);
  }

  @Override
  public void apply(Wonder... others) {
    for (Wonder wonder : others) {
      wonder.addShields((int)getValue());
    }
  }

}
