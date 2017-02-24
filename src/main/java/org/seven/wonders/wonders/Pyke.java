package org.seven.wonders.wonders;

import org.seven.wonders.cards.Card;

public class Pyke extends Wonder {

  private static final Card[] CARA_A = new Card[] {};

  private static final Card[] CARA_B = new Card[] {};

  public static final Pyke WONDER = new Pyke(CARA_A, CARA_B);

  private Pyke(Card[] caraA, Card[] caraB) {
    super(caraA, caraB);
  }
}
