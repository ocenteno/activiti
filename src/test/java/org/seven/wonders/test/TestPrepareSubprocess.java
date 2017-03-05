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
  public void testPrepareProcessWithLeaders() {
    Map<String, Object> variableMap = new HashMap<String, Object>();
    variableMap.put("game", this.game);
    this.processInstance = this.runtimeService.startProcessInstanceByKey(this.name, variableMap);
    assertTrue(this.processInstance instanceof VariableScope);
    assertEquals(this.game, ((VariableScope)this.processInstance).getVariable("game"));
    assertNotNull(((VariableScope)this.processInstance).getVariable("cards"));
    // 6 coins for each player
    assertEquals(6, this.game.currentPlayer().getCoins());
    // Leaders distributed
    assertNotNull(this.game.currentPlayer().getLeaders());
    assertEquals(4, this.game.currentPlayer().getLeaders().size());
    assertEquals(0, this.game.currentPlayer().getHand().size());
  }

}
