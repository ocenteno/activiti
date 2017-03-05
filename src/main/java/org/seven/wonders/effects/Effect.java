package org.seven.wonders.effects;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import org.seven.wonders.cards.Card.Color;
import org.seven.wonders.game.Player;
import org.seven.wonders.tokens.Resource;
import org.seven.wonders.tokens.Science;
import org.seven.wonders.tokens.Token;
import org.seven.wonders.wonders.Wonder;

@Data
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class Effect implements Serializable {

  public static final Effect PLAY_LAST_CARD = new Effect(Type.PLAY_LAST_CARD, Type.PLAY_LAST_CARD);

  private final Type type;

  private final Object value;

  private Condition condition;

  public static Effect changeWonder(int number) {
    return new Effect(Type.WONDER, new Wonder[number]);
  }

  public static Effect debt(int value) {
    return new Effect(Type.DEBT, value);
  }

  public static Effect coins(int value) {
    return new Effect(Type.COINS, value);
  }

  public static Effect conditionedVPs(int value, Condition condicion) {
    Effect effect = new Effect(Type.COND_VP, value);
    effect.condition = condicion;
    return effect;
  }

  public static Effect conditionedCoins(int value, Condition condicion) {
    Effect effect = new Effect(Type.COND_COINS, value);
    effect.condition = condicion;
    return effect;
  }

  public static Effect victoryPoints(int value) {
    return new Effect(Type.VP, value);
  }

  public static Effect resources(Resource... value) {
    return new Effect(Type.RESOURCE, value);
  }

  public static Effect multipleResources(Resource... value) {
    return new Effect(Type.RESOURCE, value);
  }

  public static Effect oneOfManyResources(Resource... value) {
    return new Effect(Type.OR_RESOURCE, value);
  }

  public static Effect equalOrDifferentResources(Resource... resources) {
    if (resources[0] == resources[1]) {
      return resources(resources);
    }
    return oneOfManyResources(resources);
  }

  public static Effect science(Science value) {
    return new Effect(Type.RESOURCE, value);
  }

  public static Effect multipleScience(Science... value) {
    return new Effect(Type.SCIENCE, value);
  }

  public static Effect shields(int value) {
    return new Effect(Type.BATTLE, value);
  }

  public static Effect tokens(Token... tokens) {
    return new Effect(Type.TOKEN, tokens);
  }

  public static Effect copyCard(Color value) {
    return new Effect(Type.COPY, value);
  }

  public static Effect copyResource() {
    return new Effect(Type.COPY, Type.RESOURCE);
  }

  public static Effect peace(int number) {
    Token[] tokens = new Token[number];
    for (int i = 0; i < tokens.length; i++) {
      tokens[i] = Token.DIPLOMACY;
    }
    return new Effect(Type.TOKEN, tokens);
  }

  public static Effect canDuplicate(Color color) {
    return new Effect(Type.COND_COMMERCE, color);
  }

  public void apply(Player jugador) {
    jugador.getWonder().apply(this);
  }

  @Override
  public String toString() {
    return (this.condition != null ? this.condition.toString() : "") + this.type + " " + this.value;
  }

  public static enum Type {
    VP,
    COND_VP,
    OR_RESOURCE,
    RESOURCE,
    WONDER,
    COMMERCE,
    COND_COMMERCE,
    BATTLE,
    SCIENCE,
    COINS,
    COND_COINS,
    DEBT,
    COND_DEBT,
    COPY,
    DIPLOMACY,
    AGGRESSION,
    TOKEN,
    TOKEN_SIDES,
    COINS_SIDES,
    WHEN,
    PLAY_LAST_CARD;
  }

}
