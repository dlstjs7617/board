package board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Board {
	
	private final int SIGN_UP = 1;
	private final int LEAVE = 2;
	private final int CREATE_POST = 3;
	private final int MODIFY_POST = 4;
	private final int DELETE_POST = 5;
	
	private final int ADMIN = 0;
	
	private Scanner sc;
	private Random ran;
	
	private UserManager userManager;
	private PostManager postManager;
	private Admin admin = Admin.getInstance();
	
	private int log;
	
	public Map<User, ArrayList<Post>> map;
	
	public Board() {
		sc = new Scanner(System.in);
		ran = new Random();
		map = new HashMap<>();
		userManager = UserManager.getInstance();
		postManager = PostManager.getInstance();
		admin = Admin.getInstance();
		map.put(admin, new ArrayList<Post>());
		log = -1;
	}
	
	private String inputString(String message) {
		System.out.print(message + " : ");
		return sc.next();
	}
	
	private int inputNumber(String message) {
		int number = -1;
		
		System.out.print(message + " : ");
		try {
			String input = sc.next();
			number = Integer.parseInt(input);
		} catch (Exception e) {
			System.err.println("숫자만 입력");
		}
		return number;	
	}
	
	private boolean isRun() {
		return true;
	}
	
	private void createUser() {
		String name = inputString("이름");
		String id = inputString("아이디");
		String password = inputString("비밀번호");
		
		User user = userManager.createUser(name, id, password);
		
		if(user == null) {
			return;
		}
		
		map.put(user, new ArrayList<Post>());
	}
	
	private void selectMenu() {
		int sel = inputNumber("선택");
		
		if(sel == SIGN_UP) {
			createUser();
		}else if(sel == LEAVE) {
			leave();
		}else if(sel == CREATE_POST) {
			
		}else if(sel == MODIFY_POST) {
			
		}else if(sel == DELETE_POST) {
			
		}
	}
	
	private void printMenu() {
		System.out.println("1.회원가입");
		System.out.println("2.탈퇴");
		System.out.println("3.글작성");
		System.out.println("4.글수정");
		System.out.println("5.글삭제");
	}
	
	public void run() {
		while(isRun()) {
			printMenu();
			selectMenu();
		}
	}
	
	
}
