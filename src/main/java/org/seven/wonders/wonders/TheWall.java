package org.seven.wonders.wonders;

import static org.seven.wonders.tokens.Resource.*;

import org.seven.wonders.cards.Card;
import org.seven.wonders.cards.Card.Color;
import org.seven.wonders.cards.Stage;
import org.seven.wonders.effects.Condition;
import org.seven.wonders.effects.Effect;
import org.seven.wonders.effects.action.FreezeAction;
import org.seven.wonders.effects.cond.PushDebtIf;
import org.seven.wonders.effects.cond.RemoveTokenIf;
import org.seven.wonders.effects.direct.GetResources;
import org.seven.wonders.effects.direct.GetVPs;
import org.seven.wonders.effects.hability.CanBuyCheaper;
import org.seven.wonders.effects.mixed.CoinsForAllVPs;
import org.seven.wonders.tokens.Cost;
import org.seven.wonders.tokens.Token;

public class TheWall extends Wonder {

  private static final Card[] SIDE_A = new Card[] {//
    new Stage(PushDebtIf.instantiate(2, Condition.when(Color.WONDER)), new Cost(ORE, TEXTILE)),
    new Stage(CanBuyCheaper.BUY_BANK_1, new Cost(CLAY, WOOD)),
    new Stage(CoinsForAllVPs.instantiate(6, 14), new Cost(STONE, STONE, ORE, ORE, GLASS, TEXTILE)) };

  private static final Card[] SIDE_B = new Card[] {//
    new Stage(RemoveTokenIf.instantiate(Token.DEFEAT, Condition.CHAIN), new Cost(GLASS, TEXTILE)),
    new Stage(GetVPs.instantiate(7), new Cost(GLASS, TEXTILE, PAPYRUS)),
    new Stage(FreezeAction.instantiate(3), new Cost(STONE, CLAY, GLASS, TEXTILE, PAPYRUS)) };

  public static final TheWall WONDER = new TheWall(SIDE_A, SIDE_B);

  private TheWall(Card[] caraA, Card[] caraB) {
    super(caraA, caraB);
  }

  @Override
  public Effect invoke() {
    if (getActiveSide() == SIDE_A) {
      return GetResources.instantiate(GLASS, STONE);
    }
    return CanBuyCheaper.BUY_ANY_1;
  }
}
