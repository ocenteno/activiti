package org.seven.wonders.wonders;

import org.seven.wonders.cards.Card;

public class TheEyre extends Wonder {

  private static final Card[] CARA_A = new Card[] {};

  private static final Card[] CARA_B = new Card[] {};

  public static final TheEyre WONDER = new TheEyre(CARA_A, CARA_B);

  private TheEyre(Card[] caraA, Card[] caraB) {
    super(caraA, caraB);
  }
}
