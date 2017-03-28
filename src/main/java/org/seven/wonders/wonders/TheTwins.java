package org.seven.wonders.wonders;

import org.seven.wonders.cards.Card;

public class TheTwins extends Wonder {

  private static final Card[] SIDE_A = new Card[] {};

  private static final Card[] SIDE_B = new Card[] {};

  public static final TheTwins WONDER = new TheTwins(SIDE_A, SIDE_B);

  private TheTwins(Card[] caraA, Card[] caraB) {
    super(caraA, caraB);
  }
}
