package org.seven.wonders.test;

import static org.junit.Assert.*;

import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.activiti.engine.test.Deployment;
import org.junit.Test;

public class Test7WondersProcess extends AbstractTest {

  public Test7WondersProcess() {
    super("simulator-7w-sub");
  }

  @Test(expected = StackOverflowError.class)
  @Deployment(resources = { "diagrams/7WondersSub.bpmn", "diagrams/Initialize.bpmn", "diagrams/Prepare.bpmn",
      "diagrams/Age.bpmn", "diagrams/PlayLeaderSub.bpmn", "diagrams/ChooseCard.bpmn", "diagrams/CheckCanBuild.bpmn" })
  public void testInicializar() {
    TaskService taskService = this.activitiRule.getTaskService();
    Task form = taskService.createTaskQuery().taskDefinitionKey(this.processInstance.getActivityId()).singleResult();
    assertEquals("Init Form", form.getName());

    testData(taskService, form);
    updateProcessInstance();
  }
}
