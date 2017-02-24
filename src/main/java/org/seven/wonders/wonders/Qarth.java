package org.seven.wonders.wonders;

import org.seven.wonders.cards.Card;

public class Qarth extends Wonder {

  private static final Card[] CARA_A = new Card[] {};

  private static final Card[] CARA_B = new Card[] {};

  public static final Qarth WONDER = new Qarth(CARA_A, CARA_B);

  private Qarth(Card[] caraA, Card[] caraB) {
    super(caraA, caraB);
  }
}
