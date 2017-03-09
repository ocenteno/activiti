package org.seven.wonders.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.activiti.engine.HistoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.test.ActivitiRule;
import org.junit.Before;
import org.junit.Rule;

public class AbstractTest {

  @Rule
  public ActivitiRule activitiRule = new ActivitiRule();

  protected ProcessInstance processInstance;

  protected RuntimeService runtimeService;

  protected String name;

  public AbstractTest(String name) {
    this.name = name;
  }

  @Before
  public void startProcess() {
    this.runtimeService = this.activitiRule.getRuntimeService();
    Map<String, Object> variableMap = new HashMap<String, Object>();
    variableMap.put("initiator", "TestUser");
    this.processInstance = this.runtimeService.startProcessInstanceByKey(this.name, variableMap);
  }

  protected void testData(TaskService taskService, Task formulario) {
    Map<String, Object> variableMap = new HashMap<String, Object>();
    variableMap.put("numPlayers", new Random(System.currentTimeMillis()).nextInt(5) + 3);
    variableMap.put("leaders", false);
    variableMap.put("cities", true);
    variableMap.put("babel", false);
    variableMap.put("projects", false);
    variableMap.put("thrones", true);
    variableMap.put("teams", false);
    taskService.claim(formulario.getId(), "TestUser");
    taskService.complete(formulario.getId(), variableMap);
  }

  protected void updateProcessInstance() {
    this.processInstance =
        this.runtimeService.createProcessInstanceQuery().processInstanceId(this.processInstance.getId()).singleResult();
  }

  protected HistoricProcessInstance getHistoricProcessInstance() {
    HistoryService historyService = this.activitiRule.getHistoryService();
    HistoricProcessInstance historicProcessInstance =
        historyService.createHistoricProcessInstanceQuery().processInstanceId(this.processInstance.getId())
            .singleResult();
    return historicProcessInstance;
  }

}
