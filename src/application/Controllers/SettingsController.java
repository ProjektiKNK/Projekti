package application.Controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SettingsController {

    @FXML
    private Label settingsLabel;

    @FXML
    private Label forusLabel;

    @FXML
    private Label helpLabel;

    @FXML
    private Label chooseLabel;

    @FXML
    private Label shqipLabel;

    @FXML
    private Label anglishtLabel;

    @FXML
    void onSettingsClicked(MouseEvent event) throws IOException {

    	if(event.getSource()==anglishtLabel)
    	{
    		
    	}
    	else if(event.getSource()==shqipLabel)
    	{
    		
    	}
    	else if(event.getSource()==forusLabel)
    	{
    		
    	}
    	else if(event.getSource()==helpLabel)
    	{
    		Stage stage=new Stage();
    		AnchorPane pane=FXMLLoader.load(getClass().getResource("../Fxmls/helpxml.fxml"));
    		stage.setScene(new Scene(pane));
    		stage.show();
    	}
    	

    }


}
