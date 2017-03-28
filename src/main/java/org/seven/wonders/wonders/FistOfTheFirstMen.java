package org.seven.wonders.wonders;

import org.seven.wonders.cards.Card;

public class FistOfTheFirstMen extends Wonder {

  private static final Card[] SIDE_A = new Card[] {};

  private static final Card[] SIDE_B = new Card[] {};

  public static final FistOfTheFirstMen WONDER = new FistOfTheFirstMen(SIDE_A, SIDE_B);

  private FistOfTheFirstMen(Card[] caraA, Card[] caraB) {
    super(caraA, caraB);
  }
}
