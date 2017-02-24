package org.seven.wonders.wonders;

import org.seven.wonders.cards.Card;

public class TheTwins extends Wonder {

  private static final Card[] CARA_A = new Card[] {};

  private static final Card[] CARA_B = new Card[] {};

  public static final TheTwins WONDER = new TheTwins(CARA_A, CARA_B);

  private TheTwins(Card[] caraA, Card[] caraB) {
    super(caraA, caraB);
  }
}
