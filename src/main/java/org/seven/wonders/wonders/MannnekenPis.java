package org.seven.wonders.wonders;

import org.seven.wonders.cards.Card;

public class MannnekenPis extends Wonder {

  private static final Card[] SIDE_A = new Card[] {};

  private static final Card[] SIDE_B = new Card[] {};

  public static final MannnekenPis WONDER = new MannnekenPis(SIDE_A, SIDE_B);

  private MannnekenPis(Card[] caraA, Card[] caraB) {
    super(caraA, caraB);
  }
}
