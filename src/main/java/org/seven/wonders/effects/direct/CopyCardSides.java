package org.seven.wonders.effects.direct;

import org.seven.wonders.cards.Card;
import org.seven.wonders.effects.Condition;
import org.seven.wonders.effects.ConditionedEffect;
import org.seven.wonders.wonders.Wonder;

public class CopyCardSides extends ConditionedEffect {

  public static CopyCardSides LEADER = new CopyCardSides(Condition.SIDE_LEADERS);

  private CopyCardSides(Condition condition) {
    super(Card.class, condition);
  }

  public static CopyCardSides instantiate(Condition condition) {
    return new CopyCardSides(condition);
  }

  @Override
  public void apply(Wonder... others) {
    for (Wonder wonder : others) {
      wonder.addVPs((int)getValue());
    }
  }

}
