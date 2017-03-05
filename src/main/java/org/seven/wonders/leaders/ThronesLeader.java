package org.seven.wonders.leaders;

import static org.seven.wonders.effects.CommercialEffect.*;
import static org.seven.wonders.effects.Condition.*;
import static org.seven.wonders.tokens.Resource.*;

import org.seven.wonders.cards.Card;
import org.seven.wonders.effects.CommercialEffect;
import org.seven.wonders.effects.DoubleEffect;
import org.seven.wonders.effects.Effect;
import org.seven.wonders.effects.WhenEffect;
import org.seven.wonders.tokens.Science;
import org.seven.wonders.tokens.Token;

public class ThronesLeader extends Leader {

  public static final Leader KRAZNYS_MO_NAKLOZ = new Leader(Effect.changeWonder(3), 7);

  public static final Leader XARO_XHOAN_DAXOS = new Leader(reducePrice(RAW_RESOURCES, -1), 1);

  public static final Leader RATTLESHIRT = new Leader(WhenEffect.receive(Token.VICTORY, Token.VICTORY), 6);

  public static final Leader MAG_THE_MIGHTY = new Leader(Effect.victoryPoints(15), 9);

  public static final Leader BENJEN_STARK = new Leader(Effect.peace(3), 3);

  public static final Leader JOJEN_REED = new Leader(CommercialEffect.reducePrice(MANUFACTURED_RESOURCES, 1), 5);

  public static final Leader MEERA_REED = new Leader(CommercialEffect.reducePrice(RAW_RESOURCES, 1), 4);

  public static final Leader BRANDON_STARK = new Leader(Effect.canDuplicate(Card.Color.GREY), 1);

  public static final Leader HODOR = new Leader(Effect.canDuplicate(Card.Color.ANY), 2);

  public static final Leader CRASTER = new Leader(CommercialEffect.increasePrice(RAW_RESOURCES, 1), 1);

  public static final Leader GILLY = new Leader(Effect.PLAY_LAST_CARD, 5);

  public static final Leader JANOS_SLYNT = new Leader(Effect.canDuplicate(Card.Color.BROWN), 1);

  public static final Leader MAESTER_LUWIN = new Leader(Effect.science(Science.GEAR), 4);

  public static final Leader QYBURN = new Leader(Effect.science(Science.COMPASS), 4);

  public static final Leader SAMWELL_TARLEY = new Leader(Effect.science(Science.TABLET), 4);

  public static final Leader TYENE_SAND = new Leader(Effect.science(Science.GEAR), 4);

  public static final Leader NYMERIA_SAND = new Leader(Effect.science(Science.COMPASS), 4);

  public static final Leader OBARA_SAND = new Leader(Effect.science(Science.TABLET), 4);

  public static final Leader MISSANDEI = new Leader(CommercialEffect.increasePrice(MANUFACTURED_RESOURCES, 1), 1);

  public static final Leader TORMUND_GIANTSBANE = new Leader(Effect.victoryPoints(9), 3);

  public static final Leader SALLADHOR_SAAN = new Leader(Effect.resources(GLASS, PAPYRUS, TEXTILE), 5);

  public static final Leader DAVOS_SEAWORTH = new Leader(Effect.resources(CLAY, ORE, WOOD, STONE), 6);

  public static final Leader LITTLEFINGER = new Leader(Effect.coins(9), 1);

  public static final Leader THE_MOUNTAIN = new Leader(Effect.tokens(Token.VICTORY_2, Token.VICTORY_2), 3);

  public static final Leader JAIME_LANNISTER = new Leader(Effect.shields(3), 4);

  public static final Leader ROBB_STARK = new Leader(Effect.shields(4), 5);

  public static final Leader LORAS_TYREL = new Leader(DoubleEffect.tokensSides(Token.VICTORY_3, Token.VICTORY_1), 2);

  public static final Leader ARYA_STARK = new Leader(Effect.copyCard(Color.GREEN), 3);

  public static final Leader PYAT_PREE = new Leader(Effect.copyCard(Color.ANY), 4);

  public static final Leader AERON_GREYJOY = new Leader(Effect.debt(3), 2);

  public static final Leader EURON_GERYJOY = new Leader(Effect.debt(5), 4);

  public static final Leader TRYSTANE_MARTELL = new Leader(Effect.copyCard(Color.YELLOW), 3);

  static {
    setNames(ThronesLeader.class.getDeclaredFields());
  }

  public ThronesLeader(Effect efecto, int monedas) {
    super(efecto, monedas);
  }

}
