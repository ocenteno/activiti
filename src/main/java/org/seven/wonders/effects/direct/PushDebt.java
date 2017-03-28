package org.seven.wonders.effects.direct;

import org.seven.wonders.effects.ValueEffect;
import org.seven.wonders.wonders.Wonder;

public class PushDebt extends ValueEffect {

  private PushDebt(int value) {
    super(value);
  }

  public static PushDebt instantiate(int value) {
    return new PushDebt(value);
  }

  @Override
  public void apply(Wonder... others) {
    for (Wonder wonder : others) {
      wonder.debt((int)getValue());
    }
  }

}
