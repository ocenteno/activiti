package org.seven.wonders.wonders;

import org.seven.wonders.cards.Card;

public class Brussels extends Wonder {

  private static final Card[] SIDE_A = new Card[] {};

  private static final Card[] SIDE_B = new Card[] {};

  public static final Brussels WONDER = new Brussels(SIDE_A, SIDE_B);

  private Brussels(Card[] caraA, Card[] caraB) {
    super(caraA, caraB);
  }
}
