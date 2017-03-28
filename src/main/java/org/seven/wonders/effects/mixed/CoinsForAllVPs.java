package org.seven.wonders.effects.mixed;

import org.seven.wonders.effects.DirectEffect;
import org.seven.wonders.effects.DoubleEffect;
import org.seven.wonders.effects.direct.GetCoins;
import org.seven.wonders.effects.direct.GetVPs;

public class CoinsForAllVPs extends DoubleEffect {

  private CoinsForAllVPs(DirectEffect effectA, DirectEffect effectB) {
    super(effectA, effectB);
  }

  public static CoinsForAllVPs instantiate(int vps, int coinsOthers) {
    DirectEffect effectA = GetVPs.instantiate(vps);
    DirectEffect effectB = GetCoins.instantiate(coinsOthers);
    return new CoinsForAllVPs(effectA, effectB);
  }

}
