package org.seven.wonders.wonders;

import org.seven.wonders.cards.Card;

public class Sunspear extends Wonder {

  private static final Card[] CARA_A = new Card[] {};

  private static final Card[] CARA_B = new Card[] {};

  public static final Sunspear WONDER = new Sunspear(CARA_A, CARA_B);

  private Sunspear(Card[] caraA, Card[] caraB) {
    super(caraA, caraB);
  }
}
