package org.seven.wonders.wonders;

import org.seven.wonders.cards.Card;

public class Gizah extends Wonder {

  private static final Card[] SIDE_A = new Card[] {};

  private static final Card[] SIDE_B = new Card[] {};

  public static final Gizah WONDER = new Gizah(SIDE_A, SIDE_B);

  private Gizah(Card[] caraA, Card[] caraB) {
    super(caraA, caraB);
  }
}
