package org.seven.wonders.effects.hability;

import static org.seven.wonders.effects.CommerceEffect.SubType.*;

import org.seven.wonders.effects.CommerceEffect;
import org.seven.wonders.effects.Condition;
import org.seven.wonders.wonders.Wonder;

public class CanSellExpensive extends CommerceEffect {

  public static final CanSellExpensive RAW_RIGHT_PLUS_1 = new CanSellExpensive(COST, Condition.RAW_RESOURCES_RIGHT, 1);

  public static final CanSellExpensive RAW_LEFT_PLUS_1 = new CanSellExpensive(COST, Condition.RAW_RESOURCES_LEFT, 1);

  public static final CanSellExpensive MANUFACTURED_PLUS_1 = new CanSellExpensive(COST,
      Condition.MANUFACTURED_RESOURCES, 1);

  public static final CanSellExpensive RAW_RESOURCES_PLUS_1 = new CanSellExpensive(COST, Condition.RAW_RESOURCES, 1);

  public static final CanSellExpensive PAY_RIGHT_1_MORE = new CanSellExpensive(DISCOUNT, Condition.RESOURCES_RIGHT, -1);

  public static final CanSellExpensive PAY_LEFT_1_MORE = new CanSellExpensive(DISCOUNT, Condition.RESOURCES_LEFT, -1);

  private CanSellExpensive(SubType subType, Condition condition, Object value) {
    super(subType, condition, value);
  }

  @Override
  public void apply(Wonder... wonders) {
    for (Wonder wonder : wonders) {
      switch (this.subType) {
        case COST:
          break;
        case DISCOUNT:
          break;
      }
    }
  }

}
