package org.seven.wonders.wonders;

import org.seven.wonders.cards.Card;

public class Winterfell extends Wonder {

  private static final Card[] CARA_A = new Card[] {};

  private static final Card[] CARA_B = new Card[] {};

  public static final Winterfell WONDER = new Winterfell(CARA_A, CARA_B);

  private Winterfell(Card[] caraA, Card[] caraB) {
    super(caraA, caraB);
  }
}
