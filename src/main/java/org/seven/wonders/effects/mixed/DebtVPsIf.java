package org.seven.wonders.effects.mixed;

import org.seven.wonders.effects.Condition;
import org.seven.wonders.effects.ConditionedEffect;
import org.seven.wonders.effects.DeferredEffect;
import org.seven.wonders.effects.DoubleEffect;
import org.seven.wonders.effects.cond.PushDebtIf;
import org.seven.wonders.effects.deferred.DeferredVPs;

public class DebtVPsIf extends DoubleEffect {

  private DebtVPsIf(ConditionedEffect effectA, DeferredEffect effectB) {
    super(effectA, effectB);
  }

  public static DebtVPsIf instantiate(int debt, int vps, Condition condition) {
    ConditionedEffect effectA = PushDebtIf.instantiate(debt, condition);
    DeferredEffect effectB = DeferredVPs.instantiate(vps, condition);
    return new DebtVPsIf(effectA, effectB);
  }

}
