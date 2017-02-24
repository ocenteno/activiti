package org.seven.wonders.wonders;

import static org.seven.wonders.tokens.Resource.*;

import org.seven.wonders.cards.Card;
import org.seven.wonders.cards.Stage;
import org.seven.wonders.effects.Effect;
import org.seven.wonders.tokens.Cost;

public class Braavos extends Wonder {

  private static final Card[] CARA_A = new Card[] { //
    new Stage(Effect.debt(1), new Cost(2, GLASS, STONE)),
    new Stage(Effect.debt(6), new Cost(2, STONE, STONE, ORE, GLASS)),
    new Stage(Effect.victoryPoints(14), new Cost(WOOD, WOOD, CLAY, CLAY, TEXTILE, PAPYRUS)) };

  private static final Card[] CARA_B = new Card[] {

  };

  public static final Braavos WONDER = new Braavos(CARA_A, CARA_B);

  private Braavos(Card[] caraA, Card[] caraB) {
    super(caraA, caraB);
  }

  @Override
  public Effect invoke() {
    return Effect.coins(6);
  }
}
