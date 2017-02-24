package org.seven.wonders.wonders;

import org.seven.wonders.cards.Card;

public class KingsLanding extends Wonder {

  private static final Card[] CARA_A = new Card[] {};

  private static final Card[] CARA_B = new Card[] {};

  public static final KingsLanding WONDER = new KingsLanding(CARA_A, CARA_B);

  private KingsLanding(Card[] caraA, Card[] caraB) {
    super(caraA, caraB);
  }
}
