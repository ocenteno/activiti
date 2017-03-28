package org.seven.wonders.wonders;

import org.seven.wonders.cards.Card;

public class Dreadfort extends Wonder {

  private static final Card[] SIDE_A = new Card[] {};

  private static final Card[] SIDE_B = new Card[] {};

  public static final Dreadfort WONDER = new Dreadfort(SIDE_A, SIDE_B);

  private Dreadfort(Card[] caraA, Card[] caraB) {
    super(caraA, caraB);
  }
}
