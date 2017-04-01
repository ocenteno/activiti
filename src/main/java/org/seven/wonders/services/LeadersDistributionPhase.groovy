package org.seven.wonders.services

import org.activiti.engine.delegate.DelegateExecution
import org.seven.wonders.game.Game
import org.seven.wonders.leaders.LeadersFactory

public class LeadersDistributionPhase extends HandOutCards {

  @Override
  public void execute(DelegateExecution execution) {
    game = execution.getVariable("game")
    def cards = LeadersFactory.getLeaders(game.totalPlayers(), game.thrones)
    Collections.shuffle(cards)
    cards.each{
      game.nextPlayer().add(it)
    }
    chooseLeader()
    super.execute(execution)
  }

  def chooseLeader(){
    while(!game.isLeaderPhaseFinished()){
      game.players.each{ current ->
        Collections.sort(current.hand, current.wonder.comparator)
        def card = current.hand[0]
        current.leaders.add(card)
        current.hand.remove(card)
      }
    }
  }
}
