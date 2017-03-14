package org.seven.wonders.services

import static org.seven.wonders.game.Player.Action.*
import static org.seven.wonders.tokens.Resource.*

import org.activiti.engine.delegate.DelegateExecution
import org.activiti.engine.delegate.Expression
import org.activiti.engine.delegate.JavaDelegate
import org.seven.wonders.game.Game
import org.seven.wonders.game.Player

class ChooseCard implements JavaDelegate {

  private Expression game
  private Expression current
  private Game currentGame
  private Player currentPlayer

  @Override
  public void execute(DelegateExecution execution) {
    currentGame = game.getValue(execution)
    currentPlayer = current.getValue(execution)
    currentPlayer.cardToPlay = null
    currentPlayer.actionToPlay = null
    def options = (currentPlayer.hand.clone() << currentPlayer.wonder.nextStages).flatten()
    Collections.sort(options, currentPlayer.wonder.comparator)
    evaluateEachOption(options)
    chooseOption()
  }

  private evaluateEachOption(options) {
    options.each{ card ->
      if(currentPlayer.cardToPlay != null){
        return
      }
      // can build chaining, with resources, or buying
      if(currentPlayer.wonder.canChain(card) || CheckCanBuild.run(currentGame, currentPlayer, card)){
        return chooseCard(card)
      }
    }
  }

  def chooseCard(card){
    currentPlayer.actionToPlay = BUILD
    if(card.class instanceof org.seven.wonders.cards.Stage)
      currentPlayer.actionToPlay = STAGE
    if(card.class instanceof org.seven.wonders.cards.Sell)
      currentPlayer.actionToPlay = SELL
    currentPlayer.cardToPlay = card
  }

  def chooseOption(){
    // By default sell the card
    if(currentPlayer.actionToPlay == null)
      currentPlayer.actionToPlay=SELL
    // Selling & evolving the wonder will use least important card (TODO: choose best for next player)
    if(currentPlayer.actionToPlay==STAGE || currentPlayer.actionToPlay==SELL)
      currentPlayer.cardToPlay=currentPlayer.hand.last()
    // remove chosen card from hand
    currentPlayer.hand -= currentPlayer.cardToPlay
  }

}
