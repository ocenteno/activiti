package org.seven.wonders.test

import static org.junit.Assert.*
import static org.mockito.Mockito.*
import static org.seven.wonders.tokens.Resource.*

import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.runners.MockitoJUnitRunner
import org.seven.wonders.cards.Card
import org.seven.wonders.game.Game
import org.seven.wonders.game.Player
import org.seven.wonders.game.Production;
import org.seven.wonders.services.CheckCanBuild
import org.seven.wonders.tokens.Cost

@RunWith(MockitoJUnitRunner.class)
public class TestCheckCanBuild {

  static final Cost FREE = new Cost()

  static final Cost ONLY_COINS = new Cost(2)

  static final Production HAVE_ONLY_GOLD_PROD = new Production(4)

  static final Cost HAVE_ENOUGH_RESOURCES_TO_BUY_COST = new Cost(2, ORE, ORE, WOOD)

  static final Production HAVE_ENOUGH_RESOURCES_TO_BUY_PROD = new Production(3, STONE, ORE, ORE, ORE, WOOD)

  static final Cost DONT_HAVE_ENOUGH_GOLD_COST = new Cost(2, STONE)

  static final Production DONT_HAVE_ENOUGH_GOLD_PROD = new Production(1, STONE)

  static final Cost HAVE_OR_RESOURCES_TO_BUY_COST = new Cost(2, ORE, ORE, WOOD, STONE)

  static final Production HAVE_OR_RESOURCES_TO_BUY_PROD = new Production(3, ORE, WOOD)

  def Game game = mock(Game.class)

  def Card card = mock(Card.class)

  def Player current = mock(Player.class, withSettings().defaultAnswer(RETURNS_DEEP_STUBS))

  @Test
  public void testCardForFree() {
    when(card.cost).thenReturn(FREE)
    when(current.getWonder().getProduces()).thenReturn(HAVE_ONLY_GOLD_PROD)
    boolean canBuild = CheckCanBuild.run(game, current, card)
    assertTrue(canBuild)
  }

  @Test
  public void testCardCostingEnoughGold() {
    when(card.cost).thenReturn(ONLY_COINS)
    when(this.current.getWonder().getProduces()).thenReturn(HAVE_ONLY_GOLD_PROD)
    boolean canBuild = CheckCanBuild.run(game, current, card)
    assertTrue(canBuild)
  }

  @Test
  public void testHaveEnoughResourcesToBuy() {
    when(card.cost).thenReturn(HAVE_ENOUGH_RESOURCES_TO_BUY_COST)
    when(this.current.getWonder().getProduces()).thenReturn(HAVE_ENOUGH_RESOURCES_TO_BUY_PROD)
    boolean canBuild = CheckCanBuild.run(game, current, card)
    assertTrue(canBuild)
  }

  @Test
  public void testDontHaveEnoughGold() {
    when(card.cost).thenReturn(DONT_HAVE_ENOUGH_GOLD_COST)
    when(this.current.getWonder().getProduces()).thenReturn(DONT_HAVE_ENOUGH_GOLD_PROD)
    boolean canBuild = CheckCanBuild.run(game, current, card)
    assertFalse(canBuild)
  }

  @Test
  public void testHaveOrResourcesToBuy() {
    when(card.cost).thenReturn(HAVE_OR_RESOURCES_TO_BUY_COST)
    HAVE_OR_RESOURCES_TO_BUY_PROD.addOr(WOOD, STONE)
    HAVE_OR_RESOURCES_TO_BUY_PROD.addOr(WOOD, ORE)
    HAVE_OR_RESOURCES_TO_BUY_PROD.addOr(TEXTILE, GLASS, PAPYRUS)
    when(this.current.getWonder().getProduces()).thenReturn(HAVE_OR_RESOURCES_TO_BUY_PROD)
    boolean canBuild = CheckCanBuild.run(game, current, card)
    assertTrue(canBuild)
  }
}
