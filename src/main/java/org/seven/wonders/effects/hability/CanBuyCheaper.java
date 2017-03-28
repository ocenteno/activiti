package org.seven.wonders.effects.hability;

import static org.seven.wonders.effects.CommerceEffect.SubType.*;
import static org.seven.wonders.effects.Condition.*;

import org.seven.wonders.effects.CommerceEffect;
import org.seven.wonders.effects.Condition;
import org.seven.wonders.wonders.Wonder;

public class CanBuyCheaper extends CommerceEffect {

  public static final CanBuyCheaper BUY_RIGHT_2 = new CanBuyCheaper(COST, RESOURCES_RIGHT, 2);

  public static final CanBuyCheaper BUY_LEFT_2 = new CanBuyCheaper(COST, RESOURCES_LEFT, 2);

  public static final CanBuyCheaper RAW_RIGHT_1 = new CanBuyCheaper(COST, RAW_RESOURCES_RIGHT, 1);

  public static final CanBuyCheaper RAW_LEFT_1 = new CanBuyCheaper(COST, RAW_RESOURCES_LEFT, 1);

  public static final CanBuyCheaper MANUFACTURED_1 = new CanBuyCheaper(COST, MANUFACTURED_RESOURCES, 1);

  public static final CanBuyCheaper RAW_RESOURCES_1 = new CanBuyCheaper(COST, RAW_RESOURCES, 1);

  public static final CanBuyCheaper BUY_BANK_1 = new CanBuyCheaper(COST, RESOURCES_BANK, 1);

  public static final CanBuyCheaper BUY_ANY_1 = new CanBuyCheaper(COST, RESOURCES_ANY, 1);

  public static final CanBuyCheaper PAY_RIGHT_1_LESS = new CanBuyCheaper(DISCOUNT, RESOURCES_RIGHT, -1);

  public static final CanBuyCheaper PAY_LEFT_1_LESS = new CanBuyCheaper(DISCOUNT, RESOURCES_LEFT, -1);

  public static final CanBuyCheaper PAY_RAW_1_LESS = new CanBuyCheaper(DISCOUNT, RAW_RESOURCES, -1);

  public static final CanBuyCheaper PAY_MANUFACTURED_1_LESS = new CanBuyCheaper(DISCOUNT, MANUFACTURED_RESOURCES, -1);

  private CanBuyCheaper(SubType subType, Condition condition, Object value) {
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
