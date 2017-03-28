package org.seven.wonders.effects.mixed;

import org.seven.wonders.effects.DirectEffect;
import org.seven.wonders.effects.DoubleEffect;
import org.seven.wonders.effects.direct.GetVPs;
import org.seven.wonders.effects.direct.PushDebt;

public class DebtVPs extends DoubleEffect {

  private DebtVPs(DirectEffect effectA, DirectEffect effectB) {
    super(effectA, effectB);
  }

  public static DebtVPs instantiate(int debt, int vps) {
    DirectEffect effectA = PushDebt.instantiate(debt);
    DirectEffect effectB = GetVPs.instantiate(vps);
    return new DebtVPs(effectA, effectB);
  }

}
