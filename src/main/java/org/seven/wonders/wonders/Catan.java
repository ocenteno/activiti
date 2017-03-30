package org.seven.wonders.wonders;

import org.seven.wonders.cards.Card;

public class Catan extends Wonder {

  private static final Card[] SIDE_A = new Card[] {};

  private static final Card[] SIDE_B = new Card[] {};

  public static final Catan WONDER = new Catan(SIDE_A, SIDE_B);

  private Catan(Card[] caraA, Card[] caraB) {
    super(caraA, caraB);
  }
}
