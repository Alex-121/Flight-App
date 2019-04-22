package userInterface;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;

public class Main extends Application {
	
	//Start Program
	
	
	public void init() throws Exception {
		
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
	
		Parent root = FXMLLoader.load(getClass().getResource("SplashScreenUI.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.initStyle(StageStyle.UNDECORATED); 
		primaryStage.show();
		PauseTransition delay = new PauseTransition(Duration.seconds(4));
		delay.setOnFinished( event -> primaryStage.close() );
		delay.play();
	
	}

	public static void main(String[] args) {
		
		launch(args);
	}
	
}
	
