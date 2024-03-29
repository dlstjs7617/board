package board;

public class Admin extends User{

	private Admin() {
		super("admin", "admin", "1234");
	}
	
	private static Admin instance = new Admin();
	
	public static Admin getInstance() {
		return instance;
	}

}
