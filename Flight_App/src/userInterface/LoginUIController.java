package userInterface;

import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;

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
	public void loginClicked(MouseEvent event) {
		
		Person p = new Person();
		p.setUserName(userName.getText());
		p.setPass(password.getText());
		Data d = new Data();
		d.setPerson(p);
		HandleExceptions h = new HandleExceptions();
		try {
			h.checkExceptions(d, "login");
		} catch (SQLIntegrityConstraintViolationException e) {
			// if there is a login error alert user(issue with username or password, try again)
			if(e.getMessage() == "close") {
				
			}
			e.printStackTrace();
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
