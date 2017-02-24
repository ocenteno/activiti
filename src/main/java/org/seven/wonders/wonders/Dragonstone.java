package org.seven.wonders.wonders;

import org.seven.wonders.cards.Card;

public class Dragonstone extends Wonder {

  private static final Card[] CARA_A = new Card[] {};

  private static final Card[] CARA_B = new Card[] {};

  public static final Dragonstone WONDER = new Dragonstone(CARA_A, CARA_B);

  private Dragonstone(Card[] caraA, Card[] caraB) {
    super(caraA, caraB);
  }
}
