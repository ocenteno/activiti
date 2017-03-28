package org.seven.wonders.effects.direct;

import org.seven.wonders.effects.ValueEffect;
import org.seven.wonders.tokens.Resource;
import org.seven.wonders.wonders.Wonder;

public class GetResources extends ValueEffect {

  private GetResources(Resource value) {
    super(value);
  }

  private GetResources(Resource... value) {
    super(value);
  }

  public static GetResources instantiate(Resource value) {
    return new GetResources(value);
  }

  public static GetResources instantiate(Resource... value) {
    return new GetResources(value);
  }

  @Override
  public void apply(Wonder... others) {
    for (Wonder wonder : others) {
      if (getValue() instanceof Resource) {
        wonder.addResources((Resource)getValue());
      } else {
        wonder.addResources((Resource[])getValue());
      }
    }
  }

}
