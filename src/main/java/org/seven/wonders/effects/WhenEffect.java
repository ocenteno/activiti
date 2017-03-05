package org.seven.wonders.effects;

public class WhenEffect extends Effect {

  public static final WhenEffect BUY_RIGHT_2 = new WhenEffect(Condition.RESOURCES_RIGHT, 2);

  public static final WhenEffect BUY_LEFT_2 = new WhenEffect(Condition.RESOURCES_LEFT, 2);

  public static WhenEffect receive(Object when, Object then) {
    return new WhenEffect(Condition.when(when), then);
  }

  public static WhenEffect reducePrice(Condition condicion, int valor) {
    return new WhenEffect(condicion, valor);
  }

  // public static EfectoComercio costeAmpliado(Carta.Color color, int valors) {
  // return new EfectoComercio(Tipo.TOKEN, yo, Tipo.TOKEN_LADOS, lados);
  // }

  public WhenEffect(Condition condicion, Object valor) {
    super(Type.WHEN, valor);
    setCondition(condicion);
  }

}
