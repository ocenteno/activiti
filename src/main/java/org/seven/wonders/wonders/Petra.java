package org.seven.wonders.wonders;

import org.seven.wonders.cards.Card;

public class Petra extends Wonder {

  private static final Card[] SIDE_A = new Card[] {};

  private static final Card[] SIDE_B = new Card[] {};

  public static final Petra WONDER = new Petra(SIDE_A, SIDE_B);

  private Petra(Card[] caraA, Card[] caraB) {
    super(caraA, caraB);
  }
}
