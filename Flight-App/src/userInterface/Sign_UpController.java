package userInterface;

import java.sql.SQLIntegrityConstraintViolationException;

import businessLogic.Person;
import data.Data;
import data.HandleExceptions;
import data.customException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import javafx.scene.control.PasswordField;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.ChoiceBox;

public class Sign_UpController {
	
	static ObservableList<String> questions = FXCollections.observableArrayList("Your favorite band in High School?", "The name of your first pet?", "Name of the city you were born in?", "Model of dream car?");
	
	@FXML
	private AnchorPane signUpScreen;
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
	public void addUser(MouseEvent event) throws Exception {
		
		//generic person class that has all the variables
		try {
		Person p = new Person();
		p.setFirstName(firstName.getText());
		p.setLastName(lastName.getText());
		p.setAddress(address.getText());
		p.setZip(Integer.parseInt(zip.getText()));
		p.setState(state.getText());
		p.setUserName(userName.getText());
		p.setPass(pass.getText());
		p.setEmail(email.getText());
		p.setQuestion(securityQuestion.getValue());
		p.setAnswer(answer.getText());
		p.setSsn(Integer.parseInt(ssn.getText()));
		
		//generic data object that can be push to database and exception catcher
		Data d = new Data();
		d.setPerson(p);
		
		
			HandleExceptions.checkExceptions(d, "sign up");
		} catch (SQLIntegrityConstraintViolationException e) {
			Alerts.alert1("SSN already used");
		} catch (Exception e) {
			Alerts.alert1("Check inputs. Fields can not be empty and zip/ssn need to be numbers");
		}
		
	}
	
}
