package board;

public class PostManager {	
	
	private PostManager() {
		
	}
	
	private static PostManager instance = new PostManager();
	
	public static PostManager getInstance() {
		return instance;
	}
}
