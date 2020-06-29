

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
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
    	AnchorPane pane=FXMLLoader.load(getClass().getResource("myprofile.fxml"));
    	panemyprofileedit.getChildren().setAll(pane);
    }
    @FXML
    void NdryshoAdresen(ActionEvent event) throws IOException {
    	AnchorPane pane=FXMLLoader.load(getClass().getResource("NdryshoAdresen.fxml"));
    	panemyprofileedit.getChildren().setAll(pane);
    }

    @FXML
    void NdryshoEmailAdresen(ActionEvent event) throws IOException {
    	AnchorPane pane=FXMLLoader.load(getClass().getResource("NdryshoEmailAdresen.fxml"));
    	panemyprofileedit.getChildren().setAll(pane);
    }

    @FXML
    void NdryshoFjalekalimin(ActionEvent event) throws IOException {
    	AnchorPane pane=FXMLLoader.load(getClass().getResource("NdryshoFjalekalimin.fxml"));
    	panemyprofileedit.getChildren().setAll(pane);
    }

    @FXML
    void NdryshoNumrinETelefonit(ActionEvent event) throws IOException {
    	AnchorPane pane=FXMLLoader.load(getClass().getResource("NdryshoNumrinETelefonit.fxml"));
    	panemyprofileedit.getChildren().setAll(pane);
    }
    

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
