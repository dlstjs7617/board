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
	
	public void printPost() {
		for(int i=0; i<post.size(); i++) {
			Post temp = post.get(i);
			System.out.println(i+1 +". 제목:" + temp.getTitle() + "\n작성자 : " + temp.getName());			
		}
	}
}
