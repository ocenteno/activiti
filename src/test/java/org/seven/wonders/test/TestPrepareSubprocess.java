package org.seven.wonders.test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.delegate.VariableScope;
import org.activiti.engine.test.Deployment;
import org.junit.Before;
import org.junit.Test;
import org.seven.wonders.game.Game;

public class TestPrepareSubprocess extends AbstractTest {

  private Game game = Game.processParameters(false, false, false, false, true, false);

  public TestPrepareSubprocess() {
    super("prepare");
  }

  @Before
  @Override
  public void startProcess() {
    this.runtimeService = this.activitiRule.getRuntimeService();
    this.game.random(3);
  }

  @Test
  @Deployment(resources = { "diagrams/Prepare.bpmn", "diagrams/Distribute.bpmn", "diagrams/ChooseCard.bpmn" })
  public void testPrepareProcess() {
    Map<String, Object> variableMap = new HashMap<String, Object>();
    variableMap.put("game", this.game);
    this.processInstance = this.runtimeService.startProcessInstanceByKey(this.name, variableMap);
    assertNotNull(this.processInstance.getId());
    assertTrue(this.processInstance instanceof VariableScope);
    assertEquals(true, ((VariableScope)this.processInstance).getVariable("canBuild"));
  }
}
