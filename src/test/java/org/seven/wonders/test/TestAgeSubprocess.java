package org.seven.wonders.test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.delegate.VariableScope;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.test.Deployment;
import org.junit.Before;
import org.junit.Test;
import org.seven.wonders.game.Game;
import org.seven.wonders.leaders.Leader;
import org.seven.wonders.leaders.LeadersFactory;

public class TestAgeSubprocess extends AbstractTest {

  private Game game = Game.processParameters(false, false, false, false, false, false);

  public TestAgeSubprocess() {
    super("age-sub");
  }

  @Before
  @Override
  public void startProcess() {
    this.runtimeService = this.activitiRule.getRuntimeService();
    this.game.random(3);
    this.game.currentPlayer().getWonder().getProduces().add(6);
    List<Leader> leaders = LeadersFactory.getLeaders(3, true);
    for (Leader leader : leaders) {
      this.game.nextPlayer().getLeaders().add(leader);
    }
  }

  @Test(expected = StackOverflowError.class)
  @Deployment(resources = { "diagrams/Age.bpmn", "diagrams/PlayLeaderSub.bpmn", "diagrams/ChooseCard.bpmn",
      "diagrams/CheckCanBuild.bpmn" })
  public void testBuyLeader() {
    Map<String, Object> variableMap = new HashMap<String, Object>();
    variableMap.put("game", this.game);
    variableMap.put("input", 1);
    ProcessInstance processInstance = this.runtimeService.startProcessInstanceByKey(this.name, variableMap);

    assertTrue(processInstance instanceof VariableScope);
    assertEquals(this.game, ((VariableScope)processInstance).getVariable("game"));
    // 1 leader used
    assertNotNull(this.game.currentPlayer().getLeaders());
    assertEquals(3, this.game.currentPlayer().getLeaders().size());
    assertEquals(1, this.game.currentPlayer().getHand().size());
  }

}
