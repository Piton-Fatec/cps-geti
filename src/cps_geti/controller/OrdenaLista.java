package cps_geti.controller;

import cps_geti.model.ListaCandidato;
import cps_geti.controller.GerenciamentoCandidato;
import cps_geti.model.Candidato;
import cps_geti.controller.OrdenaListaUtils;


public class OrdenaLista {	
	
	public OrdenaLista() {
		super();
	}
	
	
	public ListaCandidato quickSort(ListaCandidato listaCandidatos) {
		/**
		 * recebe como parâmetro lista de alunos e atualiza a lista
		 * 
		 */
		if (listaCandidatos == null) {
			System.out.println("lista de alunos vazia"); return null;
		}		
		
		return quickSort(listaCandidatos, "centro");
	}
	
	
	private ListaCandidato quickSort(ListaCandidato listaCandidatos, String pivo) {
		try {
			
			Candidato elementoPivo = findPivo(listaCandidatos, pivo);
			
			
			if (listaCandidatos.getLength() <= 1) {
				return listaCandidatos;
			}
			
			else{
				OrdenaListaUtils aux = new OrdenaListaUtils();
				ListaCandidato menor_igual_maior = aux.listaMenorIgualMaior(listaCandidatos, elementoPivo);	
				return menor_igual_maior;
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
		try {
			if (pivo.equals("inicio")) {
				return listaCandidatos.getfirst();
			}
		
			else if (pivo.equals("final")) {
				return listaCandidatos.getLast();
			}
		
			else {
				return findPivo(listaCandidatos.getfirst(),(listaCandidatos.getLength()/2), 0);
			}	
			
		} catch (Exception e) {
			System.out.println("exceção não tratada [findPivo 1]" + e.getStackTrace());
			return null;
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
			System.out.println("exceção não tratada [findPivo 2]" + e.getStackTrace());
			return null;
		}
	}		
}
