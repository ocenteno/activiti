package org.seven.wonders.effects;

import static org.seven.wonders.effects.When.Type.*;

import java.io.Serializable;

import lombok.Data;

import org.seven.wonders.cards.Card;
import org.seven.wonders.cards.Card.Color;
import org.seven.wonders.cards.Stage;
import org.seven.wonders.effects.Condition.Scope;
import org.seven.wonders.tokens.Token;

@Data
public class When implements Serializable {

  public static final When BUY_BROWN = new When(BUY_CARD, Color.BROWN);

  public static final When BUY_GREY = new When(BUY_CARD, Color.GREY);

  public static final When BUY_BLUE = new When(BUY_CARD, Color.BLUE);

  public static final When BUY_BLACK = new When(BUY_CARD, Color.BLACK);

  public static final When BUY_RED = new When(BUY_CARD, Color.RED);

  public static final When BUY_YELLOW = new When(BUY_CARD, Color.YELLOW);

  public static final When BUY_GREEN = new When(BUY_CARD, Color.GREEN);

  public static final When BUY_LEADER = new When(BUY_CARD, Color.LEADER);

  public static final When BUY_GUILD = new When(BUY_CARD, Color.GUILD);

  public static final When BUY_STAGE = new When(EVOLVE_WONDER, Stage.class);

  public static final When GET_COINS = new When(RECEIVE_COINS, RECEIVE_COINS);

  public static final When GET_SHIELD = new When(RECEIVE_TOKEN, Token.Type.SHIELD);

  public static final When GET_DEFEAT = new When(RECEIVE_TOKEN, Token.Type.DEFEAT);

  public static final When GET_VICTORY = new When(RECEIVE_TOKEN, Token.Type.VICTORY);

  public static final When GET_DIPLOMACY = new When(RECEIVE_TOKEN, Token.Type.DIPLOMACY);

  public static final When GET_AGGRESSION = new When(RECEIVE_TOKEN, Token.Type.AGGRESSION);

  public static final When GET_DEBT = new When(RECEIVE_TOKEN, Token.Type.DEBT);

  public static final When PAY_LEFT = new When(PAY, Scope.LEFT);

  public static final When PAY_RIGHT = new When(PAY, Scope.RIGHT);

  public static final When CHAIN = new When(Type.CHAIN, Card.class);

  public static final When RECEIVE_VICTORY = new When(Type.RECEIVE_TOKEN, Token.VICTORY);

  public static final When RECEIVE_DEFEAT = new When(Type.RECEIVE_TOKEN, Token.DEFEAT);

  public static final When RECEIVE_DEBT = new When(Type.RECEIVE_TOKEN, Token.DEBT);

  private final Type type;

  private final Object what;

  public static enum Type {
    PAY,
    CHAIN,
    BUY_CARD,
    BEFORE_AGE,
    EVOLVE_WONDER,
    RECEIVE_TOKEN,
    RECEIVE_COINS
  }

}
