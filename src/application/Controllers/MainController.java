package application.Controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class MainController {

	
	
    @FXML
    private AnchorPane anchorMain;
    @FXML
    private Label registerStudents1;

    @FXML
    private Label searchStudents1;

    @FXML
    private Label reportStudents1;

    @FXML
    private Label semesterStudents1;

    @FXML
    private Label registerSemester1;

    @FXML
    private ImageView contact1;

    @FXML
    private ImageView settingsHelp1;

    @FXML
    private ImageView sendMessage1;

    @FXML
    private Label editmyProfile1;

    @FXML
    private Label registerStudentsmain1;

    @FXML
    private Label contactMain1;

    @FXML
    private Label ReportStudentsMain1;

    @FXML
    private Label searchStudentsMain1;

    @FXML
    private Label registerSemesterMain1;

    @FXML
    private Label sendMessageMain1;
    
    
    
    
    @FXML
    void onMouseClickedMainLeft(MouseEvent event) throws IOException {
    	if(event.getSource()==editmyProfile1)
    	{
    		AnchorPane pane=FXMLLoader.load(getClass().getResource("../Fxmls/MyProfile.fxml"));
    		anchorMain.getChildren().setAll(pane);
    	}
    	

    }
    

}
