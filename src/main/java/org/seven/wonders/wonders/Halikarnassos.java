package org.seven.wonders.wonders;

import org.seven.wonders.cards.Card;

public class Halikarnassos extends Wonder {

  private static final Card[] SIDE_A = new Card[] {};

  private static final Card[] SIDE_B = new Card[] {};

  public static final Halikarnassos WONDER = new Halikarnassos(SIDE_A, SIDE_B);

  private Halikarnassos(Card[] caraA, Card[] caraB) {
    super(caraA, caraB);
  }
}
