package cps_geti.model;

public class TEste {
	
	public static void main(String[] args) {
		ListaCandidato lt = new ListaCandidato();
		
		for (int i = 0; i < 10; i++) {
			Candidato c = new Candidato();
			c.setCPF(String.valueOf(i));
			lt.addBack(c);
		}
		for (int i = 0; i < 100; i++) {
			System.out.println(lt.contains(String.valueOf(i)));
		}
	}
}
