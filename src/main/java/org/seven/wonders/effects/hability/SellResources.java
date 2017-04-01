package org.seven.wonders.effects.hability;

import static org.seven.wonders.effects.CommerceEffect.SubType.*;

import org.seven.wonders.effects.CommerceEffect;
import org.seven.wonders.effects.Condition;
import org.seven.wonders.wonders.Wonder;

public class SellResources extends CommerceEffect {

  public static final SellResources RAW_RIGHT_PLUS_1 = new SellResources(COST, Condition.RAW_RESOURCES_RIGHT, 1);

  public static final SellResources RAW_LEFT_PLUS_1 = new SellResources(COST, Condition.RAW_RESOURCES_LEFT, 1);

  public static final SellResources MANUFACTURED_PLUS_1 = new SellResources(COST,
      Condition.MANUFACTURED_RESOURCES, 1);

  public static final SellResources RAW_RESOURCES_PLUS_1 = new SellResources(COST, Condition.RAW_RESOURCES, 1);

  public static final SellResources PAY_RIGHT_1_MORE = new SellResources(DISCOUNT, Condition.RESOURCES_RIGHT, -1);

  public static final SellResources PAY_LEFT_1_MORE = new SellResources(DISCOUNT, Condition.RESOURCES_LEFT, -1);

  private SellResources(SubType subType, Condition condition, Object value) {
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
