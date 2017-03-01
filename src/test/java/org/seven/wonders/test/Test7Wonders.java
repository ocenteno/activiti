package org.seven.wonders.test;

import static org.junit.Assert.*;

import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.activiti.engine.test.Deployment;
import org.junit.Test;

public class Test7Wonders extends AbstractTest {

  public Test7Wonders() {
    super("simulador7wonders");
  }

  @Test
  @Deployment(resources = { "diagrams/7 Wonders.bpmn", "diagrams/Inicializacion.bpmn", "diagrams/Repartir.bpmn",
      "diagrams/Preparacion.bpmn", "diagrams/Era.bpmn", "diagrams/Elegir.bpmn", "diagrams/CheckCanBuild.bpmn" })
  public void testInicializar() {
    TaskService taskService = this.activitiRule.getTaskService();
    Task formulario =
        taskService.createTaskQuery().taskDefinitionKey(this.processInstance.getActivityId()).singleResult();
    assertEquals("Formulario", formulario.getName());

    introducirConfiguracionPorDefecto(taskService, formulario);
    updateProcessInstance();
  }
}
