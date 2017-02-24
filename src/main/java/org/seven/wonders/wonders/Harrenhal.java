package org.seven.wonders.wonders;

import org.seven.wonders.cards.Card;

public class Harrenhal extends Wonder {

  private static final Card[] CARA_A = new Card[] {};

  private static final Card[] CARA_B = new Card[] {};

  public static final Harrenhal WONDER = new Harrenhal(CARA_A, CARA_B);

  private Harrenhal(Card[] caraA, Card[] caraB) {
    super(caraA, caraB);
  }
}
