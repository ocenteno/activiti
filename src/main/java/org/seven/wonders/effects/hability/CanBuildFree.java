package org.seven.wonders.effects.hability;

import org.seven.wonders.effects.DirectEffect;
import org.seven.wonders.wonders.Wonder;

public class CanBuildFree extends DirectEffect {

  public static final CanBuildFree INSTANCE = new CanBuildFree();

  @Override
  public void apply(Wonder... wonders) {
    for (Wonder wonder : wonders) {
      wonder.enable(CanHaveCardTwice.class);
    }
  }

}
