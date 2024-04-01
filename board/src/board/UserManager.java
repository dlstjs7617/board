package board;

import java.util.ArrayList;
import java.util.Map;

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
	
	public int size() {
		return userList.size();
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
	
	public void printAllUser() {
		for(int i=0; i<userList.size(); i++) {
			User user = userList.get(i);
			System.out.println(i+1 +". "+ user);
		}
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
	
	public User readUser(Post post) {
		for(int i=0; i<Board.map.size(); i++) {
			if(userList.get(i).getName().equals(post.getName())) {
				return userList.get(i);
			}
		}
		
		return null;
	}
	
	public void deleteUser(int log) {
			Board.map.remove(log);
			userList.remove(log);
	}
	
	
	public boolean deleteUser(int log, String password) {
		if(userList.get(log).getPassword().equals(password)) {
			User user = userList.get(log);
			AllPost.getInstance().deleteUserPost(user);
			Board.map.remove(user);
			userList.remove(log);
			return true;
		}else {
			System.out.println("비밀번호 불일치");
			return false;
		}
	}
	
}
