package cps_geti.model;

public class Candidato {
	
	private String nome;
	private String email;
	private String dataNascimento;
	private String CPF;
	private String RG;
	private String CEP;
	public Candidato proximo;
	public Candidato anterior;
	
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
	
	public String getDataNascimento() {
		return this.dataNascimento;
	}
	
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public String getCPF() {
		return this.CPF;
	}
	
	public void setCPF(String CPF) {
		this.CPF = CPF;
	}
	
	public String getRG() {
		return this.RG;
	}
	
	public void setRG(String RG) {
		this.RG = RG;
	}
	
	public String getCEP() {
		return this.CEP;
	}
	
	public void setCEP(String CEP) {
		this.CEP = CEP;
	}
}
