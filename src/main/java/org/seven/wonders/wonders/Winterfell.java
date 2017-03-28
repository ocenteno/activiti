package org.seven.wonders.wonders;

import static org.seven.wonders.tokens.Resource.*;

import org.seven.wonders.cards.Card;
import org.seven.wonders.cards.Card.Color;
import org.seven.wonders.cards.Stage;
import org.seven.wonders.effects.Condition;
import org.seven.wonders.effects.Effect;
import org.seven.wonders.effects.action.FreezeAction;
import org.seven.wonders.effects.cond.GetCoinsIf;
import org.seven.wonders.effects.cond.RemoveTokenIf;
import org.seven.wonders.effects.deferred.DeferredVPs;
import org.seven.wonders.effects.direct.GetCardsForFree;
import org.seven.wonders.effects.direct.GetResources;
import org.seven.wonders.effects.direct.GetVPs;
import org.seven.wonders.tokens.Cost;
import org.seven.wonders.tokens.Token;

public class Winterfell extends Wonder {

  private static final Card[] SIDE_A = new Card[] {//
    new Stage(RemoveTokenIf.instantiate(Token.DEFEAT, Condition.CHAIN), new Cost(GLASS, TEXTILE)),
    new Stage(GetVPs.instantiate(7), new Cost(GLASS, TEXTILE, PAPYRUS)),
    new Stage(FreezeAction.instantiate(3), new Cost(STONE, CLAY, GLASS, TEXTILE, PAPYRUS)) };

  private static final Card[] SIDE_B = new Card[] {//
    new Stage(GetCoinsIf.instantiate(2, Condition.CHAIN), new Cost(WOOD, ORE)),
    new Stage(GetCardsForFree.instantiate(3, Color.GUILD), new Cost(GLASS, TEXTILE, PAPYRUS)),
    new Stage(DeferredVPs.instantiate(3, Condition.MY_GUILDS), new Cost(STONE, CLAY, WOOD, WOOD, ORE)) };

  public static final Winterfell WONDER = new Winterfell(SIDE_A, SIDE_B);

  private Winterfell(Card[] caraA, Card[] caraB) {
    super(caraA, caraB);
  }

  @Override
  public Effect invoke() {
    return GetResources.instantiate(STONE, CLAY);
  }

}
