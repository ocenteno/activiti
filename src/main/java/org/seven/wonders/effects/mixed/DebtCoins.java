package org.seven.wonders.effects.mixed;

import org.seven.wonders.effects.DirectEffect;
import org.seven.wonders.effects.DoubleEffect;
import org.seven.wonders.effects.direct.GetCoins;
import org.seven.wonders.effects.direct.PushDebt;

public class DebtCoins extends DoubleEffect {

  private DebtCoins(DirectEffect effectA, DirectEffect effectB) {
    super(effectA, effectB);
  }

  public static DebtCoins instantiate(int debt, int vps) {
    DirectEffect effectA = PushDebt.instantiate(debt);
    DirectEffect effectB = GetCoins.instantiate(vps);
    return new DebtCoins(effectA, effectB);
  }

}
