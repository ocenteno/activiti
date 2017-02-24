package org.seven.wonders.wonders;

import org.seven.wonders.cards.Card;

public class Mereen extends Wonder {

  private static final Card[] CARA_A = new Card[] {};

  private static final Card[] CARA_B = new Card[] {};

  public static final Mereen WONDER = new Mereen(CARA_A, CARA_B);

  private Mereen(Card[] caraA, Card[] caraB) {
    super(caraA, caraB);
  }
}
