package org.seven.wonders.wonders;

import org.seven.wonders.cards.Card;
import org.seven.wonders.effects.Effect;
import org.seven.wonders.effects.direct.GetCoins;

public class Alexandria extends Wonder {

  private static final Card[] SIDE_A = new Card[] {};

  private static final Card[] SIDE_B = new Card[] {};

  public static final Alexandria WONDER = new Alexandria(SIDE_A, SIDE_B);

  private Alexandria(Card[] caraA, Card[] caraB) {
    super(caraA, caraB);
  }

  @Override
  public Effect invoke() {
    return GetCoins.instantiate(6);
  }

}
