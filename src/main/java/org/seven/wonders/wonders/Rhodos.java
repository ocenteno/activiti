package org.seven.wonders.wonders;

import org.seven.wonders.cards.Card;

public class Rhodos extends Wonder {

  private static final Card[] SIDE_A = new Card[] {};

  private static final Card[] SIDE_B = new Card[] {};

  public static final Rhodos WONDER = new Rhodos(SIDE_A, SIDE_B);

  private Rhodos(Card[] caraA, Card[] caraB) {
    super(caraA, caraB);
  }
}
