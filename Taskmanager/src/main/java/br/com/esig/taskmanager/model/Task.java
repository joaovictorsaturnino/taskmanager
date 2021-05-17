package br.com.esig.taskmanager.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "task")
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(length = 30)
	private String titulo;
	
	@Column(length = 100)
	private String descricao;
	
	@Column(length = 50)
	private String responsavel;
	
	@Column(length = 15)
	private String prioridade;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date deadline;
	
	//Caso a tarefa esteja em andamento, recebe valor 1, caso contrário, 0.
	@Column(name = "em_andamento")
	private Integer emAndamento;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public String getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public Integer getEmAndamento() {
		return emAndamento;
	}

	public void setEmAndamento(Integer emAndamento) {
		this.emAndamento = emAndamento;
	}

}
