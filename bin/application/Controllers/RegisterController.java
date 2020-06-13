package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class RegisterController {
	ObservableList<String> shtetiList=FXCollections.observableArrayList("Kosov�","Shqiperi","Mali i Zi","Maqedoni");
	ObservableList<String> drejtimiList=FXCollections.observableArrayList("Automatik� e Kompjuterizuar dhe Robotik�","Elektroenergjetik�","Elektronik�"," Inxhinieri Kompjuterike","Telekomunikacion");
	ObservableList<String> niveliList=FXCollections.observableArrayList("Bachelor","Master","Doktoratur�");
	ObservableList<String> fakultetiList=FXCollections.observableArrayList("Fakulteti i Inxhinieris� Elektrike dhe Kompjuterike");
	ObservableList<String> kosoveList=FXCollections.observableArrayList("Prishtine","Skenderaj");

	
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
    private ChoiceBox shtetiBox;

    @FXML
    private ChoiceBox qytetiBox;

    @FXML
    private ChoiceBox fakultetiBox;

    @FXML
    private ChoiceBox drejtimiBox;

    @FXML
    private ChoiceBox niveliBox;
    
	@FXML
    private void initialize() {
    	shtetiBox.setValue("Kosov�");
    	shtetiBox.setItems(shtetiList);
    	drejtimiBox.setValue("Automatik� e Kompjuterizuar dhe Robotik�");
    	drejtimiBox.setItems(drejtimiList);
    	niveliBox.setValue("Bachelor");
    	niveliBox.setItems(niveliList);
    	fakultetiBox.setValue("Fakulteti i Inxhinieris� Elektrike dhe Kompjuterike");
    	fakultetiBox.setItems(fakultetiList);

    }
	

}
