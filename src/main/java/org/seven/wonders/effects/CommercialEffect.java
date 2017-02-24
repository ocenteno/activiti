package org.seven.wonders.effects;

import lombok.Data;

@Data
public class CommercialEffect extends Effect {

  public static CommercialEffect fixPrice(Condition condicion, int valor) {
    return new CommercialEffect(condicion, valor);
  }

  public static CommercialEffect reducePrice(Condition condicion, int valor) {
    return new CommercialEffect(condicion, valor);
  }

  // public static EfectoComercio costeAmpliado(Carta.Color color, int valors) {
  // return new EfectoComercio(Tipo.TOKEN, yo, Tipo.TOKEN_LADOS, lados);
  // }

  public CommercialEffect(Condition condicion, Object valor) {
    super(Type.COMMERCE, valor);
    setCondition(condicion);
  }

}
