package br.com.esig.taskmanager.enums;

public enum Prioridades{
	BAIXA("Baixa"),
	MEDIA("Média"),
	ALTA("Alta");
	
	private String description;
	
	Prioridades(String description){
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
}