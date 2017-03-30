package org.seven.wonders.wonders;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.Getter;
import lombok.NoArgsConstructor;

import org.seven.wonders.cards.Card;
import org.seven.wonders.cards.Card.Color;
import org.seven.wonders.effects.Condition.Scope;
import org.seven.wonders.effects.Effect;
import org.seven.wonders.effects.HabilityEffect;
import org.seven.wonders.game.Habilities;
import org.seven.wonders.game.Price;
import org.seven.wonders.game.Production;
import org.seven.wonders.tokens.Resource;
import org.seven.wonders.tokens.Science;
import org.seven.wonders.tokens.Token;

@Getter
@NoArgsConstructor
public abstract class Wonder implements Serializable {

  private final static Comparator<Card> COMPARATOR = new Comparator<Card>() {
    @Override
    public int compare(Card c1, Card c2) {
      if (c1 == null) {
        return 1;
      }
      if (c2 == null) {
        return -1;
      }
      return -c1.getEffect().getType().compareTo(c2.getEffect().getType());
    }
  };

  private final static String A = " A";

  private final static String B = " B";

  private Card[] sideA;

  private Card[] sideB;

  private Card[] activeSide;

  private String sideName;

  private int levels;

  private final Card[] nextStages = new Card[0];

  private final Habilities habilities = new Habilities();

  private final Production produces = new Production();

  private final WonderTokens data = new WonderTokens();

  private final Map<Color, List<Card>> builtCards = new HashMap<>(9);

  protected Price price = new Price();

  public void setCaraActiva(boolean jugarA) {
    if (jugarA) {
      jugarCaraA();
    } else {
      jugarCaraB();
    }
    this.levels = this.activeSide.length;
  }

  public void jugarCaraA() {
    this.activeSide = this.sideA;
    this.sideName = A;
  }

  public void jugarCaraB() {
    this.activeSide = this.sideB;
    this.sideName = B;
  }

  public Wonder(Card[] sideA, Card[] sideB) {
    this.sideA = sideA;
    this.sideB = sideB;
    initializeCardSet();
    initializeCommerce();
  }

  private void initializeCommerce() {
    this.price.setBuy(Scope.LEFT, 2);
    this.price.setBuy(Scope.RIGHT, 2);
  }

  private void initializeCardSet() {
    this.builtCards.put(Color.BLUE, new ArrayList<Card>());
    this.builtCards.put(Color.RED, new ArrayList<Card>());
    this.builtCards.put(Color.GREEN, new ArrayList<Card>());
    this.builtCards.put(Color.YELLOW, new ArrayList<Card>());
    this.builtCards.put(Color.BROWN, new ArrayList<Card>());
    this.builtCards.put(Color.GREY, new ArrayList<Card>());
    this.builtCards.put(Color.BLACK, new ArrayList<Card>());
    this.builtCards.put(Color.GUILD, new ArrayList<Card>());
    this.builtCards.put(Color.LEADER, new ArrayList<Card>());
  }

  public Effect invoke() {
    return null;
  }

  public Comparator<Card> getComparator() {
    return COMPARATOR;
  }

  public void enable(Class<? extends HabilityEffect> clazz) {
    this.habilities.set(clazz);
  }

  public void add(Card cardToPlay) {
    this.builtCards.get(cardToPlay.getColor()).add(cardToPlay);
    apply(cardToPlay.getEffect());
  }

  public void addVPs(int value) {
    this.data.directVPs += value;
  }

  public void addCoins(int value) {
    this.produces.add(value);
  }

  public void addShields(int value) {
    this.data.shields += value;
  }

  public void addHalfShields(int value) {
    this.data.halfShields += value;
  }

  public void addResources(Resource... resources) {
    if (resources.length == 0) {
      throw new IllegalArgumentException("Must provide at least one resource");
    }
    if (resources.length == 1 || resources[0] == resources[1]) {
      this.produces.add(resources);
    }
    this.produces.addOr(resources);
  }

  public void addScience(Science... value) {
    if (value.length == 0) {
      throw new IllegalArgumentException("Must provide at least one science");
    }
    if (value.length == 1) {
      this.data.science.add(value[0]);
    }
    this.data.orScience.add(value);
  }

  public void addToken(Token... value) {
    if (value.length == 0) {
      throw new IllegalArgumentException("Must provide at least one token");
    }
    for (int i = 0; i < value.length; i++) {
      this.data.tokens.add(value[i]);
    }
  }

  public void removeToken(Token value) {
    this.data.tokens.remove(value);
  }

  public void evolve(Card wonderStage, Card cardToPlay) {
    this.builtCards.get(cardToPlay.getColor()).add(cardToPlay);
    apply(wonderStage.getEffect());
  }

  public void sell(Card cardToPlay) {
    this.produces.add(3);
  }

  public void debt(int value) {
    int debt = this.produces.pay(value);
    while (debt >= 5) {
      this.data.tokens.add(Token.DEBT_5);
      debt -= 5;
    }
    while (debt >= 3) {
      this.data.tokens.add(Token.DEBT_3);
      debt -= 3;
    }
    while (debt >= 2) {
      this.data.tokens.add(Token.DEBT_2);
      debt -= 2;
    }
    while (debt > 0) {
      this.data.tokens.add(Token.DEBT_1);
      debt--;
    }
  }

  public void apply(Effect effect) {
    switch (effect.getType()) {
      case ACTION:
        this.data.actions.add(effect);
        break;
      case WHEN:
        this.data.when.add(effect);
        break;
      case END_VPS:
        this.data.vps.add(effect);
        break;
      default:
        effect.apply(this);
        break;
    }
  }

  public boolean contains(Card card) {
    // if (effects.contains(Effect.duplicateCards())) {
    // return true;
    // }
    return this.builtCards.get(card.getColor()).contains(card);
  }

  public boolean canChain(Card card) {
    Card chain = card.getCost().getChain();
    return chain != null && contains(chain);
  }

  public List<Scope> getCommerceScope() {
    return new ArrayList<>(this.price.getInternalScopes());
  }

  public int getCostOf(Resource resource, Scope scope, int buy) {
    return buy * this.price.get(resource, scope);
  }

  public int getDiscount(Scope scope) {
    return this.price.getDiscount(scope);
  }

  @Override
  public String toString() {
    return this.getClass().getSimpleName() + this.sideName;
  }

  public Set<Scope> getAvailableScopes() {
    return this.price.getInternalScopes();
  }

  public List<Scope> getScopesByPriceForResource(final Resource resource) {
    List<Scope> result = new ArrayList<>(getAvailableScopes());
    Collections.sort(result, new Comparator<Scope>() {
      @Override
      public int compare(Scope s1, Scope s2) {
        return Integer.compare(Wonder.this.price.get(resource, s1), Wonder.this.price.get(resource, s2));
      }
    });
    return result;
  }

}
