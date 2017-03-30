package org.seven.wonders.wonders;

import org.seven.wonders.cards.Card;

public class Rome extends Wonder {

  private static final Card[] SIDE_A = new Card[] {};

  private static final Card[] SIDE_B = new Card[] {};

  public static final Rome WONDER = new Rome(SIDE_A, SIDE_B);

  private Rome(Card[] caraA, Card[] caraB) {
    super(caraA, caraB);
  }
}
