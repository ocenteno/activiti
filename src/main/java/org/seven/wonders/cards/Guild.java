package org.seven.wonders.cards;

import static org.seven.wonders.effects.Condition.*;
import static org.seven.wonders.tokens.Resource.*;
import static org.seven.wonders.tokens.Science.*;

import org.seven.wonders.effects.Condition;
import org.seven.wonders.effects.DoubleEffect;
import org.seven.wonders.effects.Effect;
import org.seven.wonders.tokens.Cost;
import org.seven.wonders.tokens.Resource;
import org.seven.wonders.tokens.Token;

public class Guild extends Card {

  public static final Guild WORKERS_GUILD = new Guild(SIDE_BROWNS, 1, ORE, ORE, CLAY, WOOD, STONE);

  public static final Guild CRAFTSMEN_GUILD = new Guild(SIDE_GREYS, 2, ORE, ORE, STONE, STONE);

  public static final Guild TRADERS_GUILD = new Guild(SIDE_YELLOWS, 1, TEXTILE, PAPYRUS, GLASS);

  public static final Guild PHILOSOPHERS_GUILD = new Guild(SIDE_GREENS, 1, CLAY, CLAY, CLAY, TEXTILE, PAPYRUS);

  public static final Guild SPIES_GUILD = new Guild(SIDE_REDS, 1, CLAY, CLAY, CLAY, GLASS);

  public static final Guild MAGISTRATES_GUILD = new Guild(SIDE_BLUES, 1, WOOD, WOOD, WOOD, STONE, TEXTILE);

  public static final Guild ARCHITECTS_GUILD = new Guild(SIDE_GUILDS, 3, ORE, ORE, ORE, CLAY, PAPYRUS, TEXTILE);

  public static final Guild GUILD_OF_SHADOWS = new Guild(SIDE_BLACKS, 1, STONE, STONE, WOOD, PAPYRUS);

  public static final Guild DIPLOMATS_GUILD = new Guild(SIDE_LEADERS, 1, STONE, WOOD, GLASS, PAPYRUS);

  public static final Guild STRATEGISTS_GUILD = new Guild(SIDE_DEFEATS, 1, ORE, ORE, STONE, TEXTILE);

  public static final Guild MOURNERS_GUILD = new Guild(SIDE_VICTORIES, 1, CLAY, CLAY, WOOD, GLASS, TEXTILE);

  public static final Guild BUILDERS_GUILD = new Guild(ALL_WONDERS, 1, CLAY, CLAY, STONE, STONE, GLASS);

  public static final Guild EMPERORS_GUILD = new Guild(MY_SHIELDS, 1, CLAY, CLAY, ORE, TEXTILE, GLASS);

  public static final Guild GAMERS_GUILD = new Guild(MY_COINS, 1, STONE, CLAY, ORE, WOOD);

  public static final Guild SCIENTISTS_GUILD = new Guild(Effect.multipleScience(COMPASS, TABLET, GEAR), ORE, ORE, WOOD,
      WOOD, PAPYRUS);

  public static final Guild MARAUDERS_GUILD = new Guild(DoubleEffect.tokensSides(Token.VICTORY_3, Token.DEFEAT), WOOD,
      WOOD, ORE, GLASS);

  public static final Guild COURTESANS_GUILD =
      new Guild(Effect.copyCard(Card.Color.LEADER), CLAY, WOOD, TEXTILE, GLASS);

  public static final Guild SHIPOWNERS_GUILD = new Guild(MY_GREY_BROWN_GUILD, 1, WOOD, WOOD, WOOD, GLASS, PAPYRUS);

  public static final Guild COUNTERFEITERS_GUILD = new Guild(DoubleEffect.debtVPs(3, 5), ORE, ORE, ORE, GLASS, TEXTILE);

  static {
    setNames(Guild.class.getDeclaredFields());
  }

  public Guild(Condition condicion, int valor, Resource... recursos) {
    super(Color.GUILD, Effect.conditionedVPs(valor, condicion), new Cost(recursos));
  }

  public Guild(Effect efecto, Resource... recursos) {
    super(Color.GUILD, efecto, new Cost(recursos));
  }

}
