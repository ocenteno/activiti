package org.seven.wonders.services;

import java.util.List;

import lombok.Data;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.Expression;
import org.activiti.engine.delegate.JavaDelegate;
import org.seven.wonders.cards.Card;
import org.seven.wonders.game.Game;

@Data
public class HandOutCards implements JavaDelegate {

  private Expression currentAge;

  private Game game;

  @Override
  public void execute(DelegateExecution execution) {
    Object value = this.currentAge.getValue(execution);
    int age = value instanceof Integer ? (int)value : Integer.parseInt(value.toString());
    if (this.game == null) {
      this.game = (Game)execution.getVariable("game");
    }
    if (age % 2 == 0) { // Leaders || Age II
      rotateRight();
    } else { // Age I || Age III
      rotateLeft();
    }
  }

  private void rotateLeft() {
    // Collection version
    List<Card> tmp = this.game.currentPlayer().getHand();
    for (int i = 0; i < this.game.totalPlayers() - 1; i++) {
      this.game.currentPlayer().setHand(this.game.nextPlayer().getHand());
    }
    this.game.currentPlayer().setHand(tmp);
  }

  private void rotateRight() {
    // Collection version
    List<Card> tmp = this.game.currentPlayer().getHand();
    for (int i = 0; i < this.game.totalPlayers() - 1; i++) {
      this.game.currentPlayer().setHand(this.game.previousPlayer().getHand());
    }
    this.game.currentPlayer().setHand(tmp);
  }

}
