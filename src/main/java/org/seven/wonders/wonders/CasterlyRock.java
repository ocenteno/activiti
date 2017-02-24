package org.seven.wonders.wonders;

import org.seven.wonders.cards.Card;

public class CasterlyRock extends Wonder {

  private static final Card[] CARA_A = new Card[] {};

  private static final Card[] CARA_B = new Card[] {};

  public static final CasterlyRock WONDER = new CasterlyRock(CARA_A, CARA_B);

  private CasterlyRock(Card[] caraA, Card[] caraB) {
    super(caraA, caraB);
  }
}
