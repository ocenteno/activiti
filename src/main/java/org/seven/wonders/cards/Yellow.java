package org.seven.wonders.cards;

import static org.seven.wonders.effects.Condition.*;
import static org.seven.wonders.tokens.Resource.*;

import org.seven.wonders.effects.Effect;
import org.seven.wonders.effects.cond.GetCoinsIf;
import org.seven.wonders.effects.direct.GetCoins;
import org.seven.wonders.effects.direct.GetResources;
import org.seven.wonders.effects.hability.CanBuyCheaper;
import org.seven.wonders.effects.mixed.CoinsVPsIf;
import org.seven.wonders.tokens.Cost;
import org.seven.wonders.tokens.Resource;

public class Yellow extends Card {

  public static final Yellow TAVERN = new Yellow(GetCoins.instantiate(5));

  public static final Yellow EAST_TRADING_POST = new Yellow(CanBuyCheaper.RAW_RIGHT_1);

  public static final Yellow WEST_TRADING_POST = new Yellow(CanBuyCheaper.RAW_LEFT_1);

  public static final Yellow MARKETPLACE = new Yellow(CanBuyCheaper.MANUFACTURED_1);

  public static final Yellow FORUM = new Yellow(GetResources.instantiate(TEXTILE, PAPYRUS, GLASS), //
      EAST_TRADING_POST, CLAY, CLAY);

  public static final Yellow CARAVANSERY = new Yellow(GetResources.instantiate(ORE, WOOD, CLAY, STONE), //
      MARKETPLACE, WOOD, WOOD);

  public static final Yellow VINEYARD = new Yellow(GetCoinsIf.instantiate(1, ALL_BROWNS));

  public static final Yellow BAZAR = new Yellow(GetCoinsIf.instantiate(2, ALL_GREYS));

  public static final Yellow HAVEN = new Yellow(CoinsVPsIf.instantiate(1, 1, MY_BROWNS), //
      FORUM, TEXTILE, ORE, WOOD);

  public static final Yellow LIGHTHOUSE = new Yellow(CoinsVPsIf.instantiate(1, 1, MY_YELLOWS), //
      CARAVANSERY, GLASS, STONE);

  public static final Yellow CHAMBER_OF_COMMERCE = new Yellow(CoinsVPsIf.instantiate(2, 2, MY_GREYS), //
      CLAY, CLAY, PAPYRUS);

  public static final Yellow ARENA = new Yellow(CoinsVPsIf.instantiate(3, 1, MY_WONDER), //
      Green.DISPENSARY, ORE, STONE, STONE);

  static {
    setNames(Yellow.class.getDeclaredFields());
  }

  public Yellow(Effect effect) {
    this(effect, Cost.FREE);
  }

  public Yellow(Effect effect, Card chain, Resource... resources) {
    this(effect, resources);
    if (chain != null) {
      getCost().setChain(chain);
    }
  }

  public Yellow(Effect effect, Resource... resources) {
    this(effect, new Cost(resources));
  }

  public Yellow(Effect effect, Cost cost) {
    super(Color.YELLOW, effect, cost);
  }

}
