package model;

import java.util.ArrayList;

public class Classroom {
	
	private ArrayList<UserAccount> accounts;

	public Classroom() {
		accounts = new ArrayList<UserAccount>();
	}
	
	public void addAccount(String name,String password,String imagePath, String gender,String career,String birthday,String favBrowser) {
		UserAccount newUser = new UserAccount(name,password,imagePath,gender,career,birthday,favBrowser);
		accounts.add(newUser);
	}
	
	public ArrayList<UserAccount> getAccounts(){
		return accounts;
	}
}
