package userInterface;

import java.sql.Connection;
import java.sql.DriverManager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import javafx.scene.control.PasswordField;

import javafx.scene.input.MouseEvent;

import javafx.scene.control.ChoiceBox;

public class Sign_UpController {
	
	ObservableList<String> questions = FXCollections.observableArrayList("Your favorite band in High School?", "The name of your first pet?", "Name of the city you were born in?", "Model of dream car?");
	
	@FXML
	private TextField firstName;
	@FXML
	private TextField lastName;
	@FXML
	private TextField address;
	@FXML
	private TextField zip;
	@FXML
	private TextField state;
	@FXML
	private TextField userName;
	@FXML
	private PasswordField pass;
	@FXML
	private TextField email;
	@FXML
	private TextField answer;
	@FXML
	private PasswordField ssn;
	@FXML
	private ChoiceBox<String> securityQuestion;
	@FXML
	private Button signupButton;
	
	
	@FXML
	private void initialize() {
		securityQuestion.setItems(questions);
	}

	// Event Listener on Button[#signupButton].onMouseClicked
	@FXML
	public void addUser(MouseEvent event) throws Exception{
		
	
		
		Connection link = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/project","root","1234");
		
	}
	
}
