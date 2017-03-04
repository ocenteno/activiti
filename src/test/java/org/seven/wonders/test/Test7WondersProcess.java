package org.seven.wonders.test;

import static org.junit.Assert.*;

import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.activiti.engine.test.Deployment;
import org.junit.Test;

public class Test7WondersProcess extends AbstractTest {

  public Test7WondersProcess() {
    super("simulador7wonders");
  }

  @Test
  @Deployment(resources = { "diagrams/7 Wonders.bpmn", "diagrams/Initialize.bpmn", "diagrams/Distribute.bpmn",
      "diagrams/Prepare.bpmn", "diagrams/Age.bpmn", "diagrams/ChooseCard.bpmn", "diagrams/CheckCanBuild.bpmn" })
  public void testInicializar() {
    TaskService taskService = this.activitiRule.getTaskService();
    Task form = taskService.createTaskQuery().taskDefinitionKey(this.processInstance.getActivityId()).singleResult();
    assertEquals("Init Form", form.getName());

    testData(taskService, form);
    updateProcessInstance();
  }
}
