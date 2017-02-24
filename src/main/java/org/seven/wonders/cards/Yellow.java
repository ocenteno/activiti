package org.seven.wonders.cards;

import static org.seven.wonders.effects.Condition.*;
import static org.seven.wonders.tokens.Resource.*;

import org.seven.wonders.effects.CommercialEffect;
import org.seven.wonders.effects.Condition;
import org.seven.wonders.effects.DoubleEffect;
import org.seven.wonders.effects.Effect;
import org.seven.wonders.tokens.Cost;
import org.seven.wonders.tokens.Resource;

public class Yellow extends Card {

  public static final Yellow TAVERN = new Yellow(Effect.coins(5));

  public static final Yellow EAST_TRADING_POST =
      new Yellow(CommercialEffect.fixPrice(Condition.RAW_RESOURCES_RIGHT, 1));

  public static final Yellow WEST_TRADING_POST = new Yellow(CommercialEffect.fixPrice(Condition.RAW_RESOURCES_LEFT, 1));

  public static final Yellow MARKETPLACE = new Yellow(CommercialEffect.fixPrice(Condition.MANUFACTURED_RESOURCES, 1));

  public static final Yellow FORUM = new Yellow(Effect.oneOfManyResources(TEXTILE, PAPYRUS, GLASS), EAST_TRADING_POST,
      CLAY, CLAY);

  public static final Yellow CARAVANSERY = new Yellow(Effect.oneOfManyResources(ORE, WOOD, CLAY, STONE), MARKETPLACE,
      WOOD, WOOD);

  public static final Yellow VINEYARD = new Yellow(Effect.conditionedCoins(1, ALL_BROWNS));

  public static final Yellow BAZAR = new Yellow(Effect.conditionedCoins(2, ALL_GREYS));

  public static final Yellow HAVEN = new Yellow(DoubleEffect.contidionedCoinsVPs(1, 1, MY_BROWNS), FORUM, TEXTILE, ORE,
      WOOD);

  public static final Yellow LIGHTHOUSE = new Yellow(DoubleEffect.contidionedCoinsVPs(1, 1, MY_YELLOWS), CARAVANSERY,
      GLASS, STONE);

  public static final Yellow CHAMBER_OF_COMMERCE = new Yellow(DoubleEffect.contidionedCoinsVPs(2, 2, MY_GREYS), CLAY,
      CLAY, PAPYRUS);

  public static final Yellow ARENA = new Yellow(DoubleEffect.contidionedCoinsVPs(3, 1, MY_WONDER), Green.DISPENSARY,
      ORE, STONE, STONE);

  static {
    setNames(Yellow.class.getDeclaredFields());
  }

  public Yellow(Effect efecto) {
    this(efecto, Cost.FREE);
  }

  public Yellow(Effect efecto, Card cadena, Resource... recursos) {
    this(efecto, recursos);
    if (cadena != null) {
      getCost().setChain(cadena);
    }
  }

  public Yellow(Effect efecto, Resource... recursos) {
    this(efecto, new Cost(recursos));
  }

  public Yellow(Effect efecto, Cost coste) {
    super(Color.YELLOW, efecto, coste);
  }

}
