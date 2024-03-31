package board;

import java.util.ArrayList;

public class AllPost {
	
	private static AllPost instance = new AllPost();
	
	private ArrayList<Post> post;
	
	private void Allpost() {
		post = new ArrayList<Post>();
	}
	
	public static AllPost getInstance(){
		return instance;
	}
	
	public void printPost() {
		for(int i=0; i<post.size(); i++) {
			Post temp = post.get(i);
			System.out.println(i+1 +". 제목:" + temp.getTitle() + "\n작성자 : " + temp.getName());			
		}
	}
	
	public int size() {
		return post.size();
	}
	
	public void createPost(Post post) {
		this.post.add(post);
	}
	
	public Post readPost(int idx){		
		return post.get(idx);
	}
	
	public void deletePost(Post post) {
		this.post.remove(post);
	}
}
