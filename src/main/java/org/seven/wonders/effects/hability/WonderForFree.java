package org.seven.wonders.effects.hability;

import org.seven.wonders.effects.HabilityEffect;
import org.seven.wonders.wonders.Wonder;

public class WonderForFree extends HabilityEffect {

  public static final WonderForFree INSTANCE = new WonderForFree();

  @Override
  public void apply(Wonder... others) {
    for (Wonder wonder : others) {
      wonder.enable(WonderForFree.class);
    }
  }

}
