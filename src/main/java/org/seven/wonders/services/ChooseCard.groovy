package org.seven.wonders.services

import static org.seven.wonders.game.Player.Action.*
import static org.seven.wonders.tokens.Resource.*

import org.activiti.engine.delegate.DelegateExecution
import org.activiti.engine.delegate.Expression
import org.activiti.engine.delegate.JavaDelegate
import org.seven.wonders.game.Game
import org.seven.wonders.game.Player

class ChooseCard implements JavaDelegate {

  private Expression current
  private Game game
  private Player player

  @Override
  public void execute(DelegateExecution execution) {
    game = (Game)execution.getVariable("game")
    player = current.getValue(execution)
    player.cardToPlay = null
    player.actionToPlay = null
    run()
  }

  def run() {
    def options = (player.hand.clone() << player.wonder.nextStages).flatten()
    Collections.sort(options, player.wonder.comparator)
    evaluateEachOption(options)
    chooseOption()
  }

  private evaluateEachOption(options) {
    options.each{ card ->
      if(player.cardToPlay != null){
        return
      }
      // can build chaining, with resources, or buying
      if(player.wonder.canChain(card) || CheckCanBuild.run(game, player, card)){
        return chooseCard(card)
      }
    }
  }

  def chooseCard(card){
    player.actionToPlay = BUILD
    if(card.class instanceof org.seven.wonders.cards.Stage)
      player.actionToPlay = STAGE
    if(card.class instanceof org.seven.wonders.cards.Sell)
      player.actionToPlay = SELL
    player.cardToPlay = card
  }

  def chooseOption(){
    // By default sell the card
    if(player.actionToPlay == null)
      player.actionToPlay=SELL
    // Selling & evolving the wonder will use least important card (TODO: choose best for next player)
    if(player.actionToPlay==STAGE || player.actionToPlay==SELL)
      player.cardToPlay=player.hand.last()
    // remove chosen card from hand
    player.hand -= player.cardToPlay
  }

}
