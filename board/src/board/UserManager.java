package board;

import java.util.ArrayList;

public class UserManager {
	ArrayList<User> userList;
	
	private UserManager() {
		userList = new ArrayList<>();
		userList.add(Admin.getInstance());
	}
	
	private static UserManager instance = new UserManager();
	
	public static UserManager getInstance() {
		return instance;
	}
	
	private boolean findIdCheck(String id) {
		for(User user : userList) {
			if(user.getId().equals(id))
				return true;
		}
		return false;
	}
	
	public User createUser(String name, String id, String password) {
		if(findIdCheck(id)) {
			System.err.println("이미 있는 아이디입니다.");
			return null;
		}
		
		User user = new User(name, id, password);
		userList.add(user);
		
		return user;
	}
	
}
