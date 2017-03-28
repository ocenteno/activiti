package org.seven.wonders.effects.direct;

import org.seven.wonders.effects.ValueEffect;
import org.seven.wonders.wonders.Wonder;

public class GetVPs extends ValueEffect {

  private GetVPs(int value) {
    super(value);
  }

  public static GetVPs instantiate(int value) {
    return new GetVPs(value);
  }

  @Override
  public void apply(Wonder... others) {
    for (Wonder wonder : others) {
      wonder.addVPs((int)getValue());
    }
  }

}
