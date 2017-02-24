package org.seven.wonders.wonders;

import org.seven.wonders.cards.Card;

public class TheWall extends Wonder {

  private static final Card[] CARA_A = new Card[] {};

  private static final Card[] CARA_B = new Card[] {};

  public static final TheWall WONDER = new TheWall(CARA_A, CARA_B);

  private TheWall(Card[] caraA, Card[] caraB) {
    super(caraA, caraB);
  }
}
