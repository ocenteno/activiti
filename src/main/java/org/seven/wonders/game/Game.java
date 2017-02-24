package org.seven.wonders.game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

import org.seven.wonders.wonders.Wonder;
import org.seven.wonders.wonders.WondersFactory;

@Data(staticConstructor = "processParameters")
public class Game implements Serializable {

  private int i;

  private List<Player> players;

  private int current;

  private final boolean leaders;

  private final boolean cities;

  private final boolean babel;

  private final boolean proyectos;

  private final boolean thrones;

  private final boolean porEquipos;

  public boolean isLastCard() {
    return firstPlayer().getHand().size() == 1;
  }

  public void random(int numJugadores) {
    this.players = new ArrayList<Player>(numJugadores);
    if (this.thrones) {
      giveWonder(WondersFactory.randomThrones(numJugadores));
    } else {
      if (this.leaders) {
        if (this.cities) {
          giveWonder(WondersFactory.randomCities(numJugadores));
        } else {
          giveWonder(WondersFactory.randomLeaders(numJugadores));
        }
      } else {
        giveWonder(WondersFactory.randomBasic(numJugadores));
      }
    }
  }

  private void giveWonder(List<Wonder> maravillas) {
    if (maravillas != null) {
      for (Wonder wonder : maravillas) {
        this.players.add(new Player(wonder));
      }
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

}
