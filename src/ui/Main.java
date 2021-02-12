package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Classroom;

public class Main extends Application {
	
	private PrincipalGUI pGUI;
	private Classroom classroom;
	
	public Main() {
		classroom = new Classroom();
		pGUI = new PrincipalGUI(classroom);
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override 
	public void start(Stage primaryStage) throws Exception{
		//Parent root = FXMLLoader.load(getClass().getResource("Welcome.fxml"));
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Welcome.fxml"));
		loader.setController(pGUI);
		Parent root = loader.load();
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setTitle("Login");
		pGUI.loadLogin();
	}
}
