package board;

import java.util.ArrayList;

public class PostManager {	
	
	ArrayList<Post> posts;
	
	private PostManager() {
		posts = new ArrayList<Post>();
	}
	
	private static PostManager instance = new PostManager();
	
	public static PostManager getInstance() {
		return instance;
	}
	
	
	public void createPost(User user, Post post) {
		posts.add(post);
		Board.map.put(user, posts);
	}
}
