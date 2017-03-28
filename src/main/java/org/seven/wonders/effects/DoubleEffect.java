package org.seven.wonders.effects;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import org.seven.wonders.wonders.Wonder;

@Data
@RequiredArgsConstructor
public class DoubleEffect implements Effect {

  private Type type = Type.DOUBLE;

  private boolean activated = false;

  private final Effect effectA;

  private final Effect effectB;

  @Override
  public void apply(Wonder... wonders) {
    if (this.effectA instanceof ConditionedEffect) {
      applyConditioned(wonders);
    } else {
      applyBoth(wonders);
    }
  }

  private void applyBoth(Wonder... wonders) {
    this.effectA.apply(wonders);
    this.effectB.apply(wonders);
  }

  private void applyConditioned(Wonder... wonders) {
    if (!this.activated) {
      this.effectA.apply(wonders);
    } else {
      this.effectB.apply(wonders);
    }
    this.activated = true;
  }

  @Override
  public Object getValue() {
    return null;
  }

  // private final Type type2;
  //
  // private final Object value2;

  // public static Effect debtCoins(int debt, int coins) {
  // return new DoubleEffect(Type.DEBT, debt, Type.COINS, coins);
  // }
  //
  // public static DoubleEffect debtVPs(int debt, int vps) {
  // return new DoubleEffect(Type.DEBT, debt, Type.VP, vps);
  // }
  //
  // public static DoubleEffect coinsVPs(int coins, int vps) {
  // return new DoubleEffect(Type.COINS, coins, Type.VP, vps);
  // }
  //
  // public static Effect coinsOthersVPs(int coins, int vps) {
  // DoubleEffect effect = new DoubleEffect(Type.COINS, coins, Type.VP, vps);
  // effect.setCondition(Condition.ALL_PLAYERS);
  // return effect;
  // }
  //
  // public static DoubleEffect peaceVPs(int vps) {
  // return new DoubleEffect(Type.DIPLOMACY, 1, Type.VP, vps);
  // }
  //
  // public static Effect freeWonderVPs(int vps) {
  // return new DoubleEffect(Type.WONDER, Resource.ALL, Type.VP, vps);
  // }
  //
  // public static DoubleEffect contidionedCoinsVPs(int coins, int vps, Condition condition) {
  // DoubleEffect effect = new DoubleEffect(Type.COND_COINS, coins, Type.COND_VP, vps);
  // effect.setCondition(condition);
  // return effect;
  // }
  //
  // public static Effect conditionedDebtVPs(int debt, int vps, Condition condition) {
  // DoubleEffect effect = new DoubleEffect(Type.COND_DEBT, debt, Type.VP, vps);
  // effect.setCondition(condition);
  // return effect;
  // }
  //
  // public static DoubleEffect tokensSides(Token yo, Token sides) {
  // return new DoubleEffect(Type.TOKEN, yo, Type.TOKEN_SIDES, sides);
  // }
  //
  // public static DoubleEffect coinsSides(int yo, int sides) {
  // return new DoubleEffect(Type.COINS, yo, Type.COINS_SIDES, sides);
  // }
  //
  // public DoubleEffect(Type type1, Object value1, Type type2, Object value2) {
  // super(type1, value1);
  // this.type2 = type2;
  // this.value2 = value2;
  // }

}
