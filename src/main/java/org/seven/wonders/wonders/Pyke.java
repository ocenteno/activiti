package org.seven.wonders.wonders;

import org.seven.wonders.cards.Card;

public class Pyke extends Wonder {

  private static final Card[] SIDE_A = new Card[] {};

  private static final Card[] SIDE_B = new Card[] {};

  public static final Pyke WONDER = new Pyke(SIDE_A, SIDE_B);

  private Pyke(Card[] caraA, Card[] caraB) {
    super(caraA, caraB);
  }
}
