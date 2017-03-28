package org.seven.wonders.effects.mixed;

import org.seven.wonders.effects.DirectEffect;
import org.seven.wonders.effects.DoubleEffect;
import org.seven.wonders.effects.direct.GetCoins;
import org.seven.wonders.effects.direct.GetVPs;

public class CoinsVPs extends DoubleEffect {

  private CoinsVPs(DirectEffect effectA, DirectEffect effectB) {
    super(effectA, effectB);
  }

  public static CoinsVPs instantiate(int coins, int vps) {
    DirectEffect effectA = GetCoins.instantiate(coins);
    DirectEffect effectB = GetVPs.instantiate(vps);
    return new CoinsVPs(effectA, effectB);
  }

}
