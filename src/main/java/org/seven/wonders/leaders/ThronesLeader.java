package org.seven.wonders.leaders;

import static org.seven.wonders.effects.Condition.*;
import static org.seven.wonders.tokens.Resource.*;
import static org.seven.wonders.tokens.Token.*;

import org.seven.wonders.effects.Effect;
import org.seven.wonders.effects.When;
import org.seven.wonders.effects.action.DuplicateCard;
import org.seven.wonders.effects.cond.WhenReceive;
import org.seven.wonders.effects.deferred.CopyCardEnd;
import org.seven.wonders.effects.deferred.DeferredVPs;
import org.seven.wonders.effects.direct.ChangeWonder;
import org.seven.wonders.effects.direct.GetCoins;
import org.seven.wonders.effects.direct.GetResources;
import org.seven.wonders.effects.direct.GetScience;
import org.seven.wonders.effects.direct.GetShields;
import org.seven.wonders.effects.direct.GetTokens;
import org.seven.wonders.effects.direct.GetVPs;
import org.seven.wonders.effects.direct.PushDebt;
import org.seven.wonders.effects.direct.SellCards;
import org.seven.wonders.effects.hability.CanBuildCheaper;
import org.seven.wonders.effects.hability.CanBuyCheaper;
import org.seven.wonders.effects.hability.CanHaveCardTwice;
import org.seven.wonders.effects.hability.CanPlayLastCard;
import org.seven.wonders.effects.hability.SellResources;
import org.seven.wonders.effects.mixed.ForMeAndSides;
import org.seven.wonders.tokens.Science;
import org.seven.wonders.tokens.Token;

public class ThronesLeader extends Leader {

  public static final Leader KRAZNYS_MO_NAKLOZ = new Leader(ChangeWonder.INSTANCE, 7);

  public static final Leader RATTLESHIRT = new Leader(WhenReceive.instantiate(When.RECEIVE_VICTORY, VICTORY), 6);

  public static final Leader XARO_XHOAN_DAXOS = new Leader(CanBuyCheaper.PAY_RAW_1_LESS, 1);

  public static final Leader MAG_THE_MIGHTY = new Leader(GetVPs.instantiate(15), 9);

  public static final Leader BENJEN_STARK = new Leader(GetTokens.instantiate(DIPLOMACY, DIPLOMACY, DIPLOMACY), 3);

  public static final Leader JOJEN_REED = new Leader(CanBuildCheaper.instantiate(1, MANUFACTURED_RESOURCES, Color.ANY),
      5);

  public static final Leader MEERA_REED = new Leader(CanBuildCheaper.instantiate(1, RAW_RESOURCES, Color.ANY), 4);

  public static final Leader BRANDON_STARK = new Leader(CanHaveCardTwice.GREY, 1);

  public static final Leader HODOR = new Leader(CanHaveCardTwice.INSTANCE, 2);

  public static final Leader CRASTER = new Leader(SellResources.RAW_RESOURCES_PLUS_1, 1);

  public static final Leader GILLY = new Leader(CanPlayLastCard.INSTANCE, 5);

  public static final Leader JANOS_SLYNT = new Leader(CanHaveCardTwice.BROWN, 1);

  public static final Leader MAESTER_LUWIN = new Leader(GetScience.instantiate(Science.GEAR), 4);

  public static final Leader QYBURN = new Leader(GetScience.instantiate(Science.COMPASS), 4);

  public static final Leader SAMWELL_TARLY = new Leader(GetScience.instantiate(Science.TABLET), 4);

  public static final Leader TYENE_SAND = new Leader(GetScience.instantiate(Science.GEAR), 4);

  public static final Leader NYMERIA_SAND = new Leader(GetScience.instantiate(Science.COMPASS), 4);

  public static final Leader OBARA_SAND = new Leader(GetScience.instantiate(Science.TABLET), 4);

  public static final Leader MISSANDEI = new Leader(SellResources.MANUFACTURED_PLUS_1, 1);

  public static final Leader TORMUND_GIANTSBANE = new Leader(GetVPs.instantiate(9), 3);

  public static final Leader SALLADHOR_SAAN = new Leader(GetResources.instantiate(GLASS, PAPYRUS, TEXTILE), 5);

  public static final Leader DAVOS_SEAWORTH = new Leader(GetResources.instantiate(CLAY, ORE, WOOD, STONE), 6);

  public static final Leader LITTLEFINGER = new Leader(GetCoins.instantiate(9), 1);

  public static final Leader THE_MOUNTAIN = new Leader(GetTokens.instantiate(VICTORY_2, VICTORY_2), 3);

  public static final Leader JAIME_LANNISTER = new Leader(GetShields.instantiate(3), 4);

  public static final Leader ROBB_STARK = new Leader(GetShields.instantiate(4), 5);

  public static final Leader LORAS_TYRELL = new Leader(ForMeAndSides.instantiate(Token.VICTORY_3, Token.VICTORY_1), 2);

  public static final Leader ARYA_STARK = new Leader(CopyCardEnd.GREEN, 3);

  public static final Leader PYAT_PREE = new Leader(DuplicateCard.ANY, 4);

  public static final Leader AERON_GREYJOY = new Leader(PushDebt.instantiate(3), 2);

  public static final Leader EURON_GERYJOY = new Leader(PushDebt.instantiate(5), 4);

  public static final Leader TRYSTANE_MARTELL = new Leader(DuplicateCard.YELLOW, 3);

  public static final Leader THEON_GREYJOY = new Leader(SellCards.BLACK_6, 4);

  public static final Leader ASHA_GREYJOY = new Leader(SellCards.GREEN_6, 5);

  public static final Leader BALON_GREYJOY = new Leader(SellCards.BROWN_6, 4);

  public static final Leader KHAL_DROGO = new Leader(SellCards.GREY_6, 4);

  public static final Leader DOLOROUS_EDD = new Leader(SellCards.YELLOW_6, 3);

  public static final Leader QHORIN_HALFHAND = new Leader(SellCards.BLUE_6, 4);

  public static final Leader RAMSAY_SNOW = new Leader(GetTokens.instantiate(Token.AGGRESSION, Token.SHIELD,
      Token.HALF_SHIELD), 3);

  public static final Leader BRYNDEN_TULLY = new Leader(DeferredVPs.instantiate(2, MY_BLACKS), 3);

  public static final Leader OBERYN_MARTELL = new Leader(DeferredVPs.instantiate(2, MY_REDS), 3);

  public static final Leader JEOR_MORMONT = new Leader(DeferredVPs.instantiate(2, MY_BROWNS), 3);

  public static final Leader SANSA_STARK = new Leader(DeferredVPs.instantiate(2, MY_BLUES), 3);

  public static final Leader MARGAERY_TYRELL = new Leader(DeferredVPs.instantiate(2, MY_GREENS), 3);

  public static final Leader BARRISTAN_SELMY = new Leader(DeferredVPs.instantiate(3, MY_LEADERS), 1);

  public static final Leader MYRCELLA_BARATHEON = new Leader(DeferredVPs.instantiate(2, MY_YELLOWS), 3);

  public static final Leader GREY_WORM = new Leader(DeferredVPs.instantiate(2, ALL_GREYS), 2);

  public static final Leader GRENN = new Leader(DeferredVPs.instantiate(2, ALL_LEADERS), 5);

  public static final Leader TYRION_LANNISTER = new Leader(DeferredVPs.instantiate(2, MY_GUILDS), 3);

  public static final Leader WALDER_FREY = new Leader(DeferredVPs.instantiate(2, MY_ANY_COLOR), 3);

  public static final Leader VISTERYS_TARGARYEN = new Leader(DeferredVPs.instantiate(2, MY_COINS), 3);

  public static final Leader BRIENNE_OF_TARTH = new Leader(DeferredVPs.instantiate(1, MY_SHIELDS), 4);

  public static final Leader GRENDRY = new Leader(DeferredVPs.instantiate(1, MY_RESOURCES), 3);

  public static final Leader AREO_HOTAH = new Leader(DeferredVPs.instantiate(4, MY_YELLOW_REDS), 6);

  public static final Leader OSHA = new Leader(DeferredVPs.instantiate(4, MY_BROWN_GREYS), 4);

  public static final Leader ROBERT_BARATHEON = new Leader(DeferredVPs.instantiate(4, MY_BLACK_LEADERS), 5);

  public static final Leader STANNIS_BARATHEON = new Leader(DeferredVPs.instantiate(7, MY_RAW_RESOURCES), 5);

  // public static final Leader RENLY_BARATHEON = new Leader(DeferredVPs.instantiate(1, MY_DIRECT_VPS), 4);
  //
  // public static final Leader SHIREEN_BARATHEON = new Leader(DeferredVPs.instantiate(4, MY_PAIR_OF_MANUFACTURED), 4);
  //
  // public static final Leader HOT_PIE = new Leader(DeferredVPs.instantiate(4, MY_TRPPLET_OF_RAW), 4);

  public static final Leader RYCKON_STARK = new Leader(DeferredVPs.instantiate(10, MY_7_RESOURCES), 4);

  static {
    setNames(ThronesLeader.class.getDeclaredFields());
  }

  public ThronesLeader(Effect efecto, int monedas) {
    super(efecto, monedas);
  }

}
