package org.seven.wonders.wonders;

import org.seven.wonders.cards.Card;

public class CasterlyRock extends Wonder {

  private static final Card[] SIDE_A = new Card[] {};

  private static final Card[] SIDE_B = new Card[] {};

  public static final CasterlyRock WONDER = new CasterlyRock(SIDE_A, SIDE_B);

  private CasterlyRock(Card[] caraA, Card[] caraB) {
    super(caraA, caraB);
  }
}
