package org.seven.wonders.wonders;

import org.seven.wonders.cards.Card;
import org.seven.wonders.effects.Effect;

public class Weirwood extends Wonder {

  private static final Card[] SIDE_A = new Card[] {};

  private static final Card[] SIDE_B = new Card[] {};

  public static final Weirwood WONDER = new Weirwood(SIDE_A, SIDE_B);

  private Weirwood(Card[] caraA, Card[] caraB) {
    super(caraA, caraB);
  }

  @Override
  public Effect invoke() {
    return super.invoke();
  }
}
