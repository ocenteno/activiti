package org.seven.wonders.wonders;

import org.seven.wonders.cards.Card;

public class TheEyre extends Wonder {

  private static final Card[] SIDE_A = new Card[] {};

  private static final Card[] SIDE_B = new Card[] {};

  public static final TheEyre WONDER = new TheEyre(SIDE_A, SIDE_B);

  private TheEyre(Card[] caraA, Card[] caraB) {
    super(caraA, caraB);
  }
}
