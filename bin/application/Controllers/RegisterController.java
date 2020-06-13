package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class RegisterController {
	ObservableList<String> shtetiList=FXCollections.observableArrayList("Kosovë","Shqiperi","Mali i Zi","Maqedoni");
	ObservableList<String> drejtimiList=FXCollections.observableArrayList("Automatikë e Kompjuterizuar dhe Robotikë","Elektroenergjetikë","Elektronikë"," Inxhinieri Kompjuterike","Telekomunikacion");
	ObservableList<String> niveliList=FXCollections.observableArrayList("Bachelor","Master","Doktoraturë");
	ObservableList<String> fakultetiList=FXCollections.observableArrayList("Fakulteti i Inxhinierisë Elektrike dhe Kompjuterike");
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
    	shtetiBox.setValue("Kosovë");
    	shtetiBox.setItems(shtetiList);
    	drejtimiBox.setValue("Automatikë e Kompjuterizuar dhe Robotikë");
    	drejtimiBox.setItems(drejtimiList);
    	niveliBox.setValue("Bachelor");
    	niveliBox.setItems(niveliList);
    	fakultetiBox.setValue("Fakulteti i Inxhinierisë Elektrike dhe Kompjuterike");
    	fakultetiBox.setItems(fakultetiList);

    }
	

}
