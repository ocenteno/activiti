package org.seven.wonders.effects.hability;

import org.seven.wonders.effects.HabilityEffect;
import org.seven.wonders.wonders.Wonder;

public class CanPlayDuplicate extends HabilityEffect {

  public static final CanPlayDuplicate INSTANCE = new CanPlayDuplicate();

  @Override
  public void apply(Wonder... others) {
    for (Wonder wonder : others) {
      wonder.enable(CanPlayDuplicate.class);
    }
  }

}
