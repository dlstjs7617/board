package board;

public class Post {
	
	private String title;
	private String content;
	private String name;
	
	
	public Post(String title, String content, String name) {
		this.title = title;
		this.content = content;
		this.name = name;
	}
	
	
	public String getTitle() {
		return title;
	}


	public String getContent() {
		return content;
	}


	public String getName() {
		return name;
	}


	@Override
	public String toString() {
		String text =String.format("제목 : %s  \n 작성자 :%s \n 내용 \n %s", title, content, name);
		return text;
	}
}
