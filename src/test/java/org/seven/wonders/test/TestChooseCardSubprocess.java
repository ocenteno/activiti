package org.seven.wonders.test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.delegate.VariableScope;
import org.activiti.engine.impl.test.JobTestHelper;
import org.activiti.engine.test.Deployment;
import org.junit.Before;
import org.junit.Test;
import org.seven.wonders.cards.Card;
import org.seven.wonders.cards.CardsFactory;
import org.seven.wonders.game.Game;
import org.seven.wonders.game.Player;
import org.seven.wonders.game.Player.Action;

public class TestChooseCardSubprocess extends AbstractTest {

  private Game game = Game.processParameters(false, false, false, false, true, false);

  private Player player;

  public TestChooseCardSubprocess() {
    super("choose-a-card");
  }

  @Before
  @Override
  public void startProcess() {
    this.runtimeService = this.activitiRule.getRuntimeService();
    this.game.random(3);
    this.player = this.game.currentPlayer();
  }

  @Test
  @Deployment(resources = { "diagrams/ChooseCard.bpmn", "diagrams/CheckCanBuild.bpmn" })
  public void testChooseCardBuildable() {
    this.player.setHand(CardsFactory.getCardsAgeI(1, true));
    Map<String, Object> variableMap = new HashMap<String, Object>();
    variableMap.put("current", this.player);
    variableMap.put("leadersDraft", false);
    this.processInstance = this.runtimeService.startProcessInstanceByKey(this.name, variableMap);

    JobTestHelper.waitForJobExecutorToProcessAllJobs(this.activitiRule, 10000L, 25L);

    assertTrue(this.processInstance instanceof VariableScope);
    assertEquals(this.player, ((VariableScope)this.processInstance).getVariable("current"));
    // Card chosen
    assertNotNull(this.player.getCardToPlay());
    assertEquals(Action.BUILD, this.player.getActionToPlay());
    assertEquals(7, this.player.getHand().size());
  }

  @Test
  @Deployment(resources = { "diagrams/ChooseCard.bpmn", "diagrams/CheckCanBuild.bpmn" })
  public void testChooseCardNotBuildableToSell() {
    List<Card> ageIII = CardsFactory.getCardsAgeIII(3, true);
    for (Card card : ageIII) {
      this.game.nextPlayer().add(card);
    }
    Map<String, Object> variableMap = new HashMap<String, Object>();
    variableMap.put("game", this.game);
    variableMap.put("current", this.player);
    variableMap.put("leadersDraft", false);
    this.processInstance = this.runtimeService.startProcessInstanceByKey(this.name, variableMap);

    JobTestHelper.waitForJobExecutorToProcessAllJobs(this.activitiRule, 10000L, 25L);

    assertTrue(this.processInstance instanceof VariableScope);
    assertEquals(this.player, ((VariableScope)this.processInstance).getVariable("current"));
    // Card chosen
    assertNotNull(this.player.getCardToPlay());
    assertEquals(Action.SELL, this.player.getActionToPlay());
    assertEquals(7, this.player.getHand().size());
  }

}
