package userInterface;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class SplashScreenUIController implements Initializable{

	@FXML
	private AnchorPane parent;
	
	 @FXML
	    private ProgressBar pb;
	@FXML
	public void close_application(MouseEvent event) {
		if(ConfirmBox.display("System Exit", "Do you want to close the application?"))
			System.exit(0);
	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}
	
	

}
