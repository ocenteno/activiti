package org.seven.wonders.effects;

import static org.seven.wonders.cards.Card.Color.*;
import static org.seven.wonders.effects.Condition.Scope.*;

import java.io.Serializable;

import lombok.Data;

import org.seven.wonders.cards.Card;
import org.seven.wonders.cards.Card.Color;
import org.seven.wonders.tokens.Resource;
import org.seven.wonders.tokens.Token;

@Data
public class Condition implements Serializable {

  public static final Condition ALL_BROWNS = new Condition(BROWN, Type.COLOR, THREE);

  public static final Condition ALL_GREYS = new Condition(GREY, Type.COLOR, THREE);

  public static final Condition ALL_LEADERS = new Condition(LEADER, Type.COLOR, THREE);

  public static final Condition ALL_WONDERS = new Condition(WONDER, Type.WONDER, THREE);

  public static final Condition OTHER_WONDERS = new Condition(WONDER, Type.WONDER, OTHERS);

  public static final Condition MY_WONDER = new Condition(WONDER, Type.WONDER, ME);

  public static final Condition MY_LEADERS = new Condition(LEADER, Type.COLOR, ME);

  public static final Condition MY_GUILDS = new Condition(GUILD, Type.COLOR, ME);

  public static final Condition MY_YELLOWS = new Condition(YELLOW, Type.COLOR, ME);

  public static final Condition MY_GREENS = new Condition(GREEN, Type.COLOR, ME);

  public static final Condition MY_BLUES = new Condition(BLUE, Type.COLOR, ME);

  public static final Condition MY_REDS = new Condition(RED, Type.COLOR, ME);

  public static final Condition MY_BLACKS = new Condition(BLACK, Type.COLOR, ME);

  public static final Condition MY_BROWNS = new Condition(BROWN, Type.COLOR, ME);

  public static final Condition MY_GREYS = new Condition(GREY, Type.COLOR, ME);

  public static final Condition MY_ANY_COLOR = new Condition(ANY, Type.COLOR, ME);

  public static final Condition MY_GREY_BROWN_GUILD = new Condition(new Color[] { BROWN, GREY, GUILD }, Type.COLOR, ME);

  public static final Condition MY_YELLOW_REDS = new Condition(new Color[] { YELLOW, RED }, Type.COLOR, ME);

  public static final Condition MY_BROWN_GREYS = new Condition(new Color[] { BROWN, GREY }, Type.COLOR, ME);

  public static final Condition MY_BLACK_LEADERS = new Condition(new Color[] { BLACK, LEADER }, Type.COLOR, ME);

  public static final Condition MY_COINS = new Condition(3, Type.COINS, ME);

  public static final Condition MY_SHIELDS = new Condition(Token.Type.SHIELD, Type.TOKEN, ME);

  public static final Condition MY_RESOURCES = new Condition(Resource.ANY, Type.RESOURCES, ME);

  public static final Condition MY_7_RESOURCES = new Condition(Resource.ALL, Type.RESOURCES, ME);

  public static final Condition MY_RAW_RESOURCES = new Condition(new Resource[] { Resource.CLAY, Resource.STONE,
      Resource.ORE, Resource.WOOD }, Type.RESOURCES, ME);

  public static final Condition MY_MANUFACTURED_RESOURCES = new Condition(new Resource[] { Resource.GLASS,
      Resource.PAPYRUS, Resource.TEXTILE }, Type.RESOURCES, ME);

  public static final Condition SIDE_BLACKS = new Condition(BLACK, Type.COLOR, SIDES);

  public static final Condition SIDE_BLUES = new Condition(BLUE, Type.COLOR, SIDES);

  public static final Condition SIDE_BROWNS = new Condition(BROWN, Type.COLOR, SIDES);

  public static final Condition SIDE_GREENS = new Condition(GREEN, Type.COLOR, SIDES);

  public static final Condition SIDE_GREYS = new Condition(GREY, Type.COLOR, SIDES);

  public static final Condition SIDE_GUILDS = new Condition(GUILD, Type.COLOR, SIDES);

  public static final Condition SIDE_LEADERS = new Condition(LEADER, Type.COLOR, SIDES);

  public static final Condition SIDE_REDS = new Condition(RED, Type.COLOR, SIDES);

  public static final Condition SIDE_YELLOWS = new Condition(YELLOW, Type.COLOR, SIDES);

  public static final Condition RAW_RESOURCES_LEFT = new Condition(BROWN, Type.NEIGHBOUR, LEFT);

  public static final Condition RAW_RESOURCES_RIGHT = new Condition(BROWN, Type.NEIGHBOUR, RIGHT);

  public static final Condition MANUFACTURED_RESOURCES = new Condition(GREY, Type.NEIGHBOUR, SIDES);

  public static final Condition RAW_RESOURCES = new Condition(BROWN, Type.NEIGHBOUR, SIDES);

  public static final Condition RESOURCES_LEFT = new Condition(new Color[] { BROWN, GREY }, Type.NEIGHBOUR, LEFT);

  public static final Condition RESOURCES_RIGHT = new Condition(new Color[] { BROWN, GREY }, Type.NEIGHBOUR, RIGHT);

  public static final Condition RESOURCES_BANK = new Condition(new Color[] { BROWN, GREY }, Type.NEIGHBOUR, BANK);

  public static final Condition RESOURCES_ANY = new Condition(new Color[] { BROWN, GREY }, Type.NEIGHBOUR, OTHERS);

  public static final Condition PAY_LEFT = new Condition(Type.COINS, Type.PAY, LEFT);

  public static final Condition PAY_RIGHT = new Condition(Type.COINS, Type.PAY, RIGHT);

  public static final Condition PAY_BANK = new Condition(Type.COINS, Type.PAY, BANK);

  public static final Condition MY_VICTORIES = new Condition(Token.Type.VICTORY, Type.TOKEN, ME);

  public static final Condition ALL_VICTORIES = new Condition(Token.Type.VICTORY, Type.TOKEN, OTHERS);

  public static final Condition SIDE_VICTORIES = new Condition(Token.Type.VICTORY, Type.TOKEN, SIDES);

  public static final Condition SIDE_DEFEATS = new Condition(Token.Type.DEFEAT, Type.TOKEN, SIDES);

  public static final Condition CHAIN = new Condition(Card.class, Type.CHAIN, ME);

  public static final Condition ALL_PLAYERS = new Condition(OTHERS, Type.COINS, OTHERS);

  public static Condition when(Object when) {
    return new Condition(when, Type.TOKEN, ME);
  }

  private final Object value;

  private final Type type;

  private final Scope scope;

  public static enum Type {
    COLOR,
    TOKEN,
    WONDER,
    COINS,
    NEIGHBOUR,
    PAY,
    CHAIN,
    RESOURCES
  }

  public static enum Scope {
    ME,
    SIDES,
    THREE,
    LEFT,
    RIGHT,
    BANK,
    OTHERS
  }

}
