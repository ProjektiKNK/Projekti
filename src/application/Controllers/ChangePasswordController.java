import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ChangePasswordController {
	Hashing hash = new Hashing();
    @FXML
    private TextField FjalekalimiiVjeter;

    @FXML
    private TextField Fjalekalimiiri;

    @FXML
    private TextField KonfirmoFjalekalimin;
    @FXML
    private Text errorlabel;
    @FXML
    void onBackClicked(MouseEvent event) throws IOException {
    	AnchorPane pane=FXMLLoader.load(getClass().getResource("MyProfile.fxml"));
    	//Kalo Te Profili
    }
    
    
    @FXML
    void RuajFjalekalimin(ActionEvent event) {
    String FVjeter=FjalekalimiiVjeter.getText();
    String fiRi=FjalekalimiiVjeter.getText();
    String FKonfirm=FjalekalimiiVjeter.getText();
    
    DatabaseConnection databaseConnection = new DatabaseConnection();
	Connection connection = databaseConnection.startConnection();
	//Merre perdoruesin nga Profili
	String perdoruesi="11800031";
	try {
	String sql ="select * from perdoruesit where pid='"+perdoruesi+"'";
	Statement statement = connection.createStatement();
	ResultSet resultSet = statement.executeQuery(sql);
	

	if(resultSet.next()) {
		String fjalekalimi=FVjeter+resultSet.getString("psalt");
		fjalekalimi=hash.hashString(fjalekalimi, "SHA-1");
		if(perdoruesi.equals(resultSet.getString("pid")) && fjalekalimi.equals(resultSet.getString("pfjalekalimi"))) {
			if(fiRi.equals(FKonfirm)) {
				// Gjenerimi i salted hash
				String saltValue = hash.saltGenerator();
				String fjalekalimiHash = fiRi + saltValue;
				fjalekalimiHash = hash.hashString(fjalekalimiHash, "SHA-1");
				String sql1 = "Update perdoruesit set pfjalekalimi='" + fjalekalimiHash + "',psalt='" + saltValue
						+ "' where pid=" + perdoruesi + " ";
				Statement statement1 = connection.createStatement();

				statement1.executeUpdate(sql1);
				Alert alert=new Alert(AlertType.CONFIRMATION) ;
				alert.setContentText("Fjalekalimi eshte ndryshuar");
				alert.showAndWait();

			}
			else {
				errorlabel.setText("Fjalekalimet nuk perputhen");
			}}
		else {
			errorlabel.setText("Fjalekalimi i pasakte");
			}
	}
		
    else {
			Alert alert=new Alert(AlertType.ERROR) ;
			alert.setContentText("Personi nuk ekziston ne databaze");
			alert.showAndWait();
			
		}
	}
    catch (Exception e) {
    	Alert alert=new Alert(AlertType.ERROR) ;
		alert.setContentText("Error: Gabim gjate ndryshimit");
		alert.showAndWait();
	}
    }}