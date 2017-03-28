package org.seven.wonders.effects.direct;

import org.seven.wonders.effects.ValueEffect;
import org.seven.wonders.tokens.Science;
import org.seven.wonders.wonders.Wonder;

public class GetScience extends ValueEffect {

  private GetScience(Science... value) {
    super(value);
  }

  public static GetScience instantiate(Science... value) {
    return new GetScience(value);
  }

  @Override
  public void apply(Wonder... others) {
    for (Wonder wonder : others) {
      wonder.addScience((Science[])getValue());
    }
  }

}
