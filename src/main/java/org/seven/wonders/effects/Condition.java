package org.seven.wonders.effects;

import static org.seven.wonders.cards.Card.Color.*;

import java.io.Serializable;

import lombok.Data;

import org.seven.wonders.cards.Card.Color;
import org.seven.wonders.tokens.Token;

@Data
public class Condition implements Serializable {

  public static final Condition ALL_BROWNS = new Condition(BROWN, Type.COLOR, Scope.THREE);

  public static final Condition ALL_GREYS = new Condition(GREY, Type.COLOR, Scope.THREE);

  public static final Condition ALL_WONDERS = new Condition(WONDER, Type.WONDER, Scope.THREE);

  public static final Condition OTHER_WONDERS = new Condition(WONDER, Type.WONDER, Scope.OTHERS);

  public static final Condition MY_BLACK = new Condition(BLACK, Type.COLOR, Scope.ME);

  public static final Condition MY_BROWNS = new Condition(BROWN, Type.COLOR, Scope.ME);

  public static final Condition MY_COINS = new Condition(3, Type.COINS, Scope.ME);

  public static final Condition MY_GREY_BROWN_GUILD = new Condition(new Color[] { BROWN, GREY, GUILD }, Type.COLOR,
      Scope.ME);

  public static final Condition MY_GREYS = new Condition(GREY, Type.COLOR, Scope.ME);

  public static final Condition MY_SHIELDS = new Condition(Token.Type.SHIELD, Type.TOKEN, Scope.ME);

  public static final Condition MY_WONDER = new Condition(WONDER, Type.WONDER, Scope.ME);

  public static final Condition MY_YELLOWS = new Condition(YELLOW, Type.COLOR, Scope.ME);

  public static final Condition SIDE_BLACKS = new Condition(BLACK, Type.COLOR, Scope.SIDES);

  public static final Condition SIDE_BLUES = new Condition(BLUE, Type.COLOR, Scope.SIDES);

  public static final Condition SIDE_BROWNS = new Condition(BROWN, Type.COLOR, Scope.SIDES);

  public static final Condition SIDE_GREENS = new Condition(GREEN, Type.COLOR, Scope.SIDES);

  public static final Condition SIDE_GREYS = new Condition(GREY, Type.COLOR, Scope.SIDES);

  public static final Condition SIDE_GUILDS = new Condition(GUILD, Type.COLOR, Scope.SIDES);

  public static final Condition SIDE_LEADERS = new Condition(LEADER, Type.COLOR, Scope.SIDES);

  public static final Condition SIDE_REDS = new Condition(RED, Type.COLOR, Scope.SIDES);

  public static final Condition SIDE_YELLOWS = new Condition(YELLOW, Type.COLOR, Scope.SIDES);

  public static final Condition RAW_RESOURCES_LEFT = new Condition(BROWN, Type.NEIGHBOUR, Scope.LEFT);

  public static final Condition RAW_RESOURCES_RIGHT = new Condition(BROWN, Type.NEIGHBOUR, Scope.RIGHT);

  public static final Condition MANUFACTURED_RESOURCES = new Condition(GREY, Type.NEIGHBOUR, Scope.SIDES);

  public static final Condition PAY_LEFT = new Condition(Type.COINS, Type.PAY, Scope.LEFT);

  public static final Condition PAY_RIGHT = new Condition(Type.COINS, Type.PAY, Scope.RIGHT);

  public static final Condition PAY_BANK = new Condition(Type.COINS, Type.PAY, Scope.BANK);

  public static final Condition MY_VICTORIES = new Condition(Token.Type.VICTORY, Type.TOKEN, Scope.ME);

  public static final Condition ALL_VICTORIES = new Condition(Token.Type.VICTORY, Type.TOKEN, Scope.OTHERS);

  public static final Condition SIDE_VICTORIES = new Condition(Token.Type.VICTORY, Type.TOKEN, Scope.SIDES);

  public static final Condition SIDE_DEFEATS = new Condition(Token.Type.DEFEAT, Type.TOKEN, Scope.SIDES);

  private final Object value;

  private final Type type;

  private final Scope scope;

  public static enum Type {
    COLOR,
    TOKEN,
    WONDER,
    COINS,
    NEIGHBOUR,
    PAY
  }

  public static enum Scope {
    ME,
    SIDES,
    THREE,
    OTHERS,
    RIGHT,
    LEFT,
    BANK
  }

}
