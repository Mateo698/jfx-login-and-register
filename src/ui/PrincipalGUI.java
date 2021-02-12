package ui;

import model.*;
import java.io.IOException;
import java.io.*;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class PrincipalGUI {
	
	//User list controllers

	@FXML
	private TableView<UserAccount> userList;

	@FXML
	private Label username;

	@FXML
	private ImageView profilePicture;
	
	@FXML
    private TableColumn<UserAccount, String> userCol;

    @FXML
    private TableColumn<UserAccount, String> genderCol;

    @FXML
    private TableColumn<UserAccount, String> careerCol;

    @FXML
    private TableColumn<UserAccount, String> bdCol;

    @FXML
    private TableColumn<UserAccount, String> browserCol;

	///////////////////////////////////
	
	@FXML
	private Label label1;
	
	@FXML
    private PasswordField LoginTxtPassword;

    @FXML
    private TextField LoginTxtUsername;

    @FXML
    private Button signIn;

    @FXML
    private Button loginBtn;
	
	@FXML
    private TextField TxtUsername;
	
	@FXML
    private ToggleGroup genderG;
	
    @FXML
    private TextField imagePath;

    @FXML
    private PasswordField TxtPassword;

    @FXML
    private RadioButton RbMale;

    @FXML
    private RadioButton RbFemale;

    @FXML
    private RadioButton RbOther;

    @FXML
    private CheckBox CheckSE;

    @FXML
    private CheckBox CheckTE;

    @FXML
    private CheckBox CheckIE;

    @FXML
    private DatePicker DpBirthday;
    
    @FXML
    private Pane mainPane;
    
    private Classroom classroom;
    
    private ArrayList<String> filters;
    
    @FXML
    private ComboBox<String> comb;
    
    

   
    public PrincipalGUI(Classroom classroom){
		this.classroom = classroom;
    	filters = new ArrayList<>();
    	filters.add("*.PNG");
    	filters.add("*.png");
    	filters.add("*.jpg");
    	filters.add("*.JPG");
    	classroom.addAccount("Mateo698", "Reshiram555", "G:\\Descargas\\Pepega-meme.png", "Male", "SE","21/10/2002" ,"Chrome");
    }
    
    @FXML
    void Select(ActionEvent event) {
    	//COMBOBOX SELECT
    }

    public void loadLogin() throws IOException {
    	FXMLLoader loginLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
    	loginLoader.setController(this);
    	Parent addLogin = loginLoader.load();
    	mainPane.getChildren().setAll(addLogin);
    	
    }
    
    @FXML
    public void fileChoose(ActionEvent event) {
    	FileChooser fc = new FileChooser();
    	fc.getExtensionFilters().add(new ExtensionFilter("Images",filters));
    	File f = fc.showOpenDialog(null);
    	if(f != null) {
    		imagePath.setText(f.getAbsolutePath());
    	}
    }
    
    @FXML
    public void createAccount(ActionEvent event){
    	Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("It wasn't possible to register");
		alert.setHeaderText("There's missing information");
		alert.setContentText("Please fill the missing info");
		

    	
    	
    	if(TxtUsername.getText().equals("")) {
    		alert.showAndWait();

    	}
    	else {
    		String username = TxtUsername.getText();
    		boolean foundUsername = false;
        	for(int i=0;i<classroom.getAccounts().size() && !foundUsername ;i++) {
        		if(username.equals(classroom.getAccounts().get(i).getUsername())) {
        			alert.showAndWait();

        			foundUsername = true;
        		}
        	}
        	if(foundUsername) {
        		Alert alert1 = new Alert(AlertType.ERROR);
        		alert1.setTitle("It wasn't possible to register");
        		alert1.setHeaderText("Your username is already in use");
        		alert1.setContentText("Please change the username");
        		TxtUsername.setText("");
        	}
        	else {
        		if(TxtPassword.getText().equals("")) {
            		alert.showAndWait();

            	}
            	else {
            		String password = TxtPassword.getText();
            		if(imagePath.getText().equals("")) {
                		alert.showAndWait();

                	}
                	else {
                		String pImagePath = imagePath.getText();
                		if(RbMale.isSelected() == false && RbFemale.isSelected() == false && RbOther.isSelected() == false) {
                			alert.showAndWait();
                		}
                		else {
                			String gender = null;
                	    	if(RbMale.isSelected()) {
                	    		gender = "Male";
                	    	}
                	    	else if(RbFemale.isSelected()) {
                	    		gender = "Female";
                	    	}
                	    	else if(RbOther.isSelected()) {
                	    		gender = "Other";
                	    	}
                	    	
                	    	
                	    	if(CheckSE.isSelected() == false && CheckTE.isSelected() == false && CheckIE.isSelected() == false) {
                	    		alert.showAndWait();

                	    	}
                	    	else {
                	    		String career = "";
                	    		career += CheckSE.isSelected() == true ? "Software Engineering " : "";
                	    		career += CheckTE.isSelected() == true ? "Telematic Engineering " : "";
                	    		career += CheckIE.isSelected() == true ? "Industrial Engineering" : "";
                	    		
                	    		if(DpBirthday.getValue().toString() == "") {
                	        		alert.showAndWait();
                	        	}
                	        	else {
                	        		String birthday;
                	        		birthday = DpBirthday.getValue().toString();
                	        		if(comb.getValue().equals("")) {
                	        			alert.showAndWait();
                	        		}
                	        		else {
                	        			String favBrowser = comb.getValue().toString();
                	        			
                	        			classroom.addAccount(username, password, pImagePath, gender, career,birthday, favBrowser);
                	        			Alert alert2 = new Alert(AlertType.INFORMATION);
                	        			alert2.setTitle("Attention");
                	        			alert2.setHeaderText("Register succesful");
                	        			alert2.setContentText("Please log in");

                	        			alert2.showAndWait();
                	        			try {
											loadLogin();
										} catch (IOException e) {
											alert.showAndWait();
										}
                	        		}
                	        	}
                	    	}
                		}
                	}
            	}
        	}
    	}
    }
    
   
    
    @FXML
    public void goLogIn(ActionEvent event) throws IOException {
    	loadLogin();
    }
    
    @FXML
    public void goSignIn(ActionEvent event) throws IOException {
    	FXMLLoader registerLoader = new FXMLLoader(getClass().getResource("Register.fxml"));
    	registerLoader.setController(this);
    	Parent addRegister = registerLoader.load();
    	mainPane.getChildren().clear();
    	mainPane.getChildren().setAll(addRegister);
    	ObservableList<String> list = FXCollections.observableArrayList("Chrome","Firefox","Opera","Edge","Safari","Thor","Brave");
    	comb.setItems(list);
    }

    @FXML
    public void logIn(ActionEvent event) throws IOException {
    	String logUsername = LoginTxtUsername.getText();
    	String logPassword = LoginTxtPassword.getText();
    	int userIndex = 0;
    	boolean foundUser = false;
    	for(int i=0 ; i<classroom.getAccounts().size() && !foundUser ; i++) {
    		if(logUsername.equals(classroom.getAccounts().get(i).getUsername())) {
				foundUser = true;
				userIndex = i;
    		}		
    	}
    	
    	if(foundUser) {
    		if(logPassword.equals(classroom.getAccounts().get(userIndex).getPassword())) {
				loadList(classroom.getAccounts().get(userIndex));
			}
			else {
				Alert wrongPass = new Alert(AlertType.ERROR);
				wrongPass.setTitle("Error");
				wrongPass.setHeaderText("Wrong password");
				wrongPass.setContentText("Please type the right password");
				wrongPass.showAndWait();
			}
    	}
    	else {
    			Alert noUser = new Alert(AlertType.ERROR);
    			noUser.setTitle("Error");
    			noUser.setHeaderText("No user found with that username");
    			noUser.setContentText("Please type a registered user, otherwise create an account");
    			noUser.showAndWait();
    		}
    }
    
    public void loadList(UserAccount localUser) throws IOException {
    	FXMLLoader listLoader = new FXMLLoader(getClass().getResource("UserList.fxml"));
    	listLoader.setController(this);
    	Parent addList = listLoader.load();
    	mainPane.getChildren().clear();
    	mainPane.getChildren().setAll(addList);
    	
    	ObservableList<UserAccount> userAccountList;
    	userAccountList = FXCollections.observableArrayList(classroom.getAccounts());
    	
    	userCol.setCellValueFactory(new PropertyValueFactory<UserAccount,String>("username")); 
		genderCol.setCellValueFactory(new PropertyValueFactory<UserAccount,String>("gender"));
		careerCol.setCellValueFactory(new PropertyValueFactory<UserAccount,String>("career"));
		bdCol.setCellValueFactory(new PropertyValueFactory<UserAccount,String>("birthday"));
		browserCol.setCellValueFactory(new PropertyValueFactory<UserAccount,String>("favBrowser"));
		
		userList.setItems(userAccountList);
		username.setText(localUser.getUsername());
		File f = new File(localUser.getImagePath());
		
		Image profP = new Image(f.toURI().toString());
		profilePicture.setImage(profP);
    	
    }
    
    @FXML
    public void logOut(ActionEvent event) {
    	try {
			loadLogin();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
