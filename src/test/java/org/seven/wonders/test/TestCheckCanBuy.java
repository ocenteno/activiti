package org.seven.wonders.test;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;
import static org.seven.wonders.effects.CommercialEffect.*;
import static org.seven.wonders.tokens.Resource.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.Expression;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
import org.seven.wonders.effects.CommercialEffect;
import org.seven.wonders.effects.Condition.Scope;
import org.seven.wonders.game.Game;
import org.seven.wonders.game.Player;
import org.seven.wonders.services.CheckCanBuy;
import org.seven.wonders.tokens.Cost;
import org.seven.wonders.tokens.Production;
import org.seven.wonders.tokens.Resource;

@RunWith(MockitoJUnitRunner.class)
public class TestCheckCanBuy {

  private static final Production PRODUCTION_CURRENT = new Production(4);

  private static final Production PRODUCTION_LEFT = new Production(ORE);

  private static final Production PRODUCTION_RIGHT = new Production(ORE, STONE, CLAY, WOOD);

  private static final List<Scope> ALL_SCOPES = Arrays.asList(Scope.RIGHT, Scope.LEFT, Scope.BANK, Scope.OTHERS);

  private static final Cost COST_TOO_HIGH = new Cost(TEXTILE, GLASS, PAPYRUS);

  private static final Cost COST_OK_2_COINS = new Cost(ORE, ORE);

  private static final Cost COST_OK_1_2_COINS = new Cost(ORE, ORE, STONE);

  private static final Cost COST_OK_1_COIN = new Cost(ORE, WOOD, STONE, CLAY);

  private static final Cost COST_OK_DISCOUNTED = new Cost(ORE, STONE, CLAY, ORE);

  private static final Cost HAVE_OR_RESOURCES_TO_BUY_COST = new Cost(2, ORE, ORE, WOOD, STONE);

  private static final Cost DONT_HAVE_OR_RESOURCES_TO_BUY_COST = new Cost(CLAY, CLAY, CLAY, STONE);

  private static final List<CommercialEffect> BUY_SIDES_2G = Arrays.asList(BUY_LEFT_2, BUY_RIGHT_2);

  private Game game = mock(Game.class);

  private Player current = mock(Player.class, withSettings().defaultAnswer(RETURNS_DEEP_STUBS));

  private Player left = mock(Player.class, withSettings().defaultAnswer(RETURNS_DEEP_STUBS));

  private Player right = mock(Player.class, withSettings().defaultAnswer(RETURNS_DEEP_STUBS));

  private Map<Scope, List<Player>> playersByScope;

  private Expression costLeft = mock(Expression.class);

  private Expression player = mock(Expression.class);

  @InjectMocks
  private DelegateExecution execution = mock(DelegateExecution.class);

  private CheckCanBuy checkCanBuy = new CheckCanBuy();

  private Object result;

  private Answer<Object> captureValue = new Answer<Object>() {
    @Override
    public Object answer(InvocationOnMock invocation) throws Throwable {
      Object[] args = invocation.getArguments();
      if (args.length > 1) {
        TestCheckCanBuy.this.result = args[1];
      }
      return null;
    }
  };

  static {
    PRODUCTION_LEFT.addOr(WOOD, ORE);
    PRODUCTION_RIGHT.addOr(CLAY, STONE);
  }

  public TestCheckCanBuy() {
    if (this.playersByScope == null) {
      this.playersByScope = new HashMap<Scope, List<Player>>();
      this.playersByScope.put(Scope.LEFT, Arrays.asList(this.left));
      this.playersByScope.put(Scope.RIGHT, Arrays.asList(this.right));
      this.playersByScope.put(Scope.OTHERS, Arrays.asList(this.left, this.current, this.right));
    }
    when(this.game.currentPlayer()).thenReturn(this.current);
    when(this.game.leftOf(any(Player.class))).thenReturn(this.left);
    when(this.game.rightOf(any(Player.class))).thenReturn(this.right);
    when(this.player.getValue(eq(this.execution))).thenReturn(this.current);
    when(this.execution.getVariable(eq("game"))).thenReturn(this.game);
    when(this.current.getWonder().getScopesByPriceForResource(any(Resource.class))).thenReturn(ALL_SCOPES);
    when(this.current.getWonder().getAvailableScopes()).thenReturn(new HashSet<Scope>(ALL_SCOPES));
    when(this.current.getWonder().getProduces()).thenReturn(PRODUCTION_CURRENT);
    when(this.left.getWonder().getProduces()).thenReturn(PRODUCTION_LEFT);
    when(this.right.getWonder().getProduces()).thenReturn(PRODUCTION_RIGHT);
    when(this.game.getPlayersByScope(any(Player.class))).thenReturn(this.playersByScope);
    doAnswer(this.captureValue).when(this.execution).setVariable(eq("canBuy"), any());
    this.checkCanBuy.setCostLeft(this.costLeft);
    this.checkCanBuy.setPlayer(this.player);
  }

  @Test
  public void testCannotBuyResources() throws Exception {
    when(this.costLeft.getValue(this.execution)).thenReturn(COST_TOO_HIGH);
    this.checkCanBuy.execute(this.execution);
    assertEquals(false, this.result);
  }

  @Test
  public void testCanBuyResources2GoldsEach() throws Exception {
    when(this.costLeft.getValue(this.execution)).thenReturn(COST_OK_2_COINS);
    when(this.current.getWonder().getCostOf(any(Resource.class), any(Scope.class), anyInt())).then(
        new Answer<Integer>() {
          @Override
          public Integer answer(InvocationOnMock invocation) throws Throwable {
            Object[] args = invocation.getArguments();
            int buy = (int)args[2];
            return buy * 2;
          }
        });
    this.checkCanBuy.execute(this.execution);
    assertEquals(true, this.result);
  }

  @Test
  public void testCanBuyResources1GoldRight() throws Exception {
    when(this.costLeft.getValue(this.execution)).thenReturn(COST_OK_1_COIN);
    when(this.current.getWonder().getCostOf(any(Resource.class), any(Scope.class), anyInt())).then(
        new Answer<Integer>() {
          @Override
          public Integer answer(InvocationOnMock invocation) throws Throwable {
            Object[] args = invocation.getArguments();
            Scope scope = (Scope)args[1];
            int buy = (int)args[2];
            return buy * (scope == Scope.RIGHT ? 1 : 2);
          }
        });
    this.checkCanBuy.execute(this.execution);
    assertEquals(true, this.result);
  }

  @Test
  public void testCannotBuyResources2GoldEach() throws Exception {
    when(this.costLeft.getValue(this.execution)).thenReturn(COST_OK_1_2_COINS);
    when(this.current.getWonder().getCostOf(any(Resource.class), any(Scope.class), anyInt())).then(
        new Answer<Integer>() {
          @Override
          public Integer answer(InvocationOnMock invocation) throws Throwable {
            Object[] args = invocation.getArguments();
            int buy = (int)args[2];
            return buy * 2;
          }
        });
    this.checkCanBuy.execute(this.execution);
    assertEquals(false, this.result);
  }

  @Test
  public void testCanBuyResourcesWithDiscount() throws Exception {
    when(this.costLeft.getValue(this.execution)).thenReturn(COST_OK_DISCOUNTED);
    when(this.current.getWonder().getCostOf(any(Resource.class), any(Scope.class), anyInt())).then(
        new Answer<Integer>() {
          @Override
          public Integer answer(InvocationOnMock invocation) throws Throwable {
            Object[] args = invocation.getArguments();
            int buy = (int)args[2];
            return buy * 2;
          }
        });
    when(this.current.getWonder().getDiscount(any(Scope.class))).thenReturn(-1);
    this.checkCanBuy.execute(this.execution);
    assertEquals(true, this.result);
  }

}
