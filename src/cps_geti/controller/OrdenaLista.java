package cps_geti.controller;

import cps_geti.model.ListaCandidato;
import cps_geti.controller.GerenciamentoCandidato;
import cps_geti.model.Candidato;

public class OrdenaLista {
	
	private ListaCandidato listaDesordenada;	
	
	
	public OrdenaLista() {
		super();
	}
	
	public ListaCandidato quickSort(ListaCandidato listaCandidatos) {
		if (listaCandidatos == null) {
			System.out.println("lista de alunos vazia"); return null;
		}		
		
		this.listaDesordenada = listaCandidatos;	
		return quickSort(listaCandidatos, "centro");
	}
	
	
	private ListaCandidato quickSort(ListaCandidato listaCandidatos, String pivo) {
		try {
			
			Candidato elementoPivo = findPivo(listaCandidatos, pivo);
			
			
			if (listaCandidatos.getLength() <= 1) {
				return listaCandidatos;
			}
			
			else{
				ListaCandidatos menor = listaMenor(listaCandidatos, pivo);
				ListaCandidatos igual = listaIgual(listaCandidatos, pivo);
				ListaCandidatos maior = listaMaior(listaCandidatos, pivo);
				
				return concatena(menor+igual+maior);								
			}			
			
		} catch (Exception e) {
			System.out.println("Exceção não tratada [ListaCandidato.QuickSort]" + e.getStackTrace());
			return null;
		}
		
	}
	
	
	private Candidato findPivo(ListaCandidato listaCandidatos, String pivo) {
		/**
		 *  retorna primeiro elemento da lista, ultimo ou então chama o metodo findPivo para encontrar o elemento central
		 *  sendo essas as três opções de pivô - [inicio, centro, fim]
		 *  
		 */
		
		if (pivo.equals("inicio")) {
			return listaCandidatos.getfirst();
		}
		
		else if (pivo.equals("final")) {
			return listaCandidatos.getLast();
		}
		
		else {
			return findPivo(listaCandidatos.getfirst(),(listaCandidatos.getLength()/2), 0);
		}		
	}
	
	
	private Candidato findPivo(Candidato candidato, int pivo, int contador) {
		try {
			
			if (pivo < 1) {
				pivo = 0 ;
			}
			
			if (pivo == contador) {
				return candidato;
			}
			
			else {
				return findPivo(candidato.next, pivo, contador++);				
			}		
			
		} catch (Exception e) {
			System.out.println("exceção não tratada [findPivo]" + e.getStackTrace());
			return null;
		}
	}
	
	
	
	
	
	
	
	
	

}
