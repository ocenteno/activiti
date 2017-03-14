package org.seven.wonders.test

import static org.junit.Assert.*
import static org.mockito.Mockito.*

import org.activiti.engine.delegate.DelegateExecution
import org.activiti.engine.delegate.Expression
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.runners.MockitoJUnitRunner
import org.seven.wonders.cards.CardsFactory
import org.seven.wonders.game.Game
import org.seven.wonders.game.Player
import org.seven.wonders.game.Player.Action
import org.seven.wonders.services.ChooseCard

@RunWith(MockitoJUnitRunner.class)
public class TestChooseCard {

  private Game currentGame = Game.processParameters(false, false, false, false, true, false)

  private Player currentPlayer

  private Expression game = mock(Expression.class)

  private Expression current = mock(Expression.class)

  private DelegateExecution execution = mock(DelegateExecution.class)

  @InjectMocks
  private ChooseCard chooseCard = new ChooseCard()

  @Before
  public void startProcess() {
    currentGame.random(3)
    currentPlayer = currentGame.currentPlayer()
    when(game.getValue(any(DelegateExecution.class))).thenReturn(currentGame)
    when(current.getValue(any(DelegateExecution.class))).thenReturn(currentPlayer)
  }

  @Test
  public void testChooseCardBuildable() {
    currentPlayer.hand = CardsFactory.getCardsAgeI(1, true)
    assertEquals(8, currentPlayer.hand.size())
    this.chooseCard.execute(this.execution)
    // Card chosen
    assertNotNull(currentPlayer.cardToPlay)
    assertEquals(Action.BUILD, currentPlayer.actionToPlay)
    assertEquals(7, currentPlayer.hand.size())
    this.chooseCard.execute(this.execution)
    assertEquals(6, currentPlayer.hand.size())
  }

  @Test
  public void testChooseCardNotBuildableToSell() {
    CardsFactory.getCardsAgeIII(3, true).each{
      currentGame.nextPlayer().add(it)
    }
    assertEquals(8, currentPlayer.hand.size())
    this.chooseCard.execute(this.execution)
    // Card chosen
    assertNotNull(currentPlayer.cardToPlay)
    assertEquals(Action.SELL, currentPlayer.actionToPlay)
    assertEquals(7, currentPlayer.hand.size())
    this.chooseCard.execute(this.execution)
    assertEquals(6, currentPlayer.hand.size())
  }
}
