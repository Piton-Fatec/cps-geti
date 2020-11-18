package cps_geti.bd;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import cps_geti.model.ListaMembros;
import cps_geti.model.MembroCPS;

public class GerenciamentoUsuario {
	
	public static ListaMembros retornaListaMembros() {
		String arquivo = "bd/membros.txt";
		ListaMembros membros = new ListaMembros();
		
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(arquivo)))) {
			String line = br.readLine();
			
			while (line != null) {
				String[] arrString = line.split(",");
				MembroCPS membro = new MembroCPS(arrString[0], arrString[1]);
				membros.addBack(membro);
				line = br.readLine();
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return membros;
	}

	
	public boolean usuarioValido(String login, char[] senha) {
		ListaMembros membros = retornaListaMembros();
		
		if (membros.contains(login)) {
			MembroCPS membro = membros.getUser(login);
			if (membro.getSenha().equals(String.valueOf(senha))) {
				return true;
			}
		}
		return false;
	}

	
	public boolean criarUsuario(String login, char[] senha) {
		String arquivo = "bd/membros.txt";
		ListaMembros membros = retornaListaMembros();
		
		if (!membros.contains(login)) {
			try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(arquivo)))) {
				membros.addBack(new MembroCPS(login, String.valueOf(senha)));
				MembroCPS membro = membros.removeFront();
				while (membro != null) {
					bw.write(membro.toString() + "\n");
					membro = membros.removeFront();
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
