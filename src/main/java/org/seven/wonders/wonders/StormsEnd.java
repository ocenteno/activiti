package org.seven.wonders.wonders;

import org.seven.wonders.cards.Card;

public class StormsEnd extends Wonder {

  private static final Card[] SIDE_A = new Card[] {};

  private static final Card[] SIDE_B = new Card[] {};

  public static final StormsEnd WONDER = new StormsEnd(SIDE_A, SIDE_B);

  private StormsEnd(Card[] caraA, Card[] caraB) {
    super(caraA, caraB);
  }
}
