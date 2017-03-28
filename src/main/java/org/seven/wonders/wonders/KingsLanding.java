package org.seven.wonders.wonders;

import org.seven.wonders.cards.Card;

public class KingsLanding extends Wonder {

  private static final Card[] SIDE_A = new Card[] {};

  private static final Card[] SIDE_B = new Card[] {};

  public static final KingsLanding WONDER = new KingsLanding(SIDE_A, SIDE_B);

  private KingsLanding(Card[] caraA, Card[] caraB) {
    super(caraA, caraB);
  }
}
