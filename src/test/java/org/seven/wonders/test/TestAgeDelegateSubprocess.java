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

public class TestAgeDelegateSubprocess extends AbstractTest {

  private Game game = Game.processParameters(false, true, false, false, true, false);

  public TestAgeDelegateSubprocess() {
    super("age");
  }

  @Before
  @Override
  public void startProcess() {
    this.game.random(3);
    this.game.currentPlayer().getWonder().getProduces().add(6);
    List<Leader> leaders = LeadersFactory.getLeaders(3, true);
    for (Leader leader : leaders) {
      this.game.nextPlayer().getLeaders().add(leader);
    }
    this.runtimeService = this.activitiRule.getRuntimeService();
  }

  @Test
  @Deployment(resources = { "diagrams/AgeDelegate.bpmn", "diagrams/PlayLeaderDelegate.bpmn" })
  public void testRunAge() {
    Map<String, Object> variableMap = new HashMap<String, Object>();
    variableMap.put("game", this.game);
    variableMap.put("input", 1);
    ProcessInstance processInstance = this.runtimeService.startProcessInstanceByKey(this.name, variableMap);

    assertTrue(processInstance instanceof VariableScope);
    assertEquals(this.game, ((VariableScope)processInstance).getVariable("game"));
    // 1 leader used
    assertEquals(3, this.game.currentPlayer().getLeaders().size());
    // all cards used
    assertEquals(0, this.game.currentPlayer().getHand().size());
    // 3 cards discarded minimum
    assertTrue(this.game.getDiscardedCards().size() >= 3);
    // no pending action
    assertNull(this.game.currentPlayer().getActionToPlay());
    assertNull(this.game.currentPlayer().getCardToPlay());
  }

}
