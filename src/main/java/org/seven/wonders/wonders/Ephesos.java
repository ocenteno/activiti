package org.seven.wonders.wonders;

import org.seven.wonders.cards.Card;

public class Ephesos extends Wonder {

  private static final Card[] SIDE_A = new Card[] {};

  private static final Card[] SIDE_B = new Card[] {};

  public static final Ephesos WONDER = new Ephesos(SIDE_A, SIDE_B);

  private Ephesos(Card[] caraA, Card[] caraB) {
    super(caraA, caraB);
  }
}
