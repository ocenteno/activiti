package org.seven.wonders.cards;

import java.io.Serializable;
import java.lang.reflect.Field;

import lombok.Data;

import org.seven.wonders.effects.Effect;
import org.seven.wonders.game.Player;
import org.seven.wonders.tokens.Cost;

@Data
public class Card implements Serializable {

  private final Color color;

  private final Effect effect;

  private final Cost cost;

  private String name;

  private boolean built;

  public void build(Player jugador) {
    this.effect.apply(jugador);
    this.built = true;
  }

  @Override
  public String toString() {
    return getName();
  }

  public static enum Color {
    WONDER,
    BROWN,
    GREY,
    BLUE,
    RED,
    YELLOW,
    GREEN,
    BLACK,
    GUILD,
    LEADER
  }

  protected static void setNames(Field[] declaredFields) {
    for (Field field : declaredFields) {
      try {
        Card card = (Card)field.get(null);
        card.setName(field.getName());
      } catch (IllegalArgumentException e) {
        e.printStackTrace();
      } catch (IllegalAccessException e) {
        e.printStackTrace();
      }
    }
  }

}
