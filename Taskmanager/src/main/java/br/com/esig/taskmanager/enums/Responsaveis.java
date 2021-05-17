package br.com.esig.taskmanager.enums;

public enum Responsaveis {
	JOAO("João Victor"),
	GILBERTO("Gilberto"),
	MARIA("Maria Geovanna"),
	CLAUDIANE("Claudiane"),
	GERALDO("Geraldo"),
	INACIA("Inácia"),
	MONALIZA("Monaliza");
	
	private String description;
	
	Responsaveis(String description){
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
}
