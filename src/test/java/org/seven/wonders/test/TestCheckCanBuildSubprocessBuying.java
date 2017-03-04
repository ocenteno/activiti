package org.seven.wonders.test;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;
import static org.seven.wonders.tokens.Resource.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.Expression;
import org.activiti.engine.delegate.VariableScope;
import org.activiti.engine.test.Deployment;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
import org.seven.wonders.effects.Condition.Scope;
import org.seven.wonders.game.Game;
import org.seven.wonders.game.Player;
import org.seven.wonders.services.CheckCanBuy;
import org.seven.wonders.tokens.Cost;
import org.seven.wonders.tokens.Production;
import org.seven.wonders.tokens.Resource;

@RunWith(MockitoJUnitRunner.class)
public class TestCheckCanBuildSubprocessBuying extends AbstractTest {

  private static final Production CURRENT_PROD = new Production(ORE);

  private static final Cost COST_TOO_HIGH = new Cost(TEXTILE, GLASS, PAPYRUS);

  private static final Cost COST_OK_2_COINS = new Cost(ORE, ORE);

  private static final Cost COST_KO_2_COINS = new Cost(ORE, ORE, WOOD, STONE);

  private static final Cost COST_OK_1_COIN = new Cost(ORE, WOOD, STONE, CLAY);

  private static final Cost COST_OK_DISCOUNTED = new Cost(ORE, STONE, CLAY, ORE);

  private static final Cost NOT_AVAILABLE_RESOURCES_COST = new Cost(CLAY, CLAY, CLAY, STONE);

  private static Game GAME = Game.processParameters(false, false, false, false, true, false);

  private static Player CURRENT;

  private static Player LEFT;

  private static Player RIGHT;

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
        TestCheckCanBuildSubprocessBuying.this.result = args[1];
      }
      return null;
    }
  };

  private HashMap<String, Object> variableMap;

  static {
    GAME.random(3);
    RIGHT = GAME.nextPlayer();
    RIGHT.getWonder().getProduces().add(ORE, STONE, CLAY, WOOD);
    RIGHT.getWonder().getProduces().addOr(CLAY, STONE);
    LEFT = GAME.nextPlayer();
    LEFT.getWonder().getProduces().add(ORE);
    LEFT.getWonder().getProduces().addOr(WOOD, ORE);
    CURRENT = GAME.nextPlayer();
    CURRENT.getWonder().getProduces().add(4);
  }

  public TestCheckCanBuildSubprocessBuying() {
    super("check-can-build");
    if (this.playersByScope == null) {
      this.playersByScope = new HashMap<Scope, List<Player>>();
      this.playersByScope.put(Scope.LEFT, Arrays.asList(LEFT));
      this.playersByScope.put(Scope.RIGHT, Arrays.asList(RIGHT));
      this.playersByScope.put(Scope.OTHERS, Arrays.asList(LEFT, CURRENT, RIGHT));
    }
    when(this.player.getValue(eq(this.execution))).thenReturn(CURRENT);
    when(this.execution.getVariable(eq("game"))).thenReturn(GAME);
    doAnswer(this.captureValue).when(this.execution).setVariable(eq("canBuy"), any());
    this.checkCanBuy.setCostLeft(this.costLeft);
    this.checkCanBuy.setPlayer(this.player);
  }

  @Before
  @Override
  public void startProcess() {
    this.runtimeService = this.activitiRule.getRuntimeService();
    this.variableMap = new HashMap<String, Object>();
    this.variableMap.put("prod", CURRENT_PROD);
    this.variableMap.put("current", GAME.currentPlayer());
    this.variableMap.put("game", GAME);
  }

  @Test
  @Deployment(resources = { "diagrams/CheckCanBuild.bpmn", "diagrams/CompareNeedHave.bpmn" })
  public void testDontHaveResourcesToBuy() {
    this.variableMap.put("cost", NOT_AVAILABLE_RESOURCES_COST);
    this.processInstance = this.runtimeService.startProcessInstanceByKey(this.name, this.variableMap);
    assertTrue(this.processInstance instanceof VariableScope);
    assertEquals(false, ((VariableScope)this.processInstance).getVariable("canBuy"));
  }

  @Test
  @Deployment(resources = { "diagrams/CheckCanBuild.bpmn", "diagrams/CompareNeedHave.bpmn" })
  public void testDontHaveGoldToBuy() {
    this.variableMap.put("cost", COST_TOO_HIGH);
    this.processInstance = this.runtimeService.startProcessInstanceByKey(this.name, this.variableMap);
    assertTrue(this.processInstance instanceof VariableScope);
    assertEquals(false, ((VariableScope)this.processInstance).getVariable("canBuy"));
  }

  @Test
  @Deployment(resources = { "diagrams/CheckCanBuild.bpmn", "diagrams/CompareNeedHave.bpmn" })
  public void testCanBuyResources2GoldsEach() throws Exception {
    this.variableMap.put("cost", COST_OK_2_COINS);
    this.processInstance = this.runtimeService.startProcessInstanceByKey(this.name, this.variableMap);
    assertTrue(this.processInstance instanceof VariableScope);
    assertEquals(true, ((VariableScope)this.processInstance).getVariable("canBuy"));
  }

  // @Test
  public void testCanBuyResources1GoldRight() throws Exception {
    when(this.costLeft.getValue(this.execution)).thenReturn(COST_OK_1_COIN);
    when(TestCheckCanBuildSubprocessBuying.CURRENT.getWonder().getCostOf(any(Resource.class), any(Scope.class), anyInt())).then(
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
  @Deployment(resources = { "diagrams/CheckCanBuild.bpmn", "diagrams/CompareNeedHave.bpmn" })
  public void testCannotBuyResources2GoldEach() throws Exception {
    this.variableMap.put("cost", COST_KO_2_COINS);
    this.processInstance = this.runtimeService.startProcessInstanceByKey(this.name, this.variableMap);
    assertTrue(this.processInstance instanceof VariableScope);
    assertEquals(false, ((VariableScope)this.processInstance).getVariable("canBuy"));
  }

  // @Test
  public void testCanBuyResourcesWithDiscount() throws Exception {
    when(this.costLeft.getValue(this.execution)).thenReturn(COST_OK_DISCOUNTED);
    when(TestCheckCanBuildSubprocessBuying.CURRENT.getWonder().getCostOf(any(Resource.class), any(Scope.class), anyInt())).then(
        new Answer<Integer>() {
          @Override
          public Integer answer(InvocationOnMock invocation) throws Throwable {
            Object[] args = invocation.getArguments();
            int buy = (int)args[2];
            return buy * 2;
          }
        });
    when(TestCheckCanBuildSubprocessBuying.CURRENT.getWonder().getDiscount(any(Scope.class))).thenReturn(-1);
    this.checkCanBuy.execute(this.execution);
    assertEquals(true, this.result);
  }

}
