package org.seven.wonders.wonders;

import org.seven.wonders.cards.Card;

public class Mereen extends Wonder {

  private static final Card[] SIDE_A = new Card[] {};

  private static final Card[] SIDE_B = new Card[] {};

  public static final Mereen WONDER = new Mereen(SIDE_A, SIDE_B);

  private Mereen(Card[] caraA, Card[] caraB) {
    super(caraA, caraB);
  }
}
