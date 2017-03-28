package org.seven.wonders.effects.deferred;

import org.seven.wonders.cards.Card;
import org.seven.wonders.effects.Condition;
import org.seven.wonders.effects.DeferredEffect;
import org.seven.wonders.wonders.Wonder;

public class CopyCardEnd extends DeferredEffect {

  public static final CopyCardEnd GREEN = new CopyCardEnd(Condition.SIDE_GREENS);

  private CopyCardEnd(Condition condition) {
    super(Card.class, condition);
  }

  public static CopyCardEnd instantiate(Condition condition) {
    return new CopyCardEnd(condition);
  }

  @Override
  public void apply(Wonder... others) {
    for (Wonder wonder : others) {
    }
  }

}
