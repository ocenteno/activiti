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

  public boolean allCardsUsed() {
    return this.hand.size() == 0;
  }

  public boolean isLastCard() {
    return this.hand.size() == 1;
  }

  public void giveCoins(int n) {
    this.wonder.getProduces().add(n);
  }

  public void add(Card card) {
    this.hand.add(card);
  }

  public Card playLeader() {
    this.leaders.remove(this.cardToPlay);
    return playCard();
  }

  public Card playCard() {
    Card result = null;
    switch (this.actionToPlay) {
      case BUILD:
        this.wonder.add(this.cardToPlay);
        break;
      case SELL:
        this.wonder.sell(this.cardToPlay);
        result = this.cardToPlay;
        break;
      case STAGE:
        this.wonder.evolve(this.wonderLevelToPlay, this.cardToPlay);
        break;
    }
    return result;
  }

  public boolean canPlayLast() {
    return false;
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
