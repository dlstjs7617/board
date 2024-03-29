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
}
