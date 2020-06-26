package application.Controllers;


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class RegisterController {
	
	ObservableList <String> shtetiList=FXCollections.observableArrayList("Kosove","Shqiperi","Mali i Zi","Maqedoni");
ObservableList<String> drejtimiList=FXCollections.observableArrayList("Automatik� e Kompjuterizuar dhe Robotik�","Elektroenergjetik�","Elektronik�"," Inxhinieri Kompjuterike","Telekomunikacion");
ObservableList<String> niveliList=FXCollections.observableArrayList("Bachelor","Master","Doktoratur�");
ObservableList<String> fakultetiList=FXCollections.observableArrayList("Fakulteti i Inxhinieris� Elektrike dhe Kompjuterike");
ObservableList<String> kosoveList=FXCollections.observableArrayList("De�an","Sharr",	"Hani i Elezit",	
"Ferizaji","Gjakov�","Gjilan",	"Drenas",	"Gra�anica","Burimi	","Juniku	","Ka�aniku","Dardana",	"Klina",	"Kllokot",	
"Fush� Kosov�",	"Albanik","Lipjani",	"Malishev�","Mamush�","Mitrovic�","Artana",	"Kastriot",	"Rahovec",
"Parteshi","Pej�",	"Prishtin�","Prizreni",	"Besiana",	"Ranillugu",	"Sk�nderaj",	
"Sht�rpca",	"Shtime",	"Therand�",	"Viti",	"Vushtrri"	,"Zubin Potok","Zve�an");

ObservableList<String> shqiperiList=FXCollections.observableArrayList("Tirana	","Durr�si","Shkodra"	,"Elbasani",
"Vlora"	,"Kor�a"	,"Fieri	","Berati	","Lushnja"	,"Pogradeci	","La�i"	,"Lezha	",
"Kuk�si	","Gjirokastra");
ObservableList<String> maliList=FXCollections.observableArrayList("Andrijevica","Bellopoja","Berana","Budua","�etina",
	"Danilovgradi","Golluboci","Herceg Novi","Koloshini","Kotorri","Mojkovaci","Nikshiqi","Plava","Plevla","Pluzhina");

	ObservableList<String> maqedoniaList=FXCollections.observableArrayList("Berova","Dell�eva","Ko�ani","Kamenica",	"Pe�eva	",
			"Probishtipi","Shtipi","Vinica");

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
    private Button btnzgjedhfoto;

    @FXML
    private Button regjistro;

    @FXML
    private ImageView foto;
    
    @FXML
    private void initialize() {	
		shtetiBox.setValue("Kosove");
        shtetiBox.setItems(shtetiList);
        qytetiBox.setValue("Skenderaj");
        qytetiBox.setItems(kosoveList);
          
    	drejtimiBox.setValue("Automatik� e Kompjuterizuar dhe Robotik�");
    	drejtimiBox.setItems(drejtimiList);
    	niveliBox.setValue("Bachelor");
    	niveliBox.setItems(niveliList);
    	fakultetiBox.setValue("Fakulteti i Inxhinieris� Elektrike dhe Kompjuterike");
    	fakultetiBox.setItems(fakultetiList);	    	   
	     
    }

    @FXML
    private void shtetiCheck() {
    	if(shtetiBox.getValue().equals("Kosove")) {
    		qytetiBox.setValue("Sk�nderaj");
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

    @FXML
    void zgjedhFoto() throws MalformedURLException {
    	JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		int returnValue = chooser.showOpenDialog(null);
		
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			
			File file = new File(chooser.getSelectedFile().getAbsolutePath());
			String localURL = file.toURI().toURL().toString();
			foto.setImage(new Image(localURL));
		}
	}
    
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


