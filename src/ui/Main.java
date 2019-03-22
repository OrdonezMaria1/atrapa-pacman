package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("pacman.fxml"));
		Parent root = fxmlLoader.load();
		
		PacmanController pacmanC = fxmlLoader.getController();
		pacmanC.setStage(stage);
		
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Atrapa el Pac-Man");
		stage.show();
	}

}