package org.seven.wonders.effects.mixed;

import org.seven.wonders.effects.DirectEffect;
import org.seven.wonders.effects.DoubleEffect;
import org.seven.wonders.effects.direct.GetCoins;
import org.seven.wonders.effects.direct.GetTokens;
import org.seven.wonders.tokens.Token;

public class ForMeAndSides extends DoubleEffect {

  private ForMeAndSides(DirectEffect effectA, DirectEffect effectB) {
    super(effectA, effectB);
  }

  public static ForMeAndSides instantiate(int forMe, int forSides) {
    DirectEffect effectA = GetCoins.instantiate(forMe);
    DirectEffect effectB = GetCoins.instantiate(forSides);
    return new ForMeAndSides(effectA, effectB);
  }

  public static ForMeAndSides instantiate(Token forMe, Token forSides) {
    DirectEffect effectA = GetTokens.instantiate(forMe);
    DirectEffect effectB = GetTokens.instantiate(forSides);
    return new ForMeAndSides(effectA, effectB);
  }

}
