package org.seven.wonders.test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.delegate.VariableScope;
import org.activiti.engine.test.Deployment;
import org.junit.Before;
import org.junit.Test;
import org.seven.wonders.game.Game;
import org.seven.wonders.game.Player;
import org.seven.wonders.game.Player.Action;
import org.seven.wonders.leaders.Leader;
import org.seven.wonders.leaders.LeadersFactory;

public class TestPlayLeaderDelegate extends AbstractTest {

  private Game game = Game.processParameters(false, false, false, false, true, false);

  private Player player;

  public TestPlayLeaderDelegate() {
    super("play-leader");
  }

  @Before
  @Override
  public void startProcess() {
    this.runtimeService = this.activitiRule.getRuntimeService();
    this.game.random(3);
    this.player = this.game.currentPlayer();
    this.player.getLeaders().addAll(LeadersFactory.getLeaders(1, true));
  }

  @Test
  @Deployment(resources = { "diagrams/PlayLeaderDelegate.bpmn" })
  public void testPlayAnyLeader() {
    this.player.giveCoins(6);
    Map<String, Object> variableMap = new HashMap<String, Object>();
    variableMap.put("current", this.player);
    variableMap.put("game", this.game);
    this.processInstance = this.runtimeService.startProcessInstanceByKey(this.name, variableMap);

    assertTrue(this.processInstance instanceof VariableScope);
    assertEquals(this.player, ((VariableScope)this.processInstance).getVariable("current"));
    // Leaders chosen
    assertNotNull(this.player.getLeaders());
    assertEquals(3, this.player.getLeaders().size());
    assertEquals(0, this.player.getHand().size());
    assertTrue(this.player.getCardToPlay() instanceof Leader);
    assertEquals(Action.BUILD, this.player.getActionToPlay());
  }

  @Test
  @Deployment(resources = { "diagrams/PlayLeaderDelegate.bpmn" })
  public void testSellAnyLeader() {
    Map<String, Object> variableMap = new HashMap<String, Object>();
    variableMap.put("current", this.player);
    variableMap.put("game", this.game);
    this.processInstance = this.runtimeService.startProcessInstanceByKey(this.name, variableMap);

    assertTrue(this.processInstance instanceof VariableScope);
    assertEquals(this.player, ((VariableScope)this.processInstance).getVariable("current"));
    // Leaders chosen
    assertNotNull(this.player.getLeaders());
    assertEquals(3, this.player.getLeaders().size());
    assertEquals(0, this.player.getHand().size());
    assertTrue(this.player.getCardToPlay() instanceof Leader);
    assertEquals(Action.SELL, this.player.getActionToPlay());
  }

}
