package org.seven.wonders.wonders;

import org.seven.wonders.cards.Card;

public class Qarth extends Wonder {

  private static final Card[] SIDE_A = new Card[] {};

  private static final Card[] SIDE_B = new Card[] {};

  public static final Qarth WONDER = new Qarth(SIDE_A, SIDE_B);

  private Qarth(Card[] caraA, Card[] caraB) {
    super(caraA, caraB);
  }
}
