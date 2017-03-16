package org.seven.wonders.test;

import static org.junit.Assert.*;

import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.activiti.engine.test.Deployment;
import org.junit.Test;

public class Test7WondersSimplifiedProcess extends AbstractTest {

  public Test7WondersSimplifiedProcess() {
    super("seven-wonders-simulator");
  }

  @Test
  @Deployment(resources = { "diagrams/7Wonders.bpmn", "diagrams/Initialize.bpmn", "diagrams/Prepare.bpmn",
  "diagrams/AgeDelegate.bpmn" })
  public void testInicializar() {
    TaskService taskService = this.activitiRule.getTaskService();
    Task form = taskService.createTaskQuery().taskDefinitionKey(this.processInstance.getActivityId()).singleResult();
    assertEquals("Init Form", form.getName());

    testData(taskService, form);
    updateProcessInstance();
  }
}
