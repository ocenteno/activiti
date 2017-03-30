package org.seven.wonders.wonders;

import org.seven.wonders.cards.Card;

public class AgiaSophia extends Wonder {

  private static final Card[] SIDE_A = new Card[] {};

  private static final Card[] SIDE_B = new Card[] {};

  public static final AgiaSophia WONDER = new AgiaSophia(SIDE_A, SIDE_B);

  private AgiaSophia(Card[] caraA, Card[] caraB) {
    super(caraA, caraB);
  }
}
