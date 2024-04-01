package board;

public abstract class Person {
	
	private String name;
	private String id;
	private String password;
	
	public Person(String name, String id, String password) {
		this.name = name;
		this.id = id;
		this.password = password;
	}
	
	public String getId() {
		return this.id;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}
	
	@Override
	public String toString() {
		return String.format("이름 :%s 아이디 : %s 비밀번호 %s", name, id, password);
	}
}
