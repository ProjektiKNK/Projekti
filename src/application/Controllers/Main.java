package application.Controllers;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;


import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws IOException {
		
		Parent parent = FXMLLoader.load(getClass().getResource("../Fxmls/MainXML.fxml"));
		//Pane parent=new Pane();
		
		Scene scene=new Scene(parent);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}


	 public static void main(String[] args) {
	 Application.launch(args);
	 }
}


	
