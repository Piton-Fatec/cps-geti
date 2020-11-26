package cps_geti.controller;

import cps_geti.model.ApplicantList;
import cps_geti.model.Applicant;


public class Sorting {	
	
	public Sorting() {
		super();
	}
	
	public ApplicantList quickSort(ApplicantList applicantList) {
		if (applicantList.getLength() <= 1) {
			System.out.println("lista de alunos vazia"); 
			return applicantList;
		}		
		
		else {
			Applicant pivo = applicantList.getLast();
			Applicant first = applicantList.getfirst();
			int test;
			
			ApplicantList less = new ApplicantList();
			ApplicantList equal = new ApplicantList();
			ApplicantList bigger = new ApplicantList();
			
			for (int i = 0; i < applicantList.getLength(); i ++) {
				test = first.getName().compareTo(pivo.getName());
				if (test < 0) {
					Applicant aux = new Applicant(first.getName(),first.getEmail(),first.getCPF(),first.getCEP(),first.getStatus());
					less.addBack(aux);
					first = first.getNext();
				}
				else if (test == 0) {
					Applicant aux = new Applicant(first.getName(),first.getEmail(),first.getCPF(),first.getCEP(),first.getStatus());
					equal.addBack(aux);
					first = first.getNext();
				}
				else {
					Applicant aux = new Applicant(first.getName(),first.getEmail(),first.getCPF(),first.getCEP(),first.getStatus());
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
			
			return concatenate(less, equal, bigger);			
			
		}
	}
	private ApplicantList concatenate(ApplicantList less, ApplicantList equal, ApplicantList greater) {
		
		ApplicantList aux = new ApplicantList();
		Applicant aux2;
		
		if (less.isTrue()) {
			aux2 = less.getfirst();
			while (aux2 != null) {
				aux.addBack(aux2);
				aux2 = aux2.getNext();
			}
		}
		
		aux2 = equal.getfirst();
		while (aux2 != null) {
			aux.addBack(aux2);
			aux2 = aux2.getNext();
		}
		
		if (greater.isTrue()) {
			aux2 = greater.getfirst();
			while (aux2 != null) {
				aux.addBack(aux2);
				aux2 = aux2.getNext();
			}
		}
		return aux;
	}		

	
	public void mergeSort(ApplicantList applicants) {
		int size = applicants.getLength();
		
		if (size < 2) {
			return;
		}
		
		ApplicantList arr1 = new ApplicantList();
		ApplicantList arr2 = new ApplicantList();
		int i = 0;
		
		while (i < size/2) {
			arr1.addBack(applicants.removeFront());
			i++;
		}
		
		Applicant current = applicants.removeFront();
		while (current != null) {
			arr2.addBack(current);
			current = applicants.removeFront();
		}
		
		mergeSort(arr1);
		mergeSort(arr2);
		merge(arr1, arr2, applicants);
	}

	
	public void merge(ApplicantList arr1, ApplicantList arr2, ApplicantList applicants) {
		Applicant current1 = arr1.removeFront();
		Applicant current2 = arr2.removeFront();
		
		while (current1 != null && current2 != null) {
			if (current1.getCPF().compareTo(current2.getCPF()) <= 0) {
				applicants.addBack(current1);
				current1 = arr1.removeFront();
			} else {
				applicants.addBack(current2);
				current2 = arr2.removeFront();
			}
		}

		while(current1 != null) {
			applicants.addBack(current1);
			current1 = arr1.removeFront();
		}
		while(current2 != null) {
			applicants.addBack(current2);
			current2 = arr2.removeFront();
		}
	}
	
}
