package board;

import java.util.ArrayList;

public class PostManager {	
	
	private static ArrayList<Post> posts;
	
	private PostManager() {
	}
	
	private static PostManager instance = new PostManager();
	
	public static PostManager getInstance() {
		return instance;
	}
	
	public int getPostsSize() {
		return posts.size();
	}
	
	public void printPost(User user) {
		posts = Board.map.get(user);
		
		for(int i=0; i<posts.size(); i++) {
			Post post = posts.get(i);
			System.out.printf("%s. %s \n", i+1 , post.getTitle());
		}
	}
	
	public void createPost(User user, Post post) {
		Board.map.get(user).add(post);
	}
	
	public Post readPost(User user, int idx) {
		posts = Board.map.get(user);
		Post result = posts.get(idx);
		return result;
	}
	
	public void updatePost(User user, Post post, int index) {
		Board.map.get(user).set(index, post);
	}
		
	public void deletePost(User user, int idx) {
		Board.map.get(user).remove(idx);
	}
	
	public void deletePost(User user, Post post) {
		Board.map.get(user).remove(post);
	}
}
