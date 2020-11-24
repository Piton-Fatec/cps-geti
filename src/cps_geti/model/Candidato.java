package cps_geti.model;

public class Candidato {
	
	private String nome;
	private String email;
	private String CPF;
	private String CEP;
	private String situacao;
	
	public Candidato next;
	public Candidato previous;
	
	public Candidato(String nome, String email, String cpf, String cep, String situacao) {
		this.nome = nome;
		this.email = email;
		this.CPF = cpf;
		this.CEP = cep;
		this.situacao = situacao;
	}
	
	public Candidato() {
		
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getCPF() {
		return this.CPF;
	}
	
	public void setCPF(String cpf) {
		this.CPF = cpf;
	}
	
	public String getCEP() {
		return this.CEP;
	}
	
	public void setCEP(String cep) {
		this.CEP = cep;
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
	
	public String getSituacao() {
		return this.situacao;
	}
	
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	
	@Override
	public String toString() {
		return this.nome + "," + this.email + "," + this.CPF + "," + this.CEP + "," + this.situacao;
	}
	
}
