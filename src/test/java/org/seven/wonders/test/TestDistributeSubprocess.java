package org.seven.wonders.test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.delegate.VariableScope;
import org.activiti.engine.test.Deployment;
import org.junit.Before;
import org.junit.Test;
import org.seven.wonders.cards.Card;
import org.seven.wonders.cards.CardsFactory;
import org.seven.wonders.game.Game;

public class TestDistributeSubprocess extends AbstractTest {

  private Game game = Game.processParameters(false, false, false, false, true, false);

  private List<Card> cards = CardsFactory.getCards(1, 3, false);

  public TestDistributeSubprocess() {
    super("distribute");
  }

  @Before
  @Override
  public void startProcess() {
    this.runtimeService = this.activitiRule.getRuntimeService();
    this.game.random(3);
  }

  @Test
  @Deployment(resources = { "diagrams/Distribute.bpmn" })
  public void testDistributeProcess() {
    Map<String, Object> variableMap = new HashMap<String, Object>();
    variableMap.put("game", this.game);
    variableMap.put("cards", this.cards);
    this.processInstance = this.runtimeService.startProcessInstanceByKey(this.name, variableMap);
    assertTrue(this.processInstance instanceof VariableScope);
    assertEquals(this.game, ((VariableScope)this.processInstance).getVariable("game"));
    assertEquals(7, this.game.currentPlayer().getHand().size());
  }
}
