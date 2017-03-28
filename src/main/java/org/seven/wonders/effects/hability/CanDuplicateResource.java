package org.seven.wonders.effects.hability;

import org.seven.wonders.effects.HabilityEffect;
import org.seven.wonders.wonders.Wonder;

public class CanDuplicateResource extends HabilityEffect {

  public static final CanDuplicateResource INSTANCE = new CanDuplicateResource();

  @Override
  public void apply(Wonder... others) {
    for (Wonder wonder : others) {
      wonder.enable(CanDuplicateResource.class);
    }
  }

}
