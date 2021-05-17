package br.com.esig.taskmanager.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import br.com.esig.taskmanager.dao.TaskDAO;
import br.com.esig.taskmanager.enums.Prioridades;
import br.com.esig.taskmanager.enums.Responsaveis;
import br.com.esig.taskmanager.model.Task;

@ManagedBean
@ViewScoped
public class TaskBean implements Serializable {
	
	private Task task;
	private List<Task> tasks;
	
	
	public TaskBean() {
		task = new Task();
	}
	
	public void newTask() {
		task = new Task();
	}
	
	public Prioridades[] getPrioridades() {
		return Prioridades.values();
	}
	
	public Responsaveis[] getResponsaveis() {
		return Responsaveis.values();
	}
	
	
	@PostConstruct
	public void list() {
		try {
			TaskDAO taskDAO = new TaskDAO();
			tasks = taskDAO.list();
			
		} catch(RuntimeException e) {
			e.printStackTrace();
		}
	}
	
	public void save(){
		try {
			TaskDAO taskDAO= new TaskDAO();
			task.setEmAndamento(1);
			taskDAO.merge(task);
			showSuccessMessage();
			
			newTask();
			tasks = taskDAO.list();
		} catch (RuntimeException e) {
			showErrorMessage();
			e.printStackTrace();
		}
	}
	
	public void delete(ActionEvent event) {
		 
		try {
		task = (Task) event.getComponent().getAttributes().get("selectedTask");
		TaskDAO taskDAO = new TaskDAO();
		taskDAO.delete(task);
		
		tasks = taskDAO.list();
		showSuccessMessage();
		
		} catch (RuntimeException e) {
			showErrorMessage();
			e.printStackTrace();
		}
		
	}
	
	public void finish(ActionEvent event) {
		
		try {
			task = (Task) event.getComponent().getAttributes().get("selectedTask");
			TaskDAO taskDAO= new TaskDAO();
			task.setEmAndamento(0);
			taskDAO.merge(task);
			showSuccessMessage();
			
			newTask();
			tasks = taskDAO.list();
		} catch (RuntimeException e) {
			showErrorMessage();
			e.printStackTrace();
		}
	}
	
	public void search() {
		
		try {
			TaskDAO taskDAO = new TaskDAO();
			tasks = taskDAO.search(task.getId(), task.getTitulo(), task.getDescricao(), task.getResponsavel(), task.getEmAndamento());
		} catch(RuntimeException e) {
			showErrorMessage();
			e.printStackTrace();
		}
	}
	
	public void edit(ActionEvent event) {
		task = (Task) event.getComponent().getAttributes().get("selectedTask");
		
	}
	
	public void view(ActionEvent event) {
		task = (Task) event.getComponent().getAttributes().get("selectedTask");
	}

	public void showErrorMessage() {
		String msg = "Erro ao realizar a operação";
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, message);
	}
	
	public void showSuccessMessage() {
		String msg = "Operação realizada com sucesso";
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, message);
	}
	
	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	
	
	
}
