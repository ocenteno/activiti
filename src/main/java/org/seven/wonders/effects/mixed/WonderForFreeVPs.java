package org.seven.wonders.effects.mixed;

import org.seven.wonders.effects.DirectEffect;
import org.seven.wonders.effects.DoubleEffect;
import org.seven.wonders.effects.direct.GetVPs;
import org.seven.wonders.effects.hability.WonderForFree;

public class WonderForFreeVPs extends DoubleEffect {

  private WonderForFreeVPs(DirectEffect effectA, DirectEffect effectB) {
    super(effectA, effectB);
  }

  public static WonderForFreeVPs instantiate(int vps) {
    DirectEffect effectA = GetVPs.instantiate(vps);
    DirectEffect effectB = WonderForFree.INSTANCE;
    return new WonderForFreeVPs(effectA, effectB);
  }

}
