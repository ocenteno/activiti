package org.seven.wonders.wonders;

import org.seven.wonders.cards.Card;

public class Stonehenge extends Wonder {

  private static final Card[] SIDE_A = new Card[] {};

  private static final Card[] SIDE_B = new Card[] {};

  public static final Stonehenge WONDER = new Stonehenge(SIDE_A, SIDE_B);

  private Stonehenge(Card[] caraA, Card[] caraB) {
    super(caraA, caraB);
  }
}
