package cps_geti.model;

public class Applicant {
	
	private String name;
	private String email;
	private String CPF;
	private String CEP;
	private String status;
	
	public Applicant next;
	public Applicant previous;
	
	public Applicant(String name, String email, String cpf, String cep, String status) {
		this.name = name;
		this.email = email;
		this.CPF = cpf;
		this.CEP = cep;
		this.status = status;
	}
	
	public Applicant() {
		
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String nome) {
		this.name = nome;
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
	
	public void setNext(Applicant applicant) {
		this.next = applicant;
	}
	
	public Applicant getNext() {
		return this.next;
	}
	
	public void setPrevious(Applicant applicant) {
		this.previous = applicant;
	}
	
	public Applicant getPrevious() {
		return this.previous;
	}
	
	public String getStatus() {
		return this.status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return this.name + "," + this.email + "," + this.CPF + "," + this.CEP + "," + this.status;
	}
	
}
