package org.seven.wonders.wonders;

import org.seven.wonders.cards.Card;

public class Olympia extends Wonder {

  private static final Card[] SIDE_A = new Card[] {};

  private static final Card[] SIDE_B = new Card[] {};

  public static final Olympia WONDER = new Olympia(SIDE_A, SIDE_B);

  private Olympia(Card[] caraA, Card[] caraB) {
    super(caraA, caraB);
  }
}
