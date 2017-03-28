package org.seven.wonders.wonders;

import org.seven.wonders.cards.Card;

public class Dragonstone extends Wonder {

  private static final Card[] SIDE_A = new Card[] {};

  private static final Card[] SIDE_B = new Card[] {};

  public static final Dragonstone WONDER = new Dragonstone(SIDE_A, SIDE_B);

  private Dragonstone(Card[] caraA, Card[] caraB) {
    super(caraA, caraB);
  }
}
