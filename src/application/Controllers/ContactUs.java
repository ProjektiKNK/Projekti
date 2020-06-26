package application.Controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class ContactUs {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private ImageView returnbutton;

    @FXML
    void onReturnClicked(MouseEvent event) throws IOException{

    	if(event.getSource()==returnbutton)
    	{
    		AnchorPane pane=FXMLLoader.load(getClass().getResource("../Fxmls/MainXML.fxml"));
    		anchorPane.getChildren().setAll(pane);
    	}
    }

}
