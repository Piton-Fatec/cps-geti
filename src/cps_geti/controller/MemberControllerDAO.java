package cps_geti.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import cps_geti.model.MemberList;
import cps_geti.model.CPSMember;

public class MemberControllerDAO {
	
	private static String FILE = "bd/members.txt";
	
	public static MemberList getMemberList() {
		MemberList members = new MemberList();
		
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(FILE)))) {
			String line = br.readLine();

			while (line != null) {
				String[] arrString = line.split(",");
				CPSMember member = new CPSMember(arrString[0], arrString[1]);
				members.addBack(member);
				line = br.readLine();
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return members;
	}

	
	public boolean isValid(String login, char[] password) {
		MemberList memberList = getMemberList();
		if (memberList.contains(login)) {
			CPSMember member = memberList.getUser(login);
			if (member.getPassword().equals(String.valueOf(password))) {
				return true;
			}
		}
		return false;
	}

	
	public boolean setMember(String login, char[] password) {
		MemberList memberList = getMemberList();
		if (!memberList.contains(login)) {
			try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FILE)))) {
				memberList.addBack(new CPSMember(login, String.valueOf(password)));
				
				CPSMember member = memberList.removeFront();
				while (member != null) {
					bw.write(member.toString() + "\n");
					member = memberList.removeFront();
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
