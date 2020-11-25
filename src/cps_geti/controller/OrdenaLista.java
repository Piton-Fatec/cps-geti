package cps_geti.controller;

import cps_geti.model.ListaCandidato;
import cps_geti.controller.GerenciamentoCandidato;
import cps_geti.model.Candidato;


public class OrdenaLista {	
	
	public OrdenaLista() {
		super();
	}
	
	public ListaCandidato quickSort(ListaCandidato listaCandidatos) {
		/**
		 * recebe como parâmetro lista de alunos e atualiza a lista
		 * 
		 */
		if (listaCandidatos.getLength() <= 1) {
			System.out.println("lista de alunos vazia"); 
			return listaCandidatos;
		}		
		
		else {
			Candidato pivo = listaCandidatos.getLast();
			Candidato first = listaCandidatos.getfirst();
			int teste;
			
			ListaCandidato less = new ListaCandidato();
			ListaCandidato equal = new ListaCandidato();
			ListaCandidato bigger = new ListaCandidato();
			
			for (int i = 0; i < listaCandidatos.getLength(); i ++) {
				teste = first.getNome().compareTo(pivo.getNome());
				if (teste < 0) {
					Candidato aux = new Candidato(first.getNome(),first.getEmail(),first.getCPF(),first.getCEP(),first.getSituacao());
					less.addBack(aux);
					first = first.getNext();
				}
				else if (teste == 0) {
					Candidato aux = new Candidato(first.getNome(),first.getEmail(),first.getCPF(),first.getCEP(),first.getSituacao());
					equal.addBack(aux);
					first = first.getNext();
				}
				else {
					Candidato aux = new Candidato(first.getNome(),first.getEmail(),first.getCPF(),first.getCEP(),first.getSituacao());
					bigger.addBack(aux);
					first = first.getNext();
				}
				
			}
			
			if (less.isTrue()) {
				if (less.getLength() > 1) {
					less = quickSort(less);
				}
			}
			
			if (bigger.isTrue()) {
				if (bigger.getLength() > 1) {
					bigger = quickSort(bigger);
				}
			}
			
			return concatena(less, equal, bigger);			
			
		}
	}
	private ListaCandidato concatena(ListaCandidato menor,ListaCandidato igual,ListaCandidato maior) {
		
		ListaCandidato aux = new ListaCandidato();
		Candidato aux2;
		
		if (menor.isTrue()) {
			aux2 = menor.getfirst();
			while (aux2 != null) {
				aux.addBack(aux2);
				aux2 = aux2.getNext();
			}
		}
		
		aux2 = igual.getfirst();
		while (aux2 != null) {
			aux.addBack(aux2);
			aux2 = aux2.getNext();
		}
		
		if (maior.isTrue()) {
			aux2 = maior.getfirst();
			while (aux2 != null) {
				aux.addBack(aux2);
				aux2 = aux2.getNext();
			}
		}
		
		return aux;
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
