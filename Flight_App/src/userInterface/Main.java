package userInterface;
	


import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	//Start Program
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
	Parent root = FXMLLoader.load(getClass().getResource("SplashScreenUI.fxml"));	//loads the splash fxml ui
	Scene scene = new Scene(root);	//sets the scene to be the splash ui
	primaryStage.setScene(scene);	//adds scene to the stage
	primaryStage.initStyle(StageStyle.UNDECORATED);		//removes the default menu bar(the minimize, expand,close)
	primaryStage.show();								//sets the visibility
	
	}
	
	public static void main(String[] args) {
		
		launch(args);
	}
	
}
