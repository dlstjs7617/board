package board;

import java.util.ArrayList;

public class AllPost {
	
	private static AllPost instance = new AllPost();
	
	private ArrayList<Post> post = new ArrayList<Post>();;
	
	private void Allpost() {
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
	
	public void printPostContent(int idx) {
		Post temp = post.get(idx);
		System.out.println(temp);
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
	
	public void deleteUserPost(User user) {
		for(int i=0; i<post.size(); i++) { 
			if(user.getName().equals(post.get(i).getName())) {
				post.remove(i);
				i--;
			}
			
		}
	}
}
