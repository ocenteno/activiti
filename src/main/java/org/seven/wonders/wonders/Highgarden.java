package org.seven.wonders.wonders;

import org.seven.wonders.cards.Card;

public class Highgarden extends Wonder {

  private static final Card[] SIDE_A = new Card[] {};

  private static final Card[] SIDE_B = new Card[] {};

  public static final Highgarden WONDER = new Highgarden(SIDE_A, SIDE_B);

  private Highgarden(Card[] caraA, Card[] caraB) {
    super(caraA, caraB);
  }
}
