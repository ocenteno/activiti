package org.seven.wonders.wonders;

import org.seven.wonders.cards.Card;

public class Riverrun extends Wonder {

  private static final Card[] SIDE_A = new Card[] {};

  private static final Card[] SIDE_B = new Card[] {};

  public static final Riverrun WONDER = new Riverrun(SIDE_A, SIDE_B);

  private Riverrun(Card[] caraA, Card[] caraB) {
    super(caraA, caraB);
  }
}
