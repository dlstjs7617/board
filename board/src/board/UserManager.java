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
	
	public int login(String id, String password) {
		for(int i=0; i<userList.size(); i++) {
			User user = userList.get(i);
			if(user.getId().equals(id) && user.getPassword().equals(password)) {
				return i;
			}
		}
		return -1;
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
	
	public User readUser(int log) {
		return userList.get(log);
	}
	
	public boolean deleteUser(int log, String password) {
		if(userList.get(log).getPassword().equals(password)) {
			User user = userList.get(log);
			Board.map.remove(user);
			userList.remove(log);
			return true;
		}else {
			System.out.println("비밀번호 불일치");
			return false;
		}
	}
	
}
