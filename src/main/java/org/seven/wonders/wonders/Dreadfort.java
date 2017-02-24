package org.seven.wonders.wonders;

import org.seven.wonders.cards.Card;

public class Dreadfort extends Wonder {

  private static final Card[] CARA_A = new Card[] {};

  private static final Card[] CARA_B = new Card[] {};

  public static final Dreadfort WONDER = new Dreadfort(CARA_A, CARA_B);

  private Dreadfort(Card[] caraA, Card[] caraB) {
    super(caraA, caraB);
  }
}
