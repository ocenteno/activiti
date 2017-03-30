package org.seven.wonders.wonders;

import org.seven.wonders.cards.Card;

public class GreatWall extends Wonder {

  private static final Card[] SIDE_A = new Card[] {};

  private static final Card[] SIDE_B = new Card[] {};

  public static final GreatWall WONDER = new GreatWall(SIDE_A, SIDE_B);

  private GreatWall(Card[] caraA, Card[] caraB) {
    super(caraA, caraB);
  }
}
