package userInterface;

import java.io.IOException;
import businessLogic.Person;
import data.Data;
import data.HandleExceptions;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginUIController {
	
	@FXML
	private TextField userName;
	
	@FXML
	private PasswordField password;
	
	@FXML
	private AnchorPane loginScreen; 
	@FXML
	private Button logIn;
	@FXML
	private Button signUp;
	@FXML
	private Button forgotPassword;

	// Event Listener on ImageView.onMouseClicked
	@FXML
	public void close_application(MouseEvent event) {
			System.exit(0);
	}
	// Event Listener on Button[#logIn].onMouseClicked
	@FXML
	public void loginClicked(MouseEvent event) throws IOException {
		
		Person p = new Person();
		p.setUserName(userName.getText());
		p.setPass(password.getText());
		if(userName.getText().toString().equals("admin")) {
			p.setAdmin(true);
			System.out.println(p.getisAdmin());
		}
		Data d = new Data();
		d.setPerson(p);
		
		
			try {
				HandleExceptions.checkExceptions(d, "login");
			} catch (Exception e) {
				//Depending on the error message things will happen
				
				if(e.getMessage() == "passwords match") {
					MainPageController.setUserName(p.getUserName());
					Parent root = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
					Scene scene = new Scene(root);
					Stage stage = new Stage();
					stage.setScene(scene);
					stage.setTitle("Main Page");
					stage.show();
				}
				
				
			}
		
			
		
	}
	// Event Listener on Button[#signUp].onMouseClicked
	@FXML
	public void signupClicked(MouseEvent event) {
		
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Sign_Up.fxml"));
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("Sign up");
			stage.show();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	
	}
	// Event Listener on Button[#forgotPassword].onContextMenuRequested
	@FXML
	public void getQuestion(MouseEvent event) {
	
		
	}
}
