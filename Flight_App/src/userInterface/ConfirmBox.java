package userInterface;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class ConfirmBox {
	//testing 
	static boolean answer;	

	public static boolean display(String title, String message) {
	
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(450);
		window.setMinHeight(250);
		
		Label label = new Label(message);
		
		Button button1 = new Button("Yes");
		
		Button button2 = new Button("No");
		
		button1.setOnAction(e -> {
			answer = true;
			window.close();
		});
		
		button2.setOnAction(e -> {
			answer = false;
			window.close();
		});
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(label, button1, button2);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
		
		return answer;
	}
	
}	