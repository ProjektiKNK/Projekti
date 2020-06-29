import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;

public class ChangeDetails { 

    @FXML
    private TextField NdryshoAdresen;

    
	@FXML
    private TextField NderroNumrin;

	  @FXML
	    private TextField EmailIri;

	    @FXML
	    void RuajEmailAdresen(ActionEvent event) {
	    	try {
	    	DatabaseConnection databaseConnection = new DatabaseConnection();
	    	Connection connection = databaseConnection.startConnection();
	    	//Merre perdoruesin nga Profili
	    	String perdoruesi="11800031";
	    	String emailIRi=EmailIri.getText();
	    	String sql ="select * from perdoruesit where pid='"+perdoruesi+"'";
	    	Statement statement = connection.createStatement();
	    	ResultSet resultSet = statement.executeQuery(sql);
	    	if(resultSet.next()) {
	    		
	    		
	    				String sql1 = "Update perdoruesit set pemail='" +emailIRi 
	    						+ "' where pid=" + perdoruesi + " ";
	    				Statement statement1 = connection.createStatement();
						statement1.executeUpdate(sql1);
	    			   
	    			    Alert alert=new Alert(AlertType.CONFIRMATION) ;
	    				alert.setContentText("Email Adresa u nderrua me sukses");
	    				alert.showAndWait();
	    			}
	    	else {
				Alert alert=new Alert(AlertType.ERROR) ;
				alert.setContentText("Personi nuk ekziston ne databaze");
				alert.showAndWait();
				}
	    	}
	    	catch (Exception e) {
	    		
	    		Alert alert=new Alert(AlertType.ERROR) ;
	    		alert.setContentText("Error:Gabim gjate nderrimit");
	    		alert.showAndWait();
			}
	    }

	    @FXML
	    void onBackClicked(MouseEvent event) {
         //Shto opsionin per me u kthy te Edit profile
	    }
	    @FXML
	    void RuajNumrin(ActionEvent event) {
	    	try{
	    	DatabaseConnection databaseConnection = new DatabaseConnection();
	    	Connection connection = databaseConnection.startConnection();
	    	//Merre perdoruesin nga Profili
	    	String perdoruesi="11800031";
	    	String NumriIRi=NderroNumrin.getText();
	    	String sql ="select * from perdoruesit where pid='"+perdoruesi+"'";
	    	Statement statement = connection.createStatement();
	    	ResultSet resultSet = statement.executeQuery(sql);
	    	if(resultSet.next()) {
	    		
	    				String sql1 = "Update studentet set stel='" +NumriIRi 
	    						+ "' where sid=" + perdoruesi + " ";
	    				Statement statement1 = connection.createStatement();
						statement1.executeUpdate(sql1);
	    			    Alert alert=new Alert(AlertType.CONFIRMATION) ;
	    				alert.setContentText("Numri i telefonit u nderrua me sukses");
	    				alert.showAndWait();
	    			}
	    	else {
				Alert alert=new Alert(AlertType.ERROR) ;
				alert.setContentText("Personi nuk ekziston ne databaze");
				alert.showAndWait();
				}
	    	}
	    	catch (Exception e) {
	    		Alert alert=new Alert(AlertType.ERROR) ;
	    		alert.setContentText("Error: Gabim gjate nderrimit");
	    		alert.showAndWait();
			}
	    }
	    @FXML
	    void RuajAdresen(ActionEvent event) {
	    	try{
		    	DatabaseConnection databaseConnection = new DatabaseConnection();
		    	Connection connection = databaseConnection.startConnection();
		    	//Merre perdoruesin nga Profili
		    	String perdoruesi="11800031";
		    	String AdresaERe=NdryshoAdresen.getText();
		    	String sql ="select * from perdoruesit where pid='"+perdoruesi+"'";
		    	Statement statement = connection.createStatement();
		    	ResultSet resultSet = statement.executeQuery(sql);
		    	if(resultSet.next()) {
		    		
		    				String sql1 = "Update studentet set sadresa='" +AdresaERe 
		    						+ "' where sid=" + perdoruesi + " ";
		    				Statement statement1 = connection.createStatement();
		    				
							statement1.executeUpdate(sql1);
		    			    Alert alert=new Alert(AlertType.CONFIRMATION) ;
		    				alert.setContentText("Adresa u nderrua me sukses");
		    				alert.showAndWait();
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
	    }
}

	
	
	


		
	