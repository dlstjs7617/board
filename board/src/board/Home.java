package board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Home {
	
	private Scanner sc;
	private Random ran;
	private Map<User, ArrayList<Board>> map = new HashMap<>();
	
	public Home() {
		sc = new Scanner(System.in);
		ran = new Random();
	}
	
	private String inputString(String message) {
		System.out.print(message + " : ");
		return sc.next();
	}
	
	private int inputNumber(String message) {
		int number = -1;
		
		System.out.print(message + " : ");
		try {
			String input = sc.next();
			number = Integer.parseInt(input);
		} catch (Exception e) {
			System.err.println("숫자만 입력");
		}
		return number;	
	}
	
	public void run() {
		
	}
	
	
}
