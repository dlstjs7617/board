package board;

import java.util.ArrayList;

public class AllPost {
	private static ArrayList<Post> post = new ArrayList<Post>();
	
	public static ArrayList<Post> getInstance(){
		return post;
	}
	
	
	public Post readPost(int idx){		
		return post.get(idx);
	}
}
