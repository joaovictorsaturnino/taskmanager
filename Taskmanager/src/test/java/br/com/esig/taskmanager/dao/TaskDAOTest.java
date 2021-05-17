package br.com.esig.taskmanager.dao;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import br.com.esig.taskmanager.enums.Prioridades;
import br.com.esig.taskmanager.enums.Responsaveis;
import br.com.esig.taskmanager.model.Task;

public class TaskDAOTest {
	
	@Test
	@Ignore
	public void save(){
		Task task = new Task();
		task.setTitulo("Tarefa teste");
		task.setDescricao("Descrição da tarefa teste");
		task.setPrioridade(Prioridades.BAIXA.getDescription());
		task.setResponsavel(Responsaveis.JOAO.getDescription());
		task.setDeadline(new Date());

		
		TaskDAO taskDAO = new TaskDAO();
		taskDAO.save(task);
		
		Task taskMock = mockObject();
		List <Task> result = taskDAO.list();
		Assert.assertEquals(taskMock.getDescricao(), result.get(0).getDescricao());
		
	}
	
	@Test
	@Ignore
	public void list() {
		TaskDAO taskDAO = new TaskDAO();
		
		Task taskMock = mockObject();
		taskDAO.save(taskMock);
		
		List<Task> result = taskDAO.list();
		Assert.assertEquals(taskMock.getTitulo(), result.get(0).getTitulo());
	}
	
	@Test
	@Ignore
	public void search() {
		TaskDAO taskDAO = new TaskDAO();
		Task task1 = new Task();
		task1.setTitulo("Tarefa teste");
		task1.setDescricao("Descrição da tarefa teste");
		task1.setPrioridade(Prioridades.BAIXA.getDescription());
		task1.setResponsavel(Responsaveis.JOAO.getDescription());
		task1.setDeadline(new Date());
		taskDAO.save(task1);
		
		Task task2 = new Task();
		task2.setTitulo("Tarefa teste 2");
		task2.setDescricao("Descrição da tarefa teste 2");
		task2.setPrioridade(Prioridades.MEDIA.getDescription());
		task2.setResponsavel(Responsaveis.MARIA.getDescription());
		task2.setDeadline(new Date());
		taskDAO.save(task2);
		
		List <Task> result2 = taskDAO.search(null, "Tarefa teste 2", "", "", null);
		Assert.assertEquals(task2.getTitulo(), result2.get(0).getTitulo());
		
		
	}
	
	@Test
	@Ignore
	public void delete() {
		TaskDAO taskDAO = new TaskDAO();
		Task task1 = new Task();
		task1.setTitulo("Tarefa teste");
		task1.setDescricao("Descrição da tarefa teste");
		task1.setPrioridade(Prioridades.BAIXA.getDescription());
		task1.setResponsavel(Responsaveis.JOAO.getDescription());
		task1.setDeadline(new Date());
		
		taskDAO.save(task1);
		taskDAO.delete(task1);
		
		List <Task> result = taskDAO.search(1, "", "", "", null);
		
		Assert.assertTrue(result.size() == 0);
		
	}
	
	@Test
	@Ignore
	public void update() {
		TaskDAO taskDAO = new TaskDAO();
		Task task1 = new Task();
		task1.setTitulo("Tarefa teste");
		task1.setDescricao("Descrição da tarefa teste");
		task1.setPrioridade(Prioridades.BAIXA.getDescription());
		task1.setResponsavel(Responsaveis.JOAO.getDescription());
		task1.setDeadline(new Date());
		
		taskDAO.save(task1);
		
		task1.setTitulo("Tarefa teste 2");
		task1.setDescricao("Descrição da tarefa teste 2");
		task1.setPrioridade(Prioridades.MEDIA.getDescription());
		task1.setResponsavel(Responsaveis.MARIA.getDescription());
		task1.setDeadline(new Date());
	
		taskDAO.update(task1);
		List <Task> result = taskDAO.search(null, "", "", "Maria Geovanna", null);
		Assert.assertTrue(Prioridades.MEDIA.getDescription().equals(result.get(0).getPrioridade()));
	}
	
	
	public Task mockObject() {
		Task task = new Task();
		task.setTitulo("Tarefa teste");
		task.setDescricao("Descrição da tarefa teste");
		task.setPrioridade(Prioridades.BAIXA.getDescription());
		task.setResponsavel(Responsaveis.JOAO.getDescription());
		task.setDeadline(new Date());
		
		return task;
	}
}
