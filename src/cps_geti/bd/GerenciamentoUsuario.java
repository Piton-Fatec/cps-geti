package cps_geti.bd;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class GerenciamentoUsuario {

	public boolean usuarioValido(String login, char[] senha) {
		String arquivo = "membros.txt";
		boolean validador = false;
		
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(arquivo)))) {
			String line = br.readLine();
			
			while (line != null) {
				String[] arrString = line.split(",");
				if (arrString[0] == login && arrString[1] == String.valueOf(senha)) {
					validador = true;
					break;
				}
				line = br.readLine();
			}	
		} catch (IOException e) {
			e.printStackTrace();
		}
		return validador;
	}
	
	public boolean usuarioExistente(String login) {
		String arquivo = "membros.txt";
		boolean validador = false;
		
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(arquivo)))) {
			String line = br.readLine();
			
			while (line != null) {
				String[] arrString = line.split(",");
				if (arrString[0] == login) {
					validador = true;
					break;
				}
				line = br.readLine();
			}	
		} catch (IOException e) {
			e.printStackTrace();
		}
		return validador;
	}
	
	public boolean criarUsuario(String login, char[] senha) {
		String arquivo = "membros.txt";
		
		GerenciamentoUsuario gu = new GerenciamentoUsuario();
		boolean testeUsuario = gu.usuarioExistente(login);
		
		if (!testeUsuario) {
			try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(arquivo)))) {
				String line = login + "," + String.valueOf(senha);
				bw.write(line);
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
			return true;
		}
		return false;
	}
}
