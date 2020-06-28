package application.Controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class RaportController {
	@FXML
	private AnchorPane anchorPane;

    @FXML
    private Label registerStudents;

    @FXML
    private Label searchStudents;

    @FXML
    private Label reportStudents;

    @FXML
    private Label semesterStudents;

    @FXML
    private Label registerSemester;

    @FXML
    private ImageView contact;

    @FXML
    private ImageView settingsHelp;

    @FXML
    private ImageView sendMessage;

	@FXML
    private TextField txtViti4;

    @FXML
    private TextField txtElektronike;

    @FXML
    private TextField txtAutomatike;

    @FXML
    private Label universiteti;

    @FXML
    private TextField txtViti1;

    @FXML
    private TextField txtViti2;

    @FXML
    private TextField txtElektroenergjetike;

    @FXML
    private TextField txtTelekomunikacion;

    @FXML
    private Label raport;

    @FXML
    private TextField txtKompjuterike;

    @FXML
    private TextField txtMeshkuj;

    @FXML
    private TextField txtFemra;

    @FXML
    private Button gjenero;

    @FXML
    private Button ruaj;
    
    @FXML
    private TextField txtViti3;

    @FXML
    private TextField txtNumriTotal;

    @FXML
    private Label editmyProfile;
    @FXML
    void fxmlChanges(MouseEvent event) throws IOException {
    	if(event.getSource()==editmyProfile)
    	{
    		AnchorPane pane=FXMLLoader.load(getClass().getResource("../Fxmls/MyProfile.fxml"));
    		anchorPane.getChildren().setAll(pane);
    	}
    	else if(event.getSource()==registerSemester)
    	{
    		AnchorPane pane=FXMLLoader.load(getClass().getResource("../Fxmls/fx.fxml"));
    		anchorPane.getChildren().setAll(pane);
    	}
    	else if(event.getSource()==reportStudents )
    	{
    		AnchorPane pane=FXMLLoader.load(getClass().getResource("../Fxmls/raport.fxml"));
    		anchorPane.getChildren().setAll(pane);
    	}
    	else if(event.getSource()==searchStudents )
    	{
    		AnchorPane pane=FXMLLoader.load(getClass().getResource("../Fxmls/EditDeleteUser.fxml"));
    		anchorPane.getChildren().setAll(pane);
    	}
    	else if(event.getSource()==registerStudents)
    	{
    		AnchorPane pane=FXMLLoader.load(getClass().getResource("../Fxmls/studentregister.fxml"));
    		anchorPane.getChildren().setAll(pane);
    	}
    	else if(event.getSource()==sendMessage)
    	{
    		AnchorPane pane=FXMLLoader.load(getClass().getResource("../Fxmls/FXMLperSend.fxml"));
    		anchorPane.getChildren().setAll(pane);
    	}
    	else if(event.getSource()==contact)
    	{
    		AnchorPane pane=FXMLLoader.load(getClass().getResource("../Fxmls/ContactUs.fxml"));
    		anchorPane.getChildren().setAll(pane);
    	}
	
    }

}
