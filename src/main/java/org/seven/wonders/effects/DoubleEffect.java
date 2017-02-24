package org.seven.wonders.effects;

import lombok.Data;

import org.seven.wonders.tokens.Resource;
import org.seven.wonders.tokens.Token;

@Data
public class DoubleEffect extends Effect {

  private final Type type2;

  private final Object value2;

  private Condition condition2;

  public static DoubleEffect debtVPs(int deuda, int puntos) {
    return new DoubleEffect(Type.DEBT, deuda, Type.VP, puntos);
  }

  public static DoubleEffect coinsVPs(int monedas, int puntos) {
    return new DoubleEffect(Type.COINS, monedas, Type.VP, puntos);
  }

  public static DoubleEffect peaceVPs(int puntos) {
    return new DoubleEffect(Type.DIPLOMACY, 1, Type.VP, puntos);
  }

  public static Effect freeWonderVPs(int puntos) {
    return new DoubleEffect(Type.WONDER, Resource.ALL, Type.VP, puntos);
  }

  public static DoubleEffect contidionedCoinsVPs(int monedas, int puntos, Condition condicion) {
    DoubleEffect efecto = new DoubleEffect(Type.COND_COINS, monedas, Type.COND_VP, puntos);
    efecto.setCondition(condicion);
    return efecto;
  }

  public static Effect conditionedDebtVPs(int deuda, int puntos, Condition condicion) {
    DoubleEffect efecto = new DoubleEffect(Type.COND_DEBT, deuda, Type.VP, puntos);
    efecto.setCondition(condicion);
    return efecto;
  }

  public static DoubleEffect tokensSides(Token yo, Token lados) {
    return new DoubleEffect(Type.TOKEN, yo, Type.TOKEN_SIDES, lados);
  }

  public static DoubleEffect coinsSides(int yo, int lados) {
    return new DoubleEffect(Type.COINS, yo, Type.COINS_SIDES, lados);
  }

  public DoubleEffect(Type tipo1, Object valor1, Type tipo2, Object valor2) {
    super(tipo1, valor1);
    this.type2 = tipo2;
    this.value2 = valor2;
  }

}
