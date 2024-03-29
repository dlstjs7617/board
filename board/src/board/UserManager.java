package board;

public class UserManager {
	
	
	private UserManager() {
		
	}
	
	private static UserManager instance = new UserManager();
	
	public static UserManager getInstance() {
		return instance;
	}
	
	
	
	
	public User createUser(String name, String id, String password) {
		User user = new User(name, id, password);
		return user;
	}
	
}
