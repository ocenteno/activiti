package org.seven.wonders.tokens;

import java.io.Serializable;

import lombok.Data;

@Data
public class Token implements Serializable {

  public static final Token VICTORY_1 = new Token(1, Type.VICTORY);

  public static final Token VICTORY_2 = new Token(3, Type.VICTORY);

  public static final Token VICTORY_3 = new Token(5, Type.VICTORY);

  public static final Token DEFEAT = new Token(-1, Type.DEFEAT);

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
