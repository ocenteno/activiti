package org.seven.wonders.wonders;

import org.seven.wonders.cards.Card;

public class Sunspear extends Wonder {

  private static final Card[] SIDE_A = new Card[] {};

  private static final Card[] SIDE_B = new Card[] {};

  public static final Sunspear WONDER = new Sunspear(SIDE_A, SIDE_B);

  private Sunspear(Card[] caraA, Card[] caraB) {
    super(caraA, caraB);
  }
}
