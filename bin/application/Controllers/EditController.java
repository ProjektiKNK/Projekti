package application;




import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class controller implements Initializable {

	ObservableList<String> lista=FXCollections.observableArrayList("ID", "Emri", "Mbiemri", "Email", "Qyteti", "Ditelindja", "Fakulteti" );
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
    private Label editmyProfile;

    @FXML
    private Label registerStudentsmain;

    @FXML
    private Label contactMain;
    @FXML
    private Label ReportStudentsMain;

    @FXML
    private Label searchStudentsMain;

    @FXML
    private Label registerSemesterMain;

    @FXML
    private Label sendMessageMain;
    @FXML
    private Label label;
    
   
    @FXML
    private ComboBox<String> choicebox;
    @FXML
    private void combobox() {
    	
    
    	choicebox.getItems().addAll(lista);
    	
    }
   
    
    @Override
    public void initialize(URL url,ResourceBundle rb) {
    	combobox();
    	
    }


}
