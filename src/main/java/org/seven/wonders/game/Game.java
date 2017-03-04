package org.seven.wonders.game;

import static org.seven.wonders.tokens.Resource.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Data;

import org.seven.wonders.cards.Card;
import org.seven.wonders.effects.Condition.Scope;
import org.seven.wonders.leaders.Leader;
import org.seven.wonders.wonders.Wonder;
import org.seven.wonders.wonders.WondersFactory;

@Data(staticConstructor = "processParameters")
public class Game implements Serializable {

  private List<Player> players;

  private List<Card> discardedCards;

  private List<Leader> discardedLeaders;

  private int current;

  private final boolean leaders;

  private final boolean cities;

  private final boolean babel;

  private final boolean proyectos;

  private final boolean thrones;

  private final boolean porEquipos;

  private static Wonder CASH = new Wonder() {
  };

  public static Player BANK = new Player(CASH);

  static {
    for (int i = 0; i < 100; i++) {
      CASH.getProduces().add(ORE, CLAY, STONE, WOOD, TEXTILE, PAPYRUS, GLASS);
    }
  }

  public boolean isLastCard() {
    return firstPlayer().getHand().size() == 1;
  }

  public void random(int numPlayers) {
    initializeDiscardPiles(numPlayers);
    this.players = new ArrayList<Player>(numPlayers);
    if (this.thrones) {
      giveWonder(WondersFactory.randomThrones(numPlayers));
    } else {
      if (this.leaders) {
        if (this.cities) {
          giveWonder(WondersFactory.randomCities(numPlayers));
        } else {
          giveWonder(WondersFactory.randomLeaders(numPlayers));
        }
      } else {
        giveWonder(WondersFactory.randomBasic(numPlayers));
      }
    }
  }

  private void giveWonder(List<Wonder> wonders) {
    if (wonders != null) {
      for (Wonder wonder : wonders) {
        this.players.add(new Player(wonder));
      }
    }
  }

  public void discard(Card card) {
    if (card instanceof Leader) {
      getDiscardedLeaders().add((Leader)card);
    } else {
      getDiscardedCards().add(card);
    }
  }

  public int totalPlayers() {
    return this.players.size();
  }

  public Player firstPlayer() {
    return this.players.get(0);
  }

  public Player lastPlayer() {
    return this.players.get(this.players.size() - 1);
  }

  public Player currentPlayer() {
    return this.players.get(this.current);
  }

  public Player nextPlayer() {
    if (++this.current == totalPlayers()) {
      this.current = 0;
    }
    return this.players.get(this.current);
  }

  public Player previousPlayer() {
    if (this.current == 0) {
      this.current = totalPlayers();
    }
    return this.players.get(--this.current);
  }

  public Player leftOf(Player current) {
    this.current = this.players.indexOf(current);
    Player left = previousPlayer();
    nextPlayer(); // recover current
    return left;
  }

  public Player rightOf(Player current) {
    this.current = this.players.indexOf(current);
    Player right = nextPlayer();
    previousPlayer();
    return right;
  }

  public Map<Scope, List<Player>> getPlayersByScope(Player currentPlayer) {
    Map<Scope, List<Player>> result = new HashMap<Scope, List<Player>>();
    Player left = leftOf(currentPlayer);
    Player right = rightOf(currentPlayer);
    List<Player> otherPlayers = new ArrayList<>(this.players);
    otherPlayers.remove(currentPlayer);
    otherPlayers.remove(left);
    otherPlayers.remove(right);
    result.put(Scope.LEFT, Arrays.asList(left));
    result.put(Scope.RIGHT, Arrays.asList(right));
    result.put(Scope.BANK, Arrays.asList(BANK));
    result.put(Scope.OTHERS, otherPlayers);
    return result;
  }

  public void initializeDiscardPiles(int numPlayers) {
    this.discardedCards = new ArrayList<>(numPlayers * 5);
    this.discardedLeaders = new ArrayList<>(numPlayers * 2);
  }

}
