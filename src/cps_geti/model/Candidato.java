package cps_geti.model;

public class Candidato {
	
	private String nome;
	private String email;
	private String CPF;
	private String CEP;
	
	public Candidato next;
	public Candidato previous;
	
	public Candidato(String nome, String email, String cpf, String cep) {
		this.nome = nome;
		this.email = email;
		this.CPF = cpf;
		this.CEP = cep;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getEmail() {
		return this.email;
	}

	public String getCPF() {
		return this.CPF;
	}
	
	public String getCEP() {
		return this.CEP;
	}
	
	public void setNext(Candidato candidato) {
		this.next = candidato;
	}
	
	public Candidato getNext() {
		return this.next;
	}
	
	public void setPrevious(Candidato candidato) {
		this.previous = candidato;
	}
	
	public Candidato getPrevious() {
		return this.previous;
	}
	
	@Override
	public String toString() {
		return this.nome + "," + this.email + "," + this.CPF + "," + this.CEP;
	}
	
}
