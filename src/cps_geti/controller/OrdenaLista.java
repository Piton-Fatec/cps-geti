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
		 * recebe como par�metro lista de alunos e atualiza a lista
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
			System.out.println("Exceção não tratada [findPivo 1]" + e.getStackTrace());
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
			System.out.println("Exceção não tratada [findPivo 2]" + e.getStackTrace());
			return null;
		}
	}
	
	public void mergeSort(ListaCandidato candidatos) {
		int size = candidatos.getLength();
		
		if (size < 2) {
			return;
		}
		
		ListaCandidato arr1 = new ListaCandidato();
		ListaCandidato arr2 = new ListaCandidato();
		int i = 0;
		
		while (i < size/2) {
			arr1.addBack(candidatos.removeFront());
			i++;
		}
		
		Candidato current = candidatos.removeFront();
		while (current != null) {
			arr2.addBack(current);
			current = candidatos.removeFront();
		}
		
		mergeSort(arr1);
		mergeSort(arr2);
		merge(arr1, arr2, candidatos);
	}
	
	public void merge(ListaCandidato arr1, ListaCandidato arr2, ListaCandidato candidatos) {
		Candidato current1 = arr1.removeFront();
		Candidato current2 = arr2.removeFront();
		
		while (current1 != null && current2 != null) {
			if (current1.getCPF().compareTo(current2.getCPF()) <= 0) {
				candidatos.addBack(current1);
				current1 = arr1.removeFront();
			} else {
				candidatos.addBack(current2);
				current2 = arr2.removeFront();
			}
		}

		while(current1 != null) {
			candidatos.addBack(current1);
			current1 = arr1.removeFront();
		}
		while(current2 != null) {
			candidatos.addBack(current2);
			current2 = arr2.removeFront();
		}
	}
	
}
