package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;

public class RegisterController {
	ObservableList <String> shtetiList=FXCollections.observableArrayList("Kosove","Shqiperi","Mali i Zi","Maqedoni");
ObservableList<String> drejtimiList=FXCollections.observableArrayList("Automatikë e Kompjuterizuar dhe Robotikë","Elektroenergjetikë","Elektronikë"," Inxhinieri Kompjuterike","Telekomunikacion");
ObservableList<String> niveliList=FXCollections.observableArrayList("Bachelor","Master","Doktoraturë");
ObservableList<String> fakultetiList=FXCollections.observableArrayList("Fakulteti i Inxhinierisë Elektrike dhe Kompjuterike");
ObservableList<String> kosoveList=FXCollections.observableArrayList("Deçan","Sharr",	"Hani i Elezit",	
"Ferizaji","Gjakovë","Gjilan",	"Drenas",	"Graçanica","Burimi	","Juniku	","Kaçaniku","Dardana",	"Klina",	"Kllokot",	
"Fushë Kosovë",	"Albanik","Lipjani",	"Malishevë","Mamushë","Mitrovicë","Artana",	"Kastriot",	"Rahovec",
"Parteshi","Pejë",	"Prishtinë","Prizreni",	"Besiana",	"Ranillugu",	"Skënderaj",	
"Shtërpca",	"Shtime",	"Therandë",	"Viti",	"Vushtrri"	,"Zubin Potok","Zveçan");

ObservableList<String> shqiperiList=FXCollections.observableArrayList("Tirana	","Durrësi","Shkodra"	,"Elbasani",
"Vlora"	,"Korça"	,"Fieri	","Berati	","Lushnja"	,"Pogradeci	","Laçi"	,"Lezha	",
"Kukësi	","Gjirokastra");
ObservableList<String> maliList=FXCollections.observableArrayList("Andrijevica","Bellopoja","Berana","Budua","Çetina",
	"Danilovgradi","Golluboci","Herceg Novi","Koloshini","Kotorri","Mojkovaci","Nikshiqi","Plava","Plevla","Pluzhina");

	ObservableList<String> maqedoniaList=FXCollections.observableArrayList("Berova","Dellçeva","Koçani","Kamenica",	"Peçeva	",
			"Probishtipi","Shtipi","Vinica");

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
    private ComboBox<String> shtetiBox;

    @FXML
    private ComboBox<String> qytetiBox;

    @FXML
    private ToggleGroup statusi;

    @FXML
    private ComboBox<String> fakultetiBox;

    @FXML
    private ComboBox<String> drejtimiBox;

    @FXML
    private ComboBox<String> niveliBox;

    @FXML
    private ToggleGroup gender;
    
    
	@FXML
    private void initialize() {	
		shtetiBox.setValue("Kosove");
        shtetiBox.setItems(shtetiList);
        qytetiBox.setValue("Skenderaj");
        qytetiBox.setItems(kosoveList);
          
    	drejtimiBox.setValue("Automatikë e Kompjuterizuar dhe Robotikë");
    	drejtimiBox.setItems(drejtimiList);
    	niveliBox.setValue("Bachelor");
    	niveliBox.setItems(niveliList);
    	fakultetiBox.setValue("Fakulteti i Inxhinierisë Elektrike dhe Kompjuterike");
    	fakultetiBox.setItems(fakultetiList);	    	   
	     
    }
	
	@FXML
	   private void shtetiCheck() {
	    	if(shtetiBox.getValue().equals("Kosove")) {
	    		qytetiBox.setValue("Skënderaj");
	    		qytetiBox.setItems(kosoveList);
	    	}
	    	else if(shtetiBox.getValue().equals("Shqiperi")) {
	    		qytetiBox.setValue("Tirana");
	    		qytetiBox.setItems(shqiperiList);
	    	}
	    	else if(shtetiBox.getValue().equals("Mali i Zi")) {
	    		qytetiBox.setValue("Plava");
	    		qytetiBox.setItems(maliList);
	    	}
	    	else {
	    		qytetiBox.setValue("Berova");
	    		qytetiBox.setItems(maqedoniaList);
	    		
	    	}

}
}
