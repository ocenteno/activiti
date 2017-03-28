package org.seven.wonders.effects.cond;

import org.seven.wonders.effects.Condition;
import org.seven.wonders.effects.ConditionedEffect;
import org.seven.wonders.tokens.Token;
import org.seven.wonders.wonders.Wonder;

public class RemoveTokenIf extends ConditionedEffect {

  private RemoveTokenIf(Token value, Condition condition) {
    super(value, condition);
  }

  public static RemoveTokenIf instantiate(Token value, Condition condition) {
    return new RemoveTokenIf(value, condition);
  }

  @Override
  public void apply(Wonder... others) {
    for (Wonder wonder : others) {
      wonder.removeToken((Token)getValue());
    }
  }

}
