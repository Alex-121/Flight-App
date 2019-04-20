package userInterface;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SplashScreenUIController implements Initializable{

	@FXML
	private AnchorPane rootPane;
	
	@FXML
	
	ProgressBar pb = new ProgressBar();
	
	@FXML
	public void close_application(MouseEvent event) {
			System.exit(0);
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	
		new SplashScreen().start();
	}

	class SplashScreen extends Thread {
		
		@Override
		public void run() {
			try {
				Thread.sleep(4000);
				
				Platform.runLater(new Runnable() {
					
					@Override
					public void run() { 
						Parent root = null;
						try {
							root = FXMLLoader.load(getClass().getResource("LoginUI.fxml"));
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						Scene scene = new Scene(root);
						Stage stage= new Stage();
						stage.setScene(scene);
						stage.initStyle(StageStyle.UNDECORATED);
						stage.show();
						
					}});			
		
				
			} catch (InterruptedException ex) {
				
				
			} catch (Exception ex) {
				
			}
			
		}
	}
}
