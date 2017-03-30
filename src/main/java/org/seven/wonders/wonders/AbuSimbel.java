package org.seven.wonders.wonders;

import org.seven.wonders.cards.Card;

public class AbuSimbel extends Wonder {

  private static final Card[] SIDE_A = new Card[] {};

  private static final Card[] SIDE_B = new Card[] {};

  public static final AbuSimbel WONDER = new AbuSimbel(SIDE_A, SIDE_B);

  private AbuSimbel(Card[] caraA, Card[] caraB) {
    super(caraA, caraB);
  }
}
