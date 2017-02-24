package org.seven.wonders.wonders;

import org.seven.wonders.cards.Card;

public class Weirwood extends Wonder {

  private static final Card[] CARA_A = new Card[] {};

  private static final Card[] CARA_B = new Card[] {};

  public static final Weirwood WONDER = new Weirwood(CARA_A, CARA_B);

  private Weirwood(Card[] caraA, Card[] caraB) {
    super(caraA, caraB);
  }
}
