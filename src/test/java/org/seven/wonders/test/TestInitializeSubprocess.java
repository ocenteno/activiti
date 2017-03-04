package org.seven.wonders.test;

import static org.junit.Assert.*;

import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.test.Deployment;
import org.junit.Test;

public class TestInitializeSubprocess extends AbstractTest {

  public TestInitializeSubprocess() {
    super("initialize");
  }

  @Test
  @Deployment(resources = { "diagrams/Initialize.bpmn" })
  public void testInitializeProcess() {
    TaskService taskService = this.activitiRule.getTaskService();
    Task form = taskService.createTaskQuery().taskDefinitionKey(this.processInstance.getActivityId()).singleResult();
    assertEquals("Init Form", form.getName());

    testData(taskService, form);

    HistoricProcessInstance historicProcessInstance = getHistoricProcessInstance();
    assertNotNull(historicProcessInstance);

    updateProcessInstance();
    assertNull(this.processInstance);
  }
}
