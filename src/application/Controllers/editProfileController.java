package application.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class editProfileController implements Initializable {
    @FXML
    private ImageView goback;
    @FXML
    private AnchorPane panemyprofileedit;
    @FXML
    private Label backlabel;
    @FXML
    void onBackClicked(MouseEvent event) throws IOException {
    	AnchorPane pane=FXMLLoader.load(getClass().getResource("../Fxmls/myprofile.fxml"));
    	panemyprofileedit.getChildren().setAll(pane);
    }


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
