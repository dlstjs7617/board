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
	
	public void printPost(User user) {
		posts = Board.map.get(user);
		
		for(int i=0; i<posts.size(); i++) {
			Post post = posts.get(i);
			System.out.printf("%s. %s \n", i+1 , post.getName());
		}
	}
	
	public void createPost(User user, Post post) {
		Board.map.get(user).add(post);
	}
	
	public void readPost(User user) {
		posts = Board.map.get(user);
		
	}
	
	public void updatePost(User user, Post post, int index) {
		Board.map.get(user).set(index, post);
	}
}
