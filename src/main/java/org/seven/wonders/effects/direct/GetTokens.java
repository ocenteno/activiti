package org.seven.wonders.effects.direct;

import org.seven.wonders.effects.ValueEffect;
import org.seven.wonders.tokens.Token;
import org.seven.wonders.wonders.Wonder;

public class GetTokens extends ValueEffect {

  private GetTokens(Token... value) {
    super(value);
  }

  public static GetTokens instantiate(Token... value) {
    return new GetTokens(value);
  }

  @Override
  public void apply(Wonder... others) {
    for (Wonder wonder : others) {
      wonder.addToken((Token[])getValue());
    }
  }

}
