package org.seven.wonders.effects.direct;

import org.seven.wonders.effects.DirectEffect;
import org.seven.wonders.wonders.Wonder;

public class ChangeWonder extends DirectEffect {

  public static final ChangeWonder INSTANCE = new ChangeWonder();

  @Override
  public void apply(Wonder... others) {
    for (Wonder wonder : others) {
      wonder.addVPs((int)getValue());
    }
  }

}
