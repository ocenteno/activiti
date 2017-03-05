package org.seven.wonders.game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

import org.seven.wonders.cards.Card;
import org.seven.wonders.leaders.Leader;
import org.seven.wonders.wonders.Wonder;

@Data
public class Player implements Serializable {

  private final Wonder wonder;

  private Card cardToPlay;

  private Action actionToPlay;

  private Card wonderLevelToPlay;

  private List<Card> hand = new ArrayList<>(8);

  private List<Leader> leaders = new ArrayList<>(4);

  public int getCoins() {
    return getWonder().getProduces().getCoins();
  }

  public void add(Card carta) {
    this.hand.add(carta);
  }

  @Override
  public String toString() {
    return this.wonder.toString();
  }

  public enum Action {
    BUILD,
    SELL,
    STAGE
  }

}
