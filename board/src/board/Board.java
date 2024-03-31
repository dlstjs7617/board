package board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Board {
	
	private final int SIGN_UP = 1;
	private final int LEAVE = 2;
	private final int LOG_IN = 3;
	private final int LOG_OUT = 4;
	private final int CREATE_POST = 5;
	private final int MODIFY_POST = 6;
	private final int DELETE_POST = 7;
	private final int ALL_POST = 8;
	
	
	private final int DELETE_USER = 1;
	private final int CREATE_NOTICE = 2;
	private final int DELETE_ADMIN_POST = 3;
	private final int LOG_OUT_ADMIN = 4;
	
	private final int ADMIN = 0;
	
	private Scanner sc;
	
	private UserManager userManager;
	private PostManager postManager;
	private Admin admin;
	private AllPost allPost;
	
	private int log;
	
	public static Map<User, ArrayList<Post>> map;
	
	public Board() {
		sc = new Scanner(System.in);
		map = new HashMap<>();
		userManager = UserManager.getInstance();
		postManager = PostManager.getInstance();
		allPost = AllPost.getInstance();
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
	
	private void leave() {
		String password = inputString("비밀번호 입력");
		
		if(userManager.deleteUser(log, password)) {
			log = -1;			
		}
	}
	
	private void login() {
		String id = inputString("아이디");
		String password = inputString("비밀번호");
		
		log = userManager.login(id,password);
		if(log != -1) {
			System.out.println("로그인 성공");
		}else {
			System.out.println("아이디/비밀번호 불일치");
		}
	}
	
	private void logout() {
		log = -1;
	}
	
	private Post writePost(String name) {
		sc.nextLine();
		String title = inputString("제목");
		
		boolean write = true;
		String content = "";
		System.out.println("내용 입력 (`)을 입력시 종료");
		while(write) {
			String temp = sc.nextLine();
			
			if(temp.equals("`"))
				break;
			
			content += temp +"\n";
		}
		Post post = new Post(title, content, name);
		return post;
	}
	
	private void createPost() {
		User user = userManager.readUser(log);
		String name =user.getName();
		Post post = writePost(name);
		
		allPost.createPost(post);
		postManager.createPost(user, post);
	}
	
	private void modifyPost() {
		User user = userManager.readUser(log);
		postManager.printPost(user);
		
		int idx = inputNumber("수정할 글번호 선택")-1;
		if(idx < 0 || idx >= postManager.getPostsSize()) {
			System.err.println("유효하지 않은 선택입니다");
			return;
		}
		
		Post post = writePost(user.getName());
		
		allPost.createPost(post);
		
		postManager.updatePost(user, post, idx);
	}
	
	private void deletePost() {
		User user = userManager.readUser(log);
		postManager.printPost(user);
		
		int idx = inputNumber("삭제할 글번호 선택")-1;
		if(idx < 0 || idx >= postManager.getPostsSize()) {
			System.err.println("유효하지 않은 선택입니다");
			return;
		}
		
		allPost.deletePost(postManager.readPost(user, idx));
		postManager.deletePost(user, idx);
	}
	
	private void printPage() {
		System.out.println("1.전페이지 2.앞페이지 3.나가기");
	}
	
	private int selectPage(int page, int select, int end) {
		if(select == 1) {
			if(page == 1)
				return page;
			else
				return page-1;
		}else if(select == 2) {
			if(end == allPost.size())
				return page;
			else
				return page+1;
		}
		
		return page;
	}
	
	private void allPost() {
		int page = 1;
		
		while(true) {
			int start = (page - 1) * 5;
		    int end = start + 5;
			if(end >= allPost.size())
				end = allPost.size();
			
			System.out.println("===============");
			for(int i=start; i<end; i++) {
				System.out.println(i+1+". " + allPost.readPost(i).getTitle());
			}
			System.out.println("현재 "+page+"페이지");
			System.out.println("===============");

			printPage();
			int sel = inputNumber("선택");
			if(sel == 3)
				break;
			
			page = selectPage(page, sel,end);
		}
	}
	
	private void deleteAdminPost() {
		allPost.printPost();
		
		int idx = inputNumber("번호선택")-1;
		
		if(idx < 0 || idx >= allPost.size()) {
			System.err.println("유효하지 않은 인덱스");
			return;
		}
		Post post = allPost.readPost(idx);
		
		allPost.deletePost(post);
	}
	
	private void printAdminMenu() {
		System.out.println("1.유저 추방");
		System.out.println("2.공지사항 작성");
		System.out.println("3.게시글 삭제");
		System.out.println("4.로그아웃");
	}
	
	private void seleteAdminMenu() {
		int sel = inputNumber("선택 :");
		
		if(sel == DELETE_USER) {
			
		}else if(sel == CREATE_NOTICE) {
			
		}else if(sel == DELETE_ADMIN_POST) {
			deleteAdminPost();
		}else if(sel == LOG_OUT_ADMIN) {
			logout();
		}
	}
	
	private void selectMenu() {
		int sel = inputNumber("선택");
		
		if(sel == SIGN_UP) 
			createUser();
		else if(sel == LOG_IN) 
			login();
		else if(sel == ALL_POST) 
			allPost();
		
		if(log != -1 && log != ADMIN) {	
			if(sel == LEAVE)
				leave();
			else if(sel == LOG_OUT)
				logout();
			else if(sel == CREATE_POST)
				createPost();
			else if(sel == MODIFY_POST)
				modifyPost();
			else if(sel == DELETE_POST)
				deletePost();
			
		}
		
	}
	
	private void printMenu() {
		System.out.println("1.회원가입");
		System.out.println("3.로그인");
		System.out.println("8.전체글조회");
		if(log != -1 && log != ADMIN) {			
			System.out.println("2.탈퇴");
			System.out.println("4.로그아웃");
			System.out.println("5.게시글 작성");
			System.out.println("6.게시글 수정");
			System.out.println("7.게시글 삭제");
		}
	}
	
	public void run() {
		while(isRun()) {
			printMenu();
			selectMenu();
			while(log == ADMIN) {
				if(log == ADMIN) {
					printAdminMenu();
					seleteAdminMenu();
				}
			}
			

		}
	}
	
}
