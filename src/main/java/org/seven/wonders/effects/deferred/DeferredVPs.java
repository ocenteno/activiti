package org.seven.wonders.effects.deferred;

import org.seven.wonders.effects.Condition;
import org.seven.wonders.effects.DeferredEffect;
import org.seven.wonders.wonders.Wonder;

public class DeferredVPs extends DeferredEffect {

  private DeferredVPs(int value, Condition condition) {
    super(value, condition);
  }

  public static DeferredVPs instantiate(int value, Condition condition) {
    return new DeferredVPs(value, condition);
  }

  @Override
  public void apply(Wonder... others) {
    for (Wonder wonder : others) {
      wonder.addVPs((int)getValue());
    }
  }

}
