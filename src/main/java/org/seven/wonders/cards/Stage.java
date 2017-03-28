package org.seven.wonders.cards;

import org.seven.wonders.effects.Effect;
import org.seven.wonders.tokens.Cost;

public class Stage extends Card {

  public Stage(Effect effect, Cost cost) {
    super(Color.WONDER, effect, cost);
  }

  public Stage(Effect effect, Color color) {
    super(color, effect, Cost.CARD);
  }

}
