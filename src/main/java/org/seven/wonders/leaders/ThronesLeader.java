package org.seven.wonders.leaders;

import static org.seven.wonders.effects.Condition.*;
import static org.seven.wonders.tokens.Resource.*;
import static org.seven.wonders.tokens.Token.*;

import org.seven.wonders.effects.Effect;
import org.seven.wonders.effects.When;
import org.seven.wonders.effects.action.DuplicateCard;
import org.seven.wonders.effects.cond.WhenReceive;
import org.seven.wonders.effects.deferred.CopyCardEnd;
import org.seven.wonders.effects.direct.ChangeWonder;
import org.seven.wonders.effects.direct.GetCoins;
import org.seven.wonders.effects.direct.GetResources;
import org.seven.wonders.effects.direct.GetScience;
import org.seven.wonders.effects.direct.GetShields;
import org.seven.wonders.effects.direct.GetTokens;
import org.seven.wonders.effects.direct.GetVPs;
import org.seven.wonders.effects.direct.PushDebt;
import org.seven.wonders.effects.hability.CanBuildCheaper;
import org.seven.wonders.effects.hability.CanBuyCheaper;
import org.seven.wonders.effects.hability.CanDuplicateCard;
import org.seven.wonders.effects.hability.CanPlayLastCard;
import org.seven.wonders.effects.hability.CanSellExpensive;
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

  public static final Leader BRANDON_STARK = new Leader(CanDuplicateCard.GREY, 1);

  public static final Leader HODOR = new Leader(CanDuplicateCard.INSTANCE, 2);

  public static final Leader CRASTER = new Leader(CanSellExpensive.RAW_RESOURCES_PLUS_1, 1);

  public static final Leader GILLY = new Leader(CanPlayLastCard.INSTANCE, 5);

  public static final Leader JANOS_SLYNT = new Leader(CanDuplicateCard.BROWN, 1);

  public static final Leader MAESTER_LUWIN = new Leader(GetScience.instantiate(Science.GEAR), 4);

  public static final Leader QYBURN = new Leader(GetScience.instantiate(Science.COMPASS), 4);

  public static final Leader SAMWELL_TARLEY = new Leader(GetScience.instantiate(Science.TABLET), 4);

  public static final Leader TYENE_SAND = new Leader(GetScience.instantiate(Science.GEAR), 4);

  public static final Leader NYMERIA_SAND = new Leader(GetScience.instantiate(Science.COMPASS), 4);

  public static final Leader OBARA_SAND = new Leader(GetScience.instantiate(Science.TABLET), 4);

  public static final Leader MISSANDEI = new Leader(CanSellExpensive.MANUFACTURED_PLUS_1, 1);

  public static final Leader TORMUND_GIANTSBANE = new Leader(GetVPs.instantiate(9), 3);

  public static final Leader SALLADHOR_SAAN = new Leader(GetResources.instantiate(GLASS, PAPYRUS, TEXTILE), 5);

  public static final Leader DAVOS_SEAWORTH = new Leader(GetResources.instantiate(CLAY, ORE, WOOD, STONE), 6);

  public static final Leader LITTLEFINGER = new Leader(GetCoins.instantiate(9), 1);

  public static final Leader THE_MOUNTAIN = new Leader(GetTokens.instantiate(VICTORY_2, VICTORY_2), 3);

  public static final Leader JAIME_LANNISTER = new Leader(GetShields.instantiate(3), 4);

  public static final Leader ROBB_STARK = new Leader(GetShields.instantiate(4), 5);

  public static final Leader LORAS_TYREL = new Leader(ForMeAndSides.instantiate(Token.VICTORY_3, Token.VICTORY_1), 2);

  public static final Leader ARYA_STARK = new Leader(CopyCardEnd.GREEN, 3);

  public static final Leader PYAT_PREE = new Leader(DuplicateCard.ANY, 4);

  public static final Leader AERON_GREYJOY = new Leader(PushDebt.instantiate(3), 2);

  public static final Leader EURON_GERYJOY = new Leader(PushDebt.instantiate(5), 4);

  public static final Leader TRYSTANE_MARTELL = new Leader(DuplicateCard.YELLOW, 3);

  static {
    setNames(ThronesLeader.class.getDeclaredFields());
  }

  public ThronesLeader(Effect efecto, int monedas) {
    super(efecto, monedas);
  }

}
