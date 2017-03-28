package org.seven.wonders.effects.cond;

import org.seven.wonders.effects.When;
import org.seven.wonders.effects.WhenEffect;
import org.seven.wonders.tokens.Token;
import org.seven.wonders.wonders.Wonder;

public class WhenReceive extends WhenEffect {

  private WhenReceive(When condition, Object value) {
    super(value, condition);
  }

  public static WhenReceive instantiate(When condition, Object value) {
    return new WhenReceive(condition, value);
  }

  @Override
  public void apply(Wonder... others) {
    for (Wonder wonder : others) {
      wonder.addToken((Token)getValue());
    }
  }

}
