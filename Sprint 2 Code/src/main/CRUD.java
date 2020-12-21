package main;

import java.util.Scanner;

public interface CRUD {

	
	public void create(Scanner scanner);
	
	public void read(int index, User user, Scanner scanner);
	
	public void update(Scanner scanner);
	
	public void delete(Scanner scanner);
	
	
}
