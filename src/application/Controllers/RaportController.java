package application.Controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class RaportController {
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
    private TextField txtViti4;

    @FXML
    private TextField txtElektronike;

    @FXML
    private TextField txtAutomatike;

    @FXML
    private Label universiteti;

    @FXML
    private TextField txtViti1;

    @FXML
    private TextField txtViti2;

    @FXML
    private TextField txtElektroenergjetike;

    @FXML
    private TextField txtTelekomunikacion;

    @FXML
    private Label raport;

    @FXML
    private TextField txtKompjuterike;

    @FXML
    private TextField txtMeshkuj;

    @FXML
    private TextField txtFemra;

    @FXML
    private Button gjenero;

    @FXML
    private Button ruaj;
    
    @FXML
    private TextField txtViti3;

    @FXML
    private TextField txtNumriTotal;

    @FXML
    private Label editmyProfile;
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
	 public void Btngjenero(ActionEvent actionEvent) throws SQLException {

        Connection conn = DatabaseConnection.getConnection();

        ResultSet res;
        PreparedStatement pst;
        try {
            String query = "select count(*) as 'Totali' from studentet";
            pst = conn.prepareStatement(query);
            res = pst.executeQuery();
            while (res.next()) {
                String rez = res.getString("Totali");
                txtNumriTotal.setText(rez);
            }


            //Viti i pare

            String query1 = "select count(*) as 'Totali' from studentet s where s.ssemestri = 1 or s.ssemestri = 2";
            pst = conn.prepareStatement(query1);
            res = pst.executeQuery();
            while (res.next()) {
                String rez = res.getString("Totali");
                txtViti1.setText(rez);
            }


            //Viti i dyte

            String query2 = "select count(*) as 'Totali' from studentet s where s.ssemestri = 3 or s.ssemestri = 4";
            pst = conn.prepareStatement(query2);
            res = pst.executeQuery();
            while (res.next()) {
                String rez = res.getString("Totali");
                txtViti2.setText(rez);
            }


            //Viti i trete
            String query3 = "select count(*) as 'Totali' from studentet s where s.ssemestri = 5 or s.ssemestri = 6";
            pst = conn.prepareStatement(query3);
            res = pst.executeQuery();
            while (res.next()) {
                String rez = res.getString("Totali");
                txtViti3.setText(rez);
            }


            //Viti i katert
            String query4 = "select count(*) as 'Totali' from studentet s where s.ssemestri = 7 or s.ssemestri = 8";
            pst = conn.prepareStatement(query4);
            res = pst.executeQuery();
            while (res.next()) {
                String rez = res.getString("Totali");
                txtViti4.setText(rez);
            }


            //Inxhinieri Kompjuterike
            String query5 = "select count(*) as 'Totali' from studentet s where s.sdrejtimi = 1";
            pst = conn.prepareStatement(query5);
            res = pst.executeQuery();
            while (res.next()) {
                String rez = res.getString("Totali");
                txtKompjuterike.setText(rez);
            }


            //Telekomunikacion

            String query6 = "select count(*) as 'Totali' from studentet s where s.sdrejtimi = 3";
            pst = conn.prepareStatement(query6);
            res = pst.executeQuery();
            while (res.next()) {
                String rez = res.getString("Totali");
                txtTelekomunikacion.setText(rez);
            }

            //Elektroenergjetike
            String query7 = "select count(*) as 'Totali' from studentet s where s.sdrejtimi = 2";
            pst = conn.prepareStatement(query7);
            res = pst.executeQuery();
            while (res.next()) {
                String rez = res.getString("Totali");
                txtElektroenergjetike.setText(rez);
            }


            //Elektronike
            String query8 = "select count(*) as 'Totali' from studentet s where s.sdrejtimi = 4";
            pst = conn.prepareStatement(query8);
            res = pst.executeQuery();
            while (res.next()) {
                String rez = res.getString("Totali");
                txtElektronike.setText(rez);
            }


            //Automatike
            String query9 = "select count(*) as 'Totali' from studentet s where s.sdrejtimi = 5";
            pst = conn.prepareStatement(query9);
            res = pst.executeQuery();
            while (res.next()) {
                String rez = res.getString("Totali");
                txtAutomatike.setText(rez);
            }


            //Gjithesejt meshkuj
            String query11 = "select count(*) as 'Totali' from studentet s where s.sgjinia = 'M'";
            pst = conn.prepareStatement(query11);
            res = pst.executeQuery();
            while (res.next()) {
                String rez = res.getString("Totali");
                txtMeshkuj.setText(rez);
            }

            //gjithesejt femra
            String query12 = "select count(*) as 'Totali' from studentet s where s.sgjinia = 'F'";
            pst = conn.prepareStatement(query12);
            res = pst.executeQuery();
            while (res.next()) {
                String rez = res.getString("Totali");
                txtFemra.setText(rez);
            }

      
    }

}
