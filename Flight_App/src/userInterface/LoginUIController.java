package userInterface;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginUIController {
	
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
		if(ConfirmBox.display("System Exit", "Do you want to close the application?"))
			System.exit(0);
	}
	// Event Listener on Button[#logIn].onMouseClicked
	@FXML
	public void loginClicked(MouseEvent event) {
		
	}
	// Event Listener on Button[#signUp].onMouseClicked
	@FXML
	public void signupClicked(MouseEvent event) {
		
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Sign_Up.fxml"));
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
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
