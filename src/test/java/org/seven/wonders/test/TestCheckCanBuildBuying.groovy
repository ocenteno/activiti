package org.seven.wonders.test

import static org.junit.Assert.*
import static org.mockito.Matchers.*
import static org.mockito.Mockito.*
import static org.seven.wonders.tokens.Resource.*

import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.invocation.InvocationOnMock
import org.mockito.runners.MockitoJUnitRunner
import org.mockito.stubbing.Answer
import org.seven.wonders.cards.Card
import org.seven.wonders.effects.Condition.Scope
import org.seven.wonders.game.Game
import org.seven.wonders.game.Player
import org.seven.wonders.game.Production;
import org.seven.wonders.services.CheckCanBuild
import org.seven.wonders.tokens.Cost
import org.seven.wonders.tokens.Resource


@RunWith(MockitoJUnitRunner.class)
public class TestCheckCanBuildBuying {

  static final Production PRODUCTION_CURRENT = new Production(4)

  static final Production PRODUCTION_LEFT = new Production(ORE)

  static final Production PRODUCTION_RIGHT = new Production(ORE, STONE, CLAY, WOOD)

  static final List<Scope> ALL_SCOPES = Arrays.asList(Scope.RIGHT, Scope.LEFT, Scope.BANK, Scope.OTHERS)

  static final Cost COST_TOO_HIGH = new Cost(TEXTILE, GLASS, PAPYRUS)

  static final Cost COST_OK_2_COINS = new Cost(ORE, ORE)

  static final Cost COST_OK_1_2_COINS = new Cost(ORE, ORE, STONE)

  static final Cost COST_OK_1_COIN = new Cost(ORE, WOOD, STONE, CLAY)

  static final Cost COST_OK_DISCOUNTED = new Cost(ORE, STONE, CLAY, ORE)

  Card card = mock(Card.class)

  Game game = mock(Game.class)

  Player current = mock(Player.class, withSettings().defaultAnswer(RETURNS_DEEP_STUBS))

  Player left = mock(Player.class, withSettings().defaultAnswer(RETURNS_DEEP_STUBS))

  Player right = mock(Player.class, withSettings().defaultAnswer(RETURNS_DEEP_STUBS))

  def playersByScope

  def result

  private Answer<Object> captureValue = new Answer<Object>() {
    @Override
    public Object answer(InvocationOnMock invocation) throws Throwable {
      Object[] args = invocation.getArguments()
      if (args.length > 1) {
        TestCheckCanBuildBuying.this.result = args[1]
      }
      return null
    }
  }

  static {
    PRODUCTION_LEFT.addOr(WOOD, ORE)
    PRODUCTION_RIGHT.addOr(CLAY, STONE)
  }

  public TestCheckCanBuildBuying() {
    if (this.playersByScope == null) {
      this.playersByScope = [:]
      this.playersByScope << [(Scope.LEFT): [this.left]]
      this.playersByScope << [(Scope.RIGHT): [this.right]]
      this.playersByScope << [(Scope.OTHERS): [
          this.left,
          this.current,
          this.right
        ]]
    }
    when(this.game.currentPlayer()).thenReturn(this.current)
    when(this.game.leftOf(any(Player.class))).thenReturn(this.left)
    when(this.game.rightOf(any(Player.class))).thenReturn(this.right)
    when(this.current.wonder.getScopesByPriceForResource(any(Resource.class))).thenReturn(ALL_SCOPES)
    when(this.current.wonder.getAvailableScopes()).thenReturn(new HashSet<Scope>(ALL_SCOPES))
    when(this.current.wonder.produces).thenReturn(PRODUCTION_CURRENT)
    when(this.left.wonder.produces).thenReturn(PRODUCTION_LEFT)
    when(this.right.wonder.produces).thenReturn(PRODUCTION_RIGHT)
    when(this.game.getPlayersByScope(any(Player.class))).thenReturn(this.playersByScope)
  }

  @Test
  public void testCannotBuyResources()  {
    when(this.card.cost).thenReturn(COST_TOO_HIGH)
    boolean canBuild = CheckCanBuild.run(game, current, card)
    assertFalse(canBuild)
  }

  @Test
  public void testCanBuyResources2GoldsEach() {
    when(this.card.cost).thenReturn(COST_OK_2_COINS)
    when(this.current.wonder.getCostOf(any(Resource.class), any(Scope.class), anyInt())).then(
        new Answer<Integer>() {
          @Override
          public Integer answer(InvocationOnMock invocation) throws Throwable {
            Object[] args = invocation.getArguments()
            int buy = (int)args[2]
            return buy * 2
          }
        })
    boolean canBuild = CheckCanBuild.run(game, current, card)
    assertTrue(canBuild)
  }

  @Test
  public void testCanBuyResources1GoldRight() {
    when(this.card.cost).thenReturn(COST_OK_1_COIN)
    when(this.current.getWonder().getCostOf(any(Resource.class), any(Scope.class), anyInt())).then(
        new Answer<Integer>() {
          @Override
          public Integer answer(InvocationOnMock invocation) throws Throwable {
            Object[] args = invocation.getArguments()
            Scope scope = (Scope)args[1]
            int buy = (int)args[2]
            return buy * (scope == Scope.RIGHT ? 1 : 2)
          }
        })
    boolean canBuild = CheckCanBuild.run(game, current, card)
    assertTrue(canBuild)
  }

  @Test
  public void testCannotBuyResources2GoldEach() {
    when(this.card.cost).thenReturn(COST_OK_1_2_COINS)
    when(this.current.getWonder().getCostOf(any(Resource.class), any(Scope.class), anyInt())).then(
        new Answer<Integer>() {
          @Override
          public Integer answer(InvocationOnMock invocation) throws Throwable {
            Object[] args = invocation.getArguments()
            int buy = (int)args[2]
            return buy * 2
          }
        })
    boolean canBuild = CheckCanBuild.run(game, current, card)
    assertFalse(canBuild)
  }

  @Test
  public void testCanBuyResourcesWithDiscount() {
    when(this.card.cost).thenReturn(COST_OK_DISCOUNTED)
    when(this.current.getWonder().getDiscount(any(Scope.class))).thenReturn(-1)
    when(this.current.getWonder().getCostOf(any(Resource.class), any(Scope.class), anyInt())).then(
        new Answer<Integer>() {
          @Override
          public Integer answer(InvocationOnMock invocation) throws Throwable {
            Object[] args = invocation.getArguments()
            int buy = (int)args[2]
            return buy * 2
          }
        })
    boolean canBuild = CheckCanBuild.run(game, current, card)
    assertTrue(canBuild)
  }
}
