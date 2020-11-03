package core;

public class MainTest {

	public String helloFatec() {
		return("Hello, Fatec!");
	}
	
	public static void main(String[] args) {
		MainTest mt = new MainTest();
		
		String msg = mt.helloFatec();
		
		System.out.println(msg);
		
		System.out.println("aaaa");
	}
}
