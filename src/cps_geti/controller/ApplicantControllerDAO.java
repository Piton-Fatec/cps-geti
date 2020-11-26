package cps_geti.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import cps_geti.model.ApplicantList;
import cps_geti.model.Applicant;

public class ApplicantControllerDAO {
	
	private static String FILE = "bd/applicants.txt";
	
	public static ApplicantList getApplicantList()  {
		ApplicantList applicants = new ApplicantList();
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(FILE)));
			String line = br.readLine();
			
			while (line != null) {
				Applicant applicant = new Applicant();
				String[] arr = line.split(",");
				applicant.setName(arr[0]);
				applicant.setEmail(arr[1]);
				applicant.setCPF(arr[2]);
				applicant.setCEP(arr[3]);
				applicant.setStatus(arr[4]);
				applicants.addBack(applicant);
				line = br.readLine();
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return applicants;
	}

	
	public boolean isValid(String name, String cpf) {
		ApplicantList applicantList = getApplicantList();
		
		if (applicantList.contains(name)) {
			Applicant applicant = applicantList.getUser(name);
			if (applicant.getCPF().equals(String.valueOf(cpf))) {
				return true;
			}
		}
		return false;
	}

	
	public boolean setApplicant(Applicant applicant) {
		ApplicantList applicantList = getApplicantList();
		
		System.out.println(!applicantList.contains(applicant.getCPF()));
		
		if (!applicantList.contains(applicant.getCPF())) {
			try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FILE)))) {
				applicantList.addBack(applicant);
				
				Applicant current = applicantList.removeFront();
				while (current != null) {
					bw.write(current.toString() + "\n");
					current = applicantList.removeFront();
				}
				bw.flush();
				bw.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			return true;
		}
		return false;
	}
	
	
	public Object[][] getSortedFormattedList() {
		ApplicantList applicantLists = getApplicantList();
		Sorting sorting = new Sorting();
		applicantLists = sorting.quickSort(applicantLists);
		
		return applicantLists.formatList();
	}
	
	
	public void deleteApplicant(int[] pos) {
		ApplicantList applicantLists = getApplicantList();
		
		for (int i : pos) {
			applicantLists.removeAnyPosition(i);
		}
		updateBD(applicantLists);
	}
	
	
	public void confirmApplicants(int[] pos) {
		ApplicantList applicantLists = getApplicantList();
		Applicant applicant;
		for (int i : pos) {
			applicant = applicantLists.removeAnyPosition(i);
			applicant.setStatus("Inscrição deferida");
			applicant.setNext(null);
			applicantLists.addBack(applicant);
		}
		updateBD(applicantLists);
	}
	
	
	private void updateBD(ApplicantList applicants) {
		try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FILE)))) {
			Applicant current = applicants.removeFront();
			
			while (current != null) {
				bw.write(current.toString() + "\n");
				current = applicants.removeFront();
			}
			bw.flush();
			bw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
