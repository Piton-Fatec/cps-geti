package cps_geti.lista_duplamente_encadeada;
import cps_geti.candidato.Candidato;

public class ListaCandidato {

	public Candidato inicio;
	public Candidato fim;
	int tamanho;

	public void inserirInicio(String nome, String RG, String CPF, 
			String dataNascimento, String email, String CEP) {

		Candidato candidato = new Candidato();
		candidato.setNome(nome);
		candidato.setRG(RG);
		candidato.setCPF(CPF);
		candidato.setDataNascimento(dataNascimento);
		candidato.setEmail(email);
		candidato.setCEP(CEP);
		candidato.anterior = null;
		candidato.proximo = inicio;
		if (inicio != null) {
			inicio.anterior = candidato;
		}
		inicio = candidato;
		if (tamanho == 0) {
			fim = inicio;
		}
		tamanho++;
	}

	public Candidato removerInicio() {

		if (inicio == null) {
			return null;
		}
		Candidato out = inicio;
		inicio = inicio.proximo;
		if (inicio != null) {
			inicio.anterior = null;
		}
		else {
			fim = null;
		}
		tamanho--;
		return out;
	}

	public void inserirFim(String nome, String RG, String CPF, 
			String dataNascimento, String email, String CEP) {

		Candidato candidato = new Candidato();
		candidato.setNome(nome);
		candidato.setRG(RG);
		candidato.setCPF(CPF);
		candidato.setDataNascimento(dataNascimento);
		candidato.setEmail(email);
		candidato.setCEP(CEP);
		candidato.proximo = null;
		candidato.anterior = fim;
		if (fim != null) {
			fim.proximo = candidato;
		}
		fim = candidato;
		if (tamanho == 0) {
			inicio = fim;
		}
		tamanho++;
	}

	public Candidato removerFim() {

		if (fim == null) {
			return null;
		}
		Candidato out = fim;
		fim = fim.anterior;
		if (fim != null) {
			fim.proximo = null;
		} else {
			inicio = null;
		}
		tamanho--;
		return out;
	}

	public void inserirMeio(int indice, String nome, String RG, String CPF, 
			String dataNascimento, String email, String CEP) {

		if (indice <= 0) {
			inserirInicio(nome, RG, CPF, dataNascimento, email, CEP);
		}
		else if (indice >= tamanho) {
			inserirFim(nome, RG, CPF, dataNascimento, email, CEP);
		} else {
			Candidato local = inicio;
			for (int i = 0; i < indice - 1;i++) {
				local = local.proximo;
			}
			Candidato candidato = new Candidato();
			candidato.setNome(nome);
			candidato.setRG(RG);
			candidato.setCPF(CPF);
			candidato.setDataNascimento(dataNascimento);
			candidato.setEmail(email);
			candidato.setCEP(CEP);
			candidato.anterior = local;
			candidato.proximo = local.proximo;
			local.proximo = candidato;
			candidato.proximo.anterior = candidato;
			tamanho++;
		}

	}

	public Candidato removerMeio(int indice) {
		
		if (indice < 0 || indice >= tamanho || inicio == null) {
			return null;
		}
		else if (indice == 0) {
			return removerInicio();
		}
		else if (indice ==  tamanho -1) {
			return removerFim();
		}
		Candidato local = inicio;
		for (int i = 0; i < indice; i++) {
			local = local.proximo;
		}
		if (local.anterior != null) {
			local.anterior.proximo = local.proximo;
		}
		if (local.proximo != null) {
			local.proximo.anterior = local.anterior;
		}
		tamanho--;
		return local;
	}
	
	public String toString() {
		
		String str = "(" + tamanho + ") ";
		Candidato local = inicio;
		while (local != null) {
			str += local.getNome() + ", " + local.getRG() + ", " + local.getCPF()
			+ ", " + local.getDataNascimento() + ", " + local.getEmail() + ", " +
					local.getCEP();
			local = local.proximo;
					
		}
		return str;
	}
}
