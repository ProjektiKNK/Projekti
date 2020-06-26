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
    void fxmlChanges(MouseEvent event) throws IOException {
    	if(event.getSource()==editmyProfile1)
    	{
    		AnchorPane pane=FXMLLoader.load(getClass().getResource("../Fxmls/MyProfile.fxml"));
    		anchorMain.getChildren().setAll(pane);
    	}
    	else if(event.getSource()==registerSemester1 || event.getSource()==registerSemesterMain1)
    	{
    		AnchorPane pane=FXMLLoader.load(getClass().getResource("../Fxmls/fx.fxml"));
    		anchorMain.getChildren().setAll(pane);
    	}
    	else if(event.getSource()==reportStudents1 || event.getSource()==ReportStudentsMain1)
    	{
    		AnchorPane pane=FXMLLoader.load(getClass().getResource("../Fxmls/raport.fxml"));
    		anchorMain.getChildren().setAll(pane);
    	}
    	else if(event.getSource()==searchStudents1 || event.getSource()==searchStudentsMain1)
    	{
    		AnchorPane pane=FXMLLoader.load(getClass().getResource("../Fxmls/EditDeleteUser.fxml"));
    		anchorMain.getChildren().setAll(pane);
    	}
    	else if(event.getSource()==registerStudentsmain1 || event.getSource()==registerStudents1)
    	{
    		AnchorPane pane=FXMLLoader.load(getClass().getResource("../Fxmls/studentregister.fxml"));
    		anchorMain.getChildren().setAll(pane);
    	}
    	else if(event.getSource()==sendMessageMain1 || event.getSource()==sendMessage1)
    	{
    		AnchorPane pane=FXMLLoader.load(getClass().getResource("../Fxmls/FXMLperSend.fxml"));
    		anchorMain.getChildren().setAll(pane);
    	}
    	else if(event.getSource()==contact1 || event.getSource()==contactMain1)
    	{
    		AnchorPane pane=FXMLLoader.load(getClass().getResource("../Fxmls/ContactUs.fxml"));
    		anchorMain.getChildren().setAll(pane);
    	}
	
    }
    

}
