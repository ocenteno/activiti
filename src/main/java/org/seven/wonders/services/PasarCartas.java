package org.seven.wonders.services;

import java.util.List;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.Expression;
import org.activiti.engine.delegate.JavaDelegate;
import org.seven.wonders.cards.Card;
import org.seven.wonders.game.Game;

public class PasarCartas implements JavaDelegate {

  private Expression currentAge;

  @Override
  public void execute(DelegateExecution execution) throws Exception {
    int age = Integer.parseInt((String)this.currentAge.getValue(execution));
    Game game = (Game)execution.getVariable("game");
    if (age % 2 == 0) { // Leaders || Age II
      rotateRight(game);
    } else { // Age I || Age III
      rotateLeft(game);
    }
    execution.setVariable("game", game);
  }

  private void rotateLeft(Game game) {
    // Collection version
    List<Card> tmp = game.currentPlayer().getHand();
    for (int i = 0; i < game.totalPlayers() - 1; i++) {
      game.currentPlayer().setHand(game.nextPlayer().getHand());
    }
    game.currentPlayer().setHand(tmp);
    // Arrays version
    // List<Card> tmp = game.getPlayers()[0].getHand();
    // for (int i = 0; i < game.getPlayers().length - 1; i++) {
    // game.getPlayers()[i].setHand(game.getPlayers()[(i + 1) % game.getPlayers().length].getHand());
    // }
    // game.getPlayers()[game.getPlayers().length - 1].setHand(tmp);
  }

  private void rotateRight(Game game) {
    // Collection version
    List<Card> tmp = game.currentPlayer().getHand();
    for (int i = 0; i < game.totalPlayers() - 1; i++) {
      game.currentPlayer().setHand(game.previousPlayer().getHand());
    }
    game.currentPlayer().setHand(tmp);
    // Arrays version
    // List<Card> tmp = game.getPlayers()[0].getHand();
    // for (int i = game.getPlayers().length; i > 1; i--) {
    // game.getPlayers()[i % game.getPlayers().length].setHand(game.getPlayers()[i - 1].getHand());
    // }
    // game.getPlayers()[1].setHand(tmp);
  }

}
