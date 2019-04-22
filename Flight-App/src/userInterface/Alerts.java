package userInterface;

import javafx.scene.control.Alert;

public class Alerts {

	public static void alert1(String msg) {
		
		Alert a1 = new Alert(Alert.AlertType.INFORMATION);
		a1.setTitle("Alert");
		a1.setContentText(msg);
		a1.showAndWait();
	}
}
