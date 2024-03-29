package board;

public class UserManager {
	
	
	public User createUser(String name, String id, String password) {
		User user = new User(name, id, password);
		return user;
	}
	
}
