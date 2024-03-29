package board;

import java.util.ArrayList;

public class PostManager {	
	
	private ArrayList<Post> posts;
	
	private PostManager() {
	}
	
	private static PostManager instance = new PostManager();
	
	public static PostManager getInstance() {
		return instance;
	}
	
	
	public void createPost(User user, Post post) {
		Board.map.get(user).add(post);
	}
	
	public void updatePost(User user, Post post, int index) {
		Board.map.get(user).set(index, post);
	}
}
