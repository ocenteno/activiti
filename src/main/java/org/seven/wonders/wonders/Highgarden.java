package org.seven.wonders.wonders;

import org.seven.wonders.cards.Card;

public class Highgarden extends Wonder {

  private static final Card[] CARA_A = new Card[] {};

  private static final Card[] CARA_B = new Card[] {};

  public static final Highgarden WONDER = new Highgarden(CARA_A, CARA_B);

  private Highgarden(Card[] caraA, Card[] caraB) {
    super(caraA, caraB);
  }
}
