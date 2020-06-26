package application.Controllers;




import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class EditController implements Initializable {

	ObservableList<String> lista=FXCollections.observableArrayList("ID", "Emri", "Mbiemri", "Email", "Qyteti", "Ditelindja", "Fakulteti" );
	@FXML
	private AnchorPane anchorPane;

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
    private Label label;
    
   
    @FXML
    private ComboBox<String> choicebox;
    @FXML
    private void combobox() {
    	
    
    	choicebox.getItems().addAll(lista);
    	
    }
    @FXML
    void fxmlChanges(MouseEvent event) throws IOException {
    	if(event.getSource()==editmyProfile1)
    	{
    		AnchorPane pane=FXMLLoader.load(getClass().getResource("../Fxmls/MyProfile.fxml"));
    		anchorPane.getChildren().setAll(pane);
    	}
    	else if(event.getSource()==registerSemester1)
    	{
    		AnchorPane pane=FXMLLoader.load(getClass().getResource("../Fxmls/fx.fxml"));
    		anchorPane.getChildren().setAll(pane);
    	}
    	else if(event.getSource()==reportStudents1 )
    	{
    		AnchorPane pane=FXMLLoader.load(getClass().getResource("../Fxmls/raport.fxml"));
    		anchorPane.getChildren().setAll(pane);
    	}
    	else if(event.getSource()==searchStudents1 )
    	{
    		AnchorPane pane=FXMLLoader.load(getClass().getResource("../Fxmls/EditDeleteUser.fxml"));
    		anchorPane.getChildren().setAll(pane);
    	}
    	else if(event.getSource()==registerStudents1)
    	{
    		AnchorPane pane=FXMLLoader.load(getClass().getResource("../Fxmls/studentregister.fxml"));
    		anchorPane.getChildren().setAll(pane);
    	}
    	else if(event.getSource()==sendMessage1)
    	{
    		AnchorPane pane=FXMLLoader.load(getClass().getResource("../Fxmls/FXMLperSend.fxml"));
    		anchorPane.getChildren().setAll(pane);
    	}
    	else if(event.getSource()==contact1)
    	{
    		AnchorPane pane=FXMLLoader.load(getClass().getResource("../Fxmls/ContactUs.fxml"));
    		anchorPane.getChildren().setAll(pane);
    	}
	
    }

   
    
    @Override
    public void initialize(URL url,ResourceBundle rb) {
    	combobox();
    	
    }


}
