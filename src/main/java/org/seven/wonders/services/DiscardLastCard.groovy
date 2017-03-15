package org.seven.wonders.services

import org.activiti.engine.delegate.DelegateExecution
import org.activiti.engine.delegate.Expression
import org.activiti.engine.delegate.JavaDelegate
import org.seven.wonders.game.Game
import org.seven.wonders.game.Player

public class DiscardLastCard implements JavaDelegate {

  private Expression current

  @Override
  public void execute(DelegateExecution execution) {
    Game game = (Game)execution.getVariable("game")
    def player = (Player) this.current.getValue(execution)
    if(player.canPlayLast())
      playLast(game,player)
    else
      discardLast(game,player)
    player.actionToPlay = null
    player.cardToPlay = null
  }

  def playLast(Game game, Player player){
    def card = player.hand[0]
    def script = new ChooseCard(player:player,game:game)
    script.run()
    player.playCard()
  }

  def discardLast(Game game, Player player){
    def card = player.hand.remove(0)
    game.discard(card)
  }
}
