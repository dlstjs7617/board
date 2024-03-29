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
	
}
