package org.seven.wonders.services

import static org.seven.wonders.game.Player.Action.*
import static org.seven.wonders.tokens.Resource.*

import org.activiti.engine.delegate.DelegateExecution
import org.seven.wonders.game.Game
import org.seven.wonders.game.Player

class PlayLeader extends ChooseCard {

  @Override
  public void execute(DelegateExecution execution) {
    game = (Game)execution.getVariable("game")
    // Choose Leader
    for(Player it : game.players){
      setPlayer(it)
      player.hand = player.leaders
      run()
    }
    // Play Leader
    for(Player it : game.players){
      def card = it.playCard()
      if(card != null) game.discard(card)
      it.hand = []
    }
  }
}
