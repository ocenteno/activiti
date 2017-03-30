package org.seven.wonders.wonders;

import org.seven.wonders.cards.Card;

public class Babylon extends Wonder {

  private static final Card[] SIDE_A = new Card[] {};

  private static final Card[] SIDE_B = new Card[] {};

  public static final Babylon WONDER = new Babylon(SIDE_A, SIDE_B);

  private Babylon(Card[] caraA, Card[] caraB) {
    super(caraA, caraB);
  }
}
