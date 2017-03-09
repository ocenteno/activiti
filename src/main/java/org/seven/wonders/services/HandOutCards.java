package org.seven.wonders.services;

import java.util.List;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.Expression;
import org.activiti.engine.delegate.JavaDelegate;
import org.seven.wonders.cards.Card;
import org.seven.wonders.game.Game;

public class HandOutCards implements JavaDelegate {

  private Expression currentAge;

  @Override
  public void execute(DelegateExecution execution) {
    Object value = this.currentAge.getValue(execution);
    int age = value instanceof Integer ? (int)value : Integer.parseInt(value.toString());
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
  }

  private void rotateRight(Game game) {
    // Collection version
    List<Card> tmp = game.currentPlayer().getHand();
    for (int i = 0; i < game.totalPlayers() - 1; i++) {
      game.currentPlayer().setHand(game.previousPlayer().getHand());
    }
    game.currentPlayer().setHand(tmp);
  }

}
