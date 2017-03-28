package org.seven.wonders.effects.direct;

import org.seven.wonders.effects.ValueEffect;
import org.seven.wonders.wonders.Wonder;

public class GetCoins extends ValueEffect {

  private GetCoins(int value) {
    super(value);
  }

  public static GetCoins instantiate(int value) {
    return new GetCoins(value);
  }

  @Override
  public void apply(Wonder... others) {
    for (Wonder wonder : others) {
      wonder.addCoins((int)getValue());
    }
  }

}
