package application;
import javafx.event.ActionEvent;


import javafx.scene.control.Alert;
import java.io.File;
import java.io.FileFilter;
import java.net.MalformedURLException;
import java.nio.file.Path;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.plaf.OptionPaneUI;

import com.sun.glass.events.KeyEvent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import com.mysql.jdbc.Statement;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RegisterController{

	Hashing hash=new Hashing();

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
    private TextField txtAdresa;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtTel;


    @FXML
    private ComboBox<String> shtetiBox;

    @FXML
    private ComboBox<String> qytetiBox;

    @FXML
    private RadioButton rregullt;

    @FXML
    private ToggleGroup statusi;

    @FXML
    private RadioButton korrespodence;

    @FXML
    private ComboBox<String> fakultetiBox;

    @FXML
    private ComboBox<String> drejtimiBox;

    @FXML
    private ComboBox<String> niveliBox;


    @FXML
    private RadioButton male;

    @FXML
    private ToggleGroup gender;

    @FXML
    private RadioButton female;
    
    @FXML
    private TextField txtEmri;

    @FXML
    private TextField txtPrindi;

    @FXML
    private TextField txtMbiemri;

    @FXML
    private TextField txtPersonalNr;

    @FXML
    private DatePicker txtDitelindja;

    
    @FXML
    private Button btnzgjedhfoto;

    @FXML
    private Button regjistro;

    @FXML
    private ImageView foto;

    
    @FXML
    private Label lblError;

    
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

    Image image1;
    @FXML
    void zgjedhFoto() {

        final FileChooser fileChooser = new FileChooser();

        final Button openButton = new Button("Choose Background Image");
            File file = fileChooser.showOpenDialog(null);
            if (file != null) {
             
            	Image image1 = new Image(file.toURI().toString());
                
            	
                ImageView ip = new ImageView(image1);
                
                foto.setImage(image1);
                
                
                
    }
              

    }
    @FXML
    String gender() {
		String gender="null";
		if(male.isSelected()) {
			gender=male.getText();
		}
		else if(female.isSelected()) {
			gender=female.getText();
		}
		return gender;

    }

    
    @FXML
    String statusi() {
		String statusi="null";
		if(rregullt.isSelected()) {
			statusi=rregullt.getText();
		}
		else if(korrespodence.isSelected()) {
			statusi=korrespodence.getText();
		}
		return statusi;

    }




    	   @FXML
    	    void regjistroStudentet(ActionEvent event)throws SQLException, IOException {
    
    	
    		   try {
    			   	DatabaseConnection databaseConnection = new DatabaseConnection();
    				//Connection connection = databaseConnection.startConnection();
    				java.sql.Connection connection=null;
    				connection=databaseConnection.startConnection();//
    				java.sql.Statement st = connection.createStatement();
    				
    				
       				String emri=txtEmri.getText();
    				String mbiemri = txtMbiemri.getText();
    				String prindi = txtPrindi.getText();
    				String nrPersonal = txtPersonalNr.getText();
    				String ditelindja =txtDitelindja.getEditor().getText();
    				String ditelindja1="mergogr";//masnej kthe nstring qetu
    				SingleSelectionModel<String> shteti = shtetiBox.getSelectionModel();
    				String shteti1=shteti.getSelectedItem();
    				SingleSelectionModel<String> qyteti = qytetiBox.getSelectionModel();
    				String qyteti1=qyteti.getSelectedItem();//////////////
    				String adresa = txtAdresa.getText();
    				String tel = txtTel.getText();
    				String email = txtEmail.getText();
    			 
    			    String gjinia=gender();
    			    String status=statusi();
    				
    				SingleSelectionModel<String> fakulteti = fakultetiBox.getSelectionModel();
    				String fakulteti1=fakulteti.getSelectedItem();//////////////
    				SingleSelectionModel<String> drejtimi = drejtimiBox.getSelectionModel();
    				String drejtimi1=drejtimi.getSelectedItem();//////////////
    				SingleSelectionModel<String> niveli = niveliBox.getSelectionModel();
    				String niveli1=niveli.getSelectedItem();//////////////
    			    String foto="null";// qeto leje qeshtu se smun qon foto ndatabase.
    					

    				
    				if (emri.isEmpty() || mbiemri.isEmpty() || prindi.isEmpty() || nrPersonal.isEmpty() || ditelindja1.isEmpty()
    						|| adresa.isEmpty() || email.isEmpty() ) {
    						lblError.setText("Ju lutem plotesoni te dhenat!");
    					} else if (nrPersonal.length() > 10) {
    						lblError.setText("Nr personal jo valid");
    					}  else if (!tel.matches("^\\+\\d{11}$")) {
    						lblError.setText("Nr.Telefonit eshte gabim!");
    						txtTel.requestFocus();
    					} else if (!email.matches("^[A-Za-z0-9._\\-]+@[A-Za-z]+.[A-Za-z]{2,3}$")) {
    						lblError.setText("Emaili eshte gabim!");
    						txtEmail.requestFocus();
    					}
    				
    				
    					else if(lblError.getText().isEmpty()) {

    			
    				String query="insert into studenti (semri, smbiemri, sprindi, snrpersonal, sditelindja,sshteti, sqyteti,sadresa, stel, semail,sgjinia, sfakulteti, sdrejtimi, sstatusi, sniveli,sfoto) values ('"+emri+"', '"+mbiemri+"' , '"+prindi+"' ,'"+nrPersonal+"' ,'"+ditelindja+"' ,'"+shteti1+"' ,'"+qyteti1+"' ,'"+adresa+"' ,'"+tel+"' ,'"+email+"' ,'"+gjinia+"' ,'"+fakulteti1+"' ,'"+drejtimi1+"' ,'"+status+"' ,'"+niveli1+"' ,'"+foto+"')";
					int rs = st.executeUpdate(query);
					
					// Regjistrimi i studentit si perdorues i sistemit

					// Gjenerimi i salted hash
					String saltValue =hash.saltGenerator();
					String fjalekalimiHash = nrPersonal + saltValue;
					fjalekalimiHash =hash.hashString(fjalekalimiHash, "SHA-1");

					String queryId = "insert into perdoruesi(pid,pemail,pfjalekalimi,psalt,ptipi) values ('"+nrPersonal+"', '"+email+"' , '"+fjalekalimiHash+"' ,'"+saltValue+"' ,'"+"s"+"' )"; 
					int r=st.executeUpdate(queryId);



				
    			    JOptionPane.showMessageDialog(null,"Studenti u regjistrua me sukses!");
 		
    			    txtEmri.setText("");
    				txtMbiemri.setText("");
    				txtPrindi.setText("");
    				txtPersonalNr.setText("");
    				txtDitelindja.getEditor().setText("");
    				txtTel.setText("");
    				shtetiBox.setValue("Kosove");
    				drejtimiBox.setValue("Automatikë e Kompjuterizuar dhe Robotikë");
    				niveliBox.setValue("Bachelor");
    				txtEmail.setText("");
    				txtAdresa.setText("");
    				male.setSelected(true);
    				female.setSelected(false);
    				rregullt.setSelected(true);
    				korrespodence.setSelected(false);
    					
    					}
    				}
						catch (Exception e1) {
							// TODO: handle exception
						}
						
					
    				
    	    }
	
    	  


    	    }

    		 

    		   
