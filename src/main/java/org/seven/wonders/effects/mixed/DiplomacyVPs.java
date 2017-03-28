package org.seven.wonders.effects.mixed;

import org.seven.wonders.effects.DirectEffect;
import org.seven.wonders.effects.DoubleEffect;
import org.seven.wonders.effects.direct.GetTokens;
import org.seven.wonders.effects.direct.GetVPs;
import org.seven.wonders.tokens.Token;

public class DiplomacyVPs extends DoubleEffect {

  private DiplomacyVPs(DirectEffect effectA, DirectEffect effectB) {
    super(effectA, effectB);
  }

  public static DiplomacyVPs instantiate(int vps) {
    DirectEffect effectA = GetTokens.instantiate(Token.DIPLOMACY);
    DirectEffect effectB = GetVPs.instantiate(vps);
    return new DiplomacyVPs(effectA, effectB);
  }

}
