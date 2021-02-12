package model;


public class UserAccount {
	
	private String username;
	private String password;
	private String imagePath;
	private String gender;
	private String career;
	private String birthday;
	private String favBrowser;
	
	public UserAccount(String username,String password, String imagePath,String gender,String career,String birthday, String favBrowser) {
		this.username = username;
		this.password = password;
		this.imagePath = imagePath;
		this.gender = gender;
		this.career = career;
		this.birthday = birthday;
		this.favBrowser = favBrowser;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getImagePath() {
		return imagePath;
	}
	
	public String getGender() {
		return gender;
	}
	
	public String getCareer() {
		return career;
	}
	
	public String getBirthday() {
		return birthday;
	}
	
	public String getFavBrowser() {
		return favBrowser;
	}
}
