package org.seven.wonders.tokens;

import java.io.Serializable;

import lombok.Data;

@Data
public class Token implements Serializable {

  public static final Token VICTORY_1 = new Token(1, Type.VICTORY);

  public static final Token VICTORY_2 = new Token(3, Type.VICTORY);

  public static final Token VICTORY_3 = new Token(5, Type.VICTORY);

  public static final Token DEFEAT = new Token(-1, Type.DEFEAT);

  public static final Token VICTORY = new Token(0, Type.VICTORY);

  public static final Token DIPLOMACY = new Token(0, Type.DIPLOMACY);

  public static final Token AGGRESSION = new Token(0, Type.AGGRESSION);

  public static final Token SHIELD = new Token(0, Type.SHIELD);

  public static final Token DEBT_1 = new Token(-1, Type.DEBT);

  public static final Token DEBT_2 = new Token(-2, Type.DEBT);

  public static final Token DEBT_3 = new Token(-3, Type.DEBT);

  public static final Token DEBT_5 = new Token(-5, Type.DEBT);

  private final int points;

  private final Type type;

  public static enum Type {
    VICTORY,
    DEFEAT,
    DEBT,
    DIPLOMACY,
    AGGRESSION,
    SHIELD
  }

}
