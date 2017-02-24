package org.seven.wonders.leaders;

import lombok.Data;

import org.seven.wonders.cards.Card;
import org.seven.wonders.effects.Effect;
import org.seven.wonders.tokens.Cost;

@Data
public class Leader extends Card {

  public Leader(Effect efecto, int monedas) {
    super(Color.LEADER, efecto, new Cost(monedas));
  }

}
