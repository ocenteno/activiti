package org.seven.wonders.effects.hability;

import org.seven.wonders.effects.HabilityEffect;
import org.seven.wonders.wonders.Wonder;

public class CanGenerateResource extends HabilityEffect {

  public static final CanGenerateResource INSTANCE = new CanGenerateResource();

  @Override
  public void apply(Wonder... others) {
    for (Wonder wonder : others) {
      wonder.enable(CanGenerateResource.class);
    }
  }

}
