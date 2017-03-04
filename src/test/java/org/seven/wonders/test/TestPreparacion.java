package org.seven.wonders.test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.ActivitiException;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.test.Deployment;
import org.seven.wonders.game.Game;

public class TestPreparacion extends AbstractTest {

  private Game game = Game.processParameters(false, false, false, false, true, false);

  public TestPreparacion() {
    super("preparacion");
  }

  @Deployment(resources = { "diagrams/Preparacion.bpmn" })
  public void preparar() throws Exception {
    try {
      TaskService taskService = this.activitiRule.getTaskService();
      Task formulario =
          taskService.createTaskQuery().taskDefinitionKey(this.processInstance.getActivityId()).singleResult();
      assertEquals("coger-monedas", formulario.getName());
      Map<String, Object> variableMap = new HashMap<String, Object>();
      variableMap.put("game", this.game);
      ProcessInstance processInstance = this.runtimeService.startProcessInstanceByKey("preparacion", variableMap);
      assertNotNull(processInstance.getId());
      System.out.println("id " + processInstance.getId() + " " + processInstance.getProcessDefinitionId());
    } catch (ActivitiException ex) {
      fail("No exception expected");
    }
  }
}
