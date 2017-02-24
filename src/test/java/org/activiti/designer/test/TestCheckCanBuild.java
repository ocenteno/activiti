package org.activiti.designer.test;

import static org.junit.Assert.*;
import static org.seven.wonders.tokens.Resource.*;

import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.delegate.VariableScope;
import org.activiti.engine.test.Deployment;
import org.junit.Before;
import org.junit.Test;
import org.seven.wonders.tokens.Cost;
import org.seven.wonders.tokens.Production;

public class TestCheckCanBuild extends AbstractTest {

  private static final Cost DONT_HAVE_ENOUGH_GOLD_COST = new Cost(2, STONE);

  private static final Production DONT_HAVE_ENOUGH_GOLD_PROD = new Production(1, STONE);

  private static final Cost HAVE_ENOUGH_RESOURCES_TO_BUY_COST = new Cost(2, ORE, ORE, WOOD);

  private static final Production HAVE_ENOUGH_RESOURCES_TO_BUY_PROD = new Production(3, STONE, ORE, ORE, ORE, WOOD);

  private static final Cost HAVE_OR_RESOURCES_TO_BUY_COST = new Cost(2, ORE, ORE, WOOD, STONE);

  private static final Production HAVE_OR_RESOURCES_TO_BUY_PROD = new Production(3, ORE, WOOD);

  private static final Cost DONT_HAVE_OR_RESOURCES_TO_BUY_COST = new Cost(CLAY, CLAY, CLAY, STONE);

  private static final Production DONT_HAVE_OR_RESOURCES_TO_BUY_PROD = new Production(ORE);

  static {
    HAVE_OR_RESOURCES_TO_BUY_PROD.addOr(WOOD, STONE);
    HAVE_OR_RESOURCES_TO_BUY_PROD.addOr(WOOD, ORE);
    DONT_HAVE_OR_RESOURCES_TO_BUY_PROD.addOr(CLAY, STONE);
  }

  public TestCheckCanBuild() {
    super("check-can-build");
  }

  @Before
  @Override
  public void startProcess() {
    this.runtimeService = this.activitiRule.getRuntimeService();
  }

  @Test
  @Deployment(resources = { "diagrams/CheckCanBuild.bpmn" })
  public void testHaveEnoughResourcesToBuy() {
    Map<String, Object> variableMap = new HashMap<String, Object>();
    variableMap.put("cost", HAVE_ENOUGH_RESOURCES_TO_BUY_COST);
    variableMap.put("prod", HAVE_ENOUGH_RESOURCES_TO_BUY_PROD);
    this.processInstance = this.runtimeService.startProcessInstanceByKey(this.name, variableMap);
    assertTrue(this.processInstance instanceof VariableScope);
    assertEquals(((VariableScope)this.processInstance).getVariable("canBuild"), true);
  }

  @Test
  @Deployment(resources = { "diagrams/CheckCanBuild.bpmn" })
  public void testDontHaveEnoughGold() {
    Map<String, Object> variableMap = new HashMap<String, Object>();
    variableMap.put("cost", DONT_HAVE_ENOUGH_GOLD_COST);
    variableMap.put("prod", DONT_HAVE_ENOUGH_GOLD_PROD);
    this.processInstance = this.runtimeService.startProcessInstanceByKey(this.name, variableMap);
    assertTrue(this.processInstance instanceof VariableScope);
    assertEquals(((VariableScope)this.processInstance).getVariable("canBuild"), false);
  }

  @Test
  @Deployment(resources = { "diagrams/CheckCanBuild.bpmn" })
  public void testHaveOrResourcesToBuy() {
    Map<String, Object> variableMap = new HashMap<String, Object>();
    variableMap.put("cost", HAVE_OR_RESOURCES_TO_BUY_COST);
    variableMap.put("prod", HAVE_OR_RESOURCES_TO_BUY_PROD);
    this.processInstance = this.runtimeService.startProcessInstanceByKey(this.name, variableMap);
    assertTrue(this.processInstance instanceof VariableScope);
    assertEquals(((VariableScope)this.processInstance).getVariable("canBuild"), true);
  }

  @Test
  @Deployment(resources = { "diagrams/CheckCanBuild.bpmn" })
  public void testDontHaveOrResourcesToBuy() {
    Map<String, Object> variableMap = new HashMap<String, Object>();
    variableMap.put("cost", DONT_HAVE_OR_RESOURCES_TO_BUY_COST);
    variableMap.put("prod", DONT_HAVE_OR_RESOURCES_TO_BUY_PROD);
    this.processInstance = this.runtimeService.startProcessInstanceByKey(this.name, variableMap);
    assertTrue(this.processInstance instanceof VariableScope);
    assertEquals(((VariableScope)this.processInstance).getVariable("canBuild"), false);
  }

}
