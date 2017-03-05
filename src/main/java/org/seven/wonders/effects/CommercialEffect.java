package org.seven.wonders.effects;

public class CommercialEffect extends Effect {

  public static final CommercialEffect BUY_RIGHT_2 = new CommercialEffect(Condition.RESOURCES_RIGHT, 2);

  public static final CommercialEffect BUY_LEFT_2 = new CommercialEffect(Condition.RESOURCES_LEFT, 2);

  public static CommercialEffect fixPrice(Condition condition, int value) {
    return new CommercialEffect(condition, value);
  }

  public static CommercialEffect reducePrice(Condition condition, int value) {
    return new CommercialEffect(condition, value);
  }

  public static CommercialEffect increasePrice(Condition condition, int value) {
    return new CommercialEffect(condition, value);
  }

  public CommercialEffect(Condition condition, Object value) {
    super(Type.COMMERCE, value);
    setCondition(condition);
  }

}
