package org.seven.wonders.wonders;

import static org.seven.wonders.tokens.Resource.*;

import org.seven.wonders.cards.Card;
import org.seven.wonders.cards.Card.Color;
import org.seven.wonders.cards.Stage;
import org.seven.wonders.effects.Condition;
import org.seven.wonders.effects.Effect;
import org.seven.wonders.effects.deferred.DeferredVPs;
import org.seven.wonders.effects.direct.GetCoins;
import org.seven.wonders.effects.direct.GetVPs;
import org.seven.wonders.effects.direct.PushDebt;
import org.seven.wonders.effects.mixed.DebtCoins;
import org.seven.wonders.tokens.Cost;

public class Braavos extends Wonder {

  private static final Card[] SIDE_A = new Card[] { //
    new Stage(PushDebt.instantiate(1), new Cost(GLASS, STONE)),
    new Stage(PushDebt.instantiate(6), new Cost(2, STONE, STONE, ORE, GLASS)),
    new Stage(GetVPs.instantiate(14), new Cost(WOOD, WOOD, CLAY, CLAY, TEXTILE, PAPYRUS)) };

  private static final Card[] SIDE_B = new Card[] {//
    new Stage(DeferredVPs.instantiate(1, Condition.MY_BLUES), new Cost(GLASS, STONE)),
    new Stage(DebtCoins.instantiate(2, 11), new Cost(STONE, CLAY, CLAY, PAPYRUS)),
    new Stage(GetVPs.instantiate(8), Color.BLUE) };

  public static final Braavos WONDER = new Braavos(SIDE_A, SIDE_B);

  private Braavos(Card[] caraA, Card[] caraB) {
    super(caraA, caraB);
  }

  @Override
  public Effect invoke() {
    return GetCoins.instantiate(6);
  }

}
