package bbgo;


public class LeadingClass {

	public static void main(String[] args) {
		
		sqlengine dbEngine = new sqlengine("root", "root"); //database engine
		 dbEngine.connect();
		 
			new LoginGui();


	}

}
