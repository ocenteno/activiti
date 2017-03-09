package org.seven.wonders.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.delegate.VariableScope;
import org.activiti.engine.impl.test.PluggableActivitiTestCase;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.test.Deployment;
import org.junit.Test;
import org.seven.wonders.game.Game;
import org.seven.wonders.leaders.Leader;
import org.seven.wonders.leaders.LeadersFactory;

public class TestAgeSubprocess extends PluggableActivitiTestCase {

  private Game game = Game.processParameters(false, true, false, false, true, false);

  public TestAgeSubprocess() {
    this.game.random(3);
    this.game.currentPlayer().getWonder().getProduces().add(6);
    List<Leader> leaders = LeadersFactory.getLeaders(3, true);
    for (Leader leader : leaders) {
      this.game.nextPlayer().getLeaders().add(leader);
    }
  }

  @Test
  @Deployment(resources = { "diagrams/Age.bpmn", "diagrams/PlayLeader.bpmn", "diagrams/ChooseCard.bpmn",
  "diagrams/CheckCanBuild.bpmn" })
  public void testBuyLeader() {
    Map<String, Object> variableMap = new HashMap<String, Object>();
    variableMap.put("game", this.game);
    variableMap.put("input", 1);
    ProcessInstance processInstance = this.runtimeService.startProcessInstanceByKey("age", variableMap);
    waitForJobExecutorToProcessAllJobs(11000L, 25L);

    assertTrue(processInstance instanceof VariableScope);
    assertEquals(this.game, ((VariableScope)processInstance).getVariable("game"));
    // 1 leader used
    assertNotNull(this.game.currentPlayer().getLeaders());
    assertEquals(3, this.game.currentPlayer().getLeaders().size());
    assertEquals(0, this.game.currentPlayer().getHand().size());
  }

}
