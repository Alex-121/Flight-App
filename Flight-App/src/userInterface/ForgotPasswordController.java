package userInterface;

import java.net.URL;
import java.util.ResourceBundle;

import businessLogic.Person;
import data.Data;
import data.HandleExceptions;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Label;

import javafx.scene.layout.GridPane;

import javafx.scene.control.ChoiceBox;

public class ForgotPasswordController implements Initializable {
	@FXML
	private GridPane forgotPane;
	@FXML
	private TextField answer;
	@FXML
	private ChoiceBox<String> secQuestions;
	@FXML
	private Label secLabel;
	@FXML
	private Label answerLabel;
	@FXML
	private Button checkButton;
	@FXML
	private TextField email;
	@FXML
	private Label emailLabel;
	@FXML
	private Button backButton;
	
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		secQuestions.setItems(Sign_UpController.questions);
	}
	
	@FXML
    public void checkClicked(MouseEvent event) {
		
	Person p = new Person();
	p.setEmail(email.getText());
	p.setQuestion(secQuestions.getValue());
	p.setAnswer(answer.getText());
	Data d = new Data();
	d.setPerson(p);
	
	try {
		HandleExceptions.checkExceptions(d, "question");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println(e.getMessage());;
	}

    }
	
	@FXML
	public void backClicked(MouseEvent event) {
		forgotPane.getScene().getWindow().hide();
	}
	
}
