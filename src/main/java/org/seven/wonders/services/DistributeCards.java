package org.seven.wonders.services;

import java.util.Collections;
import java.util.List;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.Expression;
import org.activiti.engine.delegate.JavaDelegate;
import org.seven.wonders.cards.Card;
import org.seven.wonders.game.Game;

public class DistributeCards implements JavaDelegate {

  private Expression cards;

  private Expression game;

  @Override
  @SuppressWarnings("unchecked")
  public void execute(DelegateExecution execution) {
    Game game = (Game)this.game.getValue(execution);
    List<Card> cards = (List<Card>)this.cards.getValue(execution);
    Collections.shuffle(cards);
    for (Card card : cards) {
      game.nextPlayer().add(card);
    }
  }
}
