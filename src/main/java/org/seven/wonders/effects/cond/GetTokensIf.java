package org.seven.wonders.effects.cond;

import org.seven.wonders.effects.Condition;
import org.seven.wonders.effects.ConditionedEffect;
import org.seven.wonders.tokens.Token;
import org.seven.wonders.wonders.Wonder;

public class GetTokensIf extends ConditionedEffect {

  private GetTokensIf(Token value, Condition condition) {
    super(value, condition);
  }

  public static GetTokensIf instantiate(Token value, Condition condition) {
    return new GetTokensIf(value, condition);
  }

  @Override
  public void apply(Wonder... others) {
    for (Wonder wonder : others) {
      wonder.addToken((Token)getValue());
    }
  }

}
