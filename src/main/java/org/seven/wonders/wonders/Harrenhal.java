package org.seven.wonders.wonders;

import org.seven.wonders.cards.Card;

public class Harrenhal extends Wonder {

  private static final Card[] SIDE_A = new Card[] {};

  private static final Card[] SIDE_B = new Card[] {};

  public static final Harrenhal WONDER = new Harrenhal(SIDE_A, SIDE_B);

  private Harrenhal(Card[] caraA, Card[] caraB) {
    super(caraA, caraB);
  }
}
