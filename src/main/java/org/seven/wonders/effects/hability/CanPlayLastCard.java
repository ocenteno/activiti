package org.seven.wonders.effects.hability;

import org.seven.wonders.effects.HabilityEffect;
import org.seven.wonders.wonders.Wonder;

public class CanPlayLastCard extends HabilityEffect {

  public static final CanPlayLastCard INSTANCE = new CanPlayLastCard();

  @Override
  public void apply(Wonder... others) {
    for (Wonder wonder : others) {
      wonder.enable(CanPlayLastCard.class);
    }
  }

}
