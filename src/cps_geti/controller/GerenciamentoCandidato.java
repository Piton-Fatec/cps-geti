package cps_geti.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import cps_geti.model.ListaCandidato;
import cps_geti.model.Candidato;

public class GerenciamentoCandidato {
	
	private static String ARQUIVO = "bd/candidatos.txt";	
	
	public static ListaCandidato retornaListaCandidatos()  {
		ListaCandidato candidatos = new ListaCandidato();
		BufferedReader br = null;
		
		
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(ARQUIVO)));
			String line = br.readLine();
			
			while (line != null) {
				Candidato candidato = new Candidato();
				String[] arr = line.split(",");
				candidato.setNome(arr[0]);
				candidato.setEmail(arr[1]);
				candidato.setCPF(arr[2]);
				candidato.setCEP(arr[3]);
				candidato.setSituacao(arr[4]);
				candidatos.addBack(candidato);
				line = br.readLine();
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return candidatos;
	}

	
	public boolean candidatoValido(String nome, String cpf) {
		ListaCandidato listaCandidatos = retornaListaCandidatos();
		
		if (listaCandidatos.contains(nome)) {
			Candidato candidato = listaCandidatos.getUser(nome);
			if (candidato.getCPF().equals(String.valueOf(cpf))) {
				return true;
			}
		}
		return false;
	}

	
	public boolean criarUsuario(Candidato candidato) {
		ListaCandidato listaCandidatos = retornaListaCandidatos();
		
		System.out.println(!listaCandidatos.contains(candidato.getCPF()));
		
		if (!listaCandidatos.contains(candidato.getCPF())) {
			try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(ARQUIVO)))) {
				listaCandidatos.addBack(candidato);
				
				Candidato current = listaCandidatos.removeFront();
				while (current != null) {
					bw.write(current.toString() + "\n");
					current = listaCandidatos.removeFront();
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
	
	
	public Object[][] retonaListaFormatada() {
		ListaCandidato listaCandidatos = retornaListaCandidatos();
		return listaCandidatos.formatList();
	}
	
	
	public void removerCandidatos(int[] pos) {
		ListaCandidato listaCandidatos = retornaListaCandidatos();
		
		for (int i : pos) {
			listaCandidatos.removeAnyPosition(i);
		}
		atualizarBD(listaCandidatos);
	}
	
	
	public void confirmarCandidatos(int[] pos) {
		ListaCandidato listaCandidatos = retornaListaCandidatos();
		Candidato candidato;
		for (int i : pos) {
			candidato = listaCandidatos.removeAnyPosition(i);
			candidato.setSituacao("Inscrição deferida");
			listaCandidatos.addBack(candidato);
		}
		atualizarBD(listaCandidatos);
	}
	
	
	private void atualizarBD(ListaCandidato candidatos) {
		try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(ARQUIVO)))) {
			Candidato current = candidatos.removeFront();
			
			while (current != null) {
				bw.write(current.toString() + "\n");
				current = candidatos.removeFront();
				System.out.println(current);
			}
			bw.flush();
			bw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
