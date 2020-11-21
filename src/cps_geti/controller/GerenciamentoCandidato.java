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
	
	public static ListaCandidato retornaListaCandidatos() {
		String arquivo = "bd/candidatos.txt";
		ListaCandidato candidatos = new ListaCandidato();
		
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(arquivo)))) {
			String line = br.readLine();
			
			while (line != null) {
				String[] arr = line.split(",");
				Candidato candidato = new Candidato(arr[0], arr[1], arr[2], arr[3]);
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
		ListaCandidato candidatos = retornaListaCandidatos();
		
		if (candidatos.contains(nome)) {
			Candidato candidato = candidatos.getUser(nome);
			if (candidato.getCPF().equals(String.valueOf(cpf))) {
				return true;
			}
		}
		return false;
	}

	
	public boolean criarUsuario(Candidato candidato) {
		String arquivo = "bd/candidatos.txt";
		ListaCandidato candidatos = retornaListaCandidatos();
		
		if (!candidatos.contains(candidato.getCPF())) {
			try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(arquivo)))) {
				candidatos.addBack(candidato);
				
				Candidato current = candidatos.removeFront();
				while (current != null) {
					bw.write(current.toString() + "\n");
					current = candidatos.removeFront();
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
}
