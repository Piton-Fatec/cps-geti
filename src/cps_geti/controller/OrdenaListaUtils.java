package cps_geti.controller;

import cps_geti.model.ListaCandidato;
import cps_geti.model.Candidato;


public class OrdenaListaUtils {
	
	public OrdenaListaUtils(){
		super();
	}
	

	public ListaCandidato listaMenorIgualMaior(ListaCandidato listaCandidatos, Candidato pivo) {
		
		ListaCandidato menor = new ListaCandidato();
		ListaCandidato igual = new ListaCandidato();
		ListaCandidato maior = new ListaCandidato();

		
		Candidato firstElement = listaCandidatos.getfirst();
		
		while (firstElement != null) {
			int aux = firstElement.getNome().compareTo(pivo.getNome());
			
			if (aux < 0) {menor.addBack(firstElement);}
			else if (aux == 0) {igual.addBack(firstElement);}
			else {maior.addBack(firstElement);}
			firstElement = firstElement.getNext();
		}
		
		ListaCandidato listaReturn = concatena(menor, igual, maior);	
		
		
		return listaReturn;
		
	}
	
	private ListaCandidato concatena(ListaCandidato menor,ListaCandidato igual,ListaCandidato maior) {
		
		ListaCandidato aux = new ListaCandidato();
		Candidato aux2 = menor.getfirst();
		
		while (aux2 != null) {
			aux.addBack(aux2);
			aux2 = aux2.next;
		}
		
		aux2 = igual.getfirst();
		while (aux2 != null) {
			aux.addBack(aux2);
			aux2 = aux2.next;
		}
		
		aux2 = maior.getfirst();
		while (aux2 != null) {
			aux.addBack(aux2);
			aux2 = aux2.next;
		}	
		
		return aux;
	}
}
