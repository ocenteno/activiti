package org.seven.wonders.effects.mixed;

import org.seven.wonders.effects.Condition;
import org.seven.wonders.effects.ConditionedEffect;
import org.seven.wonders.effects.DeferredEffect;
import org.seven.wonders.effects.DoubleEffect;
import org.seven.wonders.effects.cond.GetCoinsIf;
import org.seven.wonders.effects.deferred.DeferredVPs;

public class CoinsVPsIf extends DoubleEffect {

  private CoinsVPsIf(ConditionedEffect direct, DeferredEffect deferred) {
    super(direct, deferred);
  }

  public static CoinsVPsIf instantiate(int coins, int vps, Condition condition) {
    ConditionedEffect direct = GetCoinsIf.instantiate(coins, condition);
    DeferredEffect deferred = DeferredVPs.instantiate(vps, condition);
    return new CoinsVPsIf(direct, deferred);
  }

}
