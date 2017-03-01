package org.seven.wonders.test;

import static org.junit.Assert.*;

import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.test.Deployment;
import org.junit.Test;

public class TestInicializar extends AbstractTest {
	
	public TestInicializar() {
		super("inicializar");
	}

	@Test
	@Deployment(resources = {"diagrams/Inicializacion.bpmn"})
	public void testProcess(){
		TaskService taskService = activitiRule.getTaskService();
		Task formulario = taskService.createTaskQuery()
				.taskDefinitionKey(processInstance.getActivityId())
				.singleResult();
		assertEquals("Formulario", formulario.getName());

		introducirConfiguracionPorDefecto(taskService, formulario);

		HistoricProcessInstance historicProcessInstance = getHistoricProcessInstance();
		assertNotNull(historicProcessInstance);
		
		updateProcessInstance();		
		assertNull(processInstance);
	}
}