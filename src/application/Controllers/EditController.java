package application.Controllers;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import application.DatabaseConnection;
import javafx.scene.control.Alert;

import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.util.Pair;

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
    private TableView<ModelTable> tableview;
    
    @FXML
    private TableColumn<ModelTable,String>col_id;
    
    @FXML
    private TableColumn<ModelTable,String>col_emri;
    @FXML
    private TableColumn<ModelTable,String>col_eprindit;
    @FXML
    private TableColumn<ModelTable,String>col_mbiemri;
    @FXML
    private TableColumn<ModelTable,String>col_fakulteti;
    @FXML
    private TableColumn<ModelTable,String>col_qyteti;
    @FXML
    private TableColumn<ModelTable,String>col_nrpersonal;
    @FXML
    private TableColumn<ModelTable,String>col_adresa;
    @FXML
    private TableColumn<ModelTable,String>col_tel;
    @FXML
    private TableColumn<ModelTable,String>col_email;
    @FXML
    private TableColumn<ModelTable,String>col_gjinia;
    @FXML
    private ComboBox<String> choicebox; 
    @FXML
    private TextField txtFilter;
    @FXML
    private Button butoni;
    @FXML
    private Button perpuno;
    @FXML
    private Button fshije;
   
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
        
    ObservableList<ModelTable>oblist = FXCollections.observableArrayList();

 
    public void edito() {
    	
    	EventHandler<ActionEvent> evennt = new EventHandler<ActionEvent>() { 
	        public void handle (ActionEvent e) 
	        { editoStudentet(); 
	        } 
	    }; 
	    txtFilter.setOnAction(evennt);
		try {
    	 EventHandler<ActionEvent> event = 
	    	         new EventHandler<ActionEvent>() { 
	    	   public void handle(ActionEvent e) 
	    	   { 
	    	       System.out.println(choicebox.getValue());
	    	       
	    	    	   editoStudentet();          
	    	   } 
	    	};
butoni.setOnAction(event);
		}
		

		 catch (Exception e) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Information Dialog");
				alert.setHeaderText(null);
				alert.setContentText("Gabim gjate kerkimi!");

				alert.showAndWait();
			}
    }
     public  void editoStudentet()
	{	  
	  String subquery = "select * from studentet ";
	  Connection conn= DatabaseConnection.getConnection();
          ResultSet rs;
	  try {
	     if(String.valueOf(txtFilter.getText()).isEmpty())
	     {
             oblist.removeAll(oblist);
	     rs = conn.createStatement().executeQuery(subquery);
	     while (rs.next())	 {
		 oblist.add(new ModelTable(rs.getString("sid"),rs.getString("semri"),rs.getString("sprindi"),rs.getString("smbiemri"),rs.getString("sfakulteti"),rs.getString("sqyteti"),rs.getString("snrpersonal"),rs.getString("sadresa"),rs.getString("stel"),rs.getString("semail"),rs.getString("sgjinia")));
		 }
	     }
	    else if(choicebox.getValue()=="ID")
	     {
		oblist.removeAll(oblist);
		rs = conn.createStatement().executeQuery(subquery + " WHERE sid like '%" + String.valueOf(txtFilter.getText()) + "%'");
        	while (rs.next())	
		{
		 oblist.add(new ModelTable(rs.getString("sid"),rs.getString("semri"),rs.getString("sprindi"),rs.getString("smbiemri"),rs.getString("sfakulteti"),rs.getString("sqyteti"),rs.getString("snrpersonal"),rs.getString("sadresa"),rs.getString("stel"),rs.getString("semail"),rs.getString("sgjinia")));
		 }
	        if(oblist.isEmpty())
		 {
		  Alert alert = new Alert(AlertType.INFORMATION);
	          alert.setTitle("Information Dialog");
		  alert.setHeaderText(null);
		  alert.setContentText("Gabim gjate kerkimi!");
                  alert.showAndWait();
		 }
		 tableview.setItems(oblist);
	     }
	   else if (choicebox.getValue()=="Emri")
	     {
		oblist.removeAll(oblist);
		rs = conn.createStatement().executeQuery(subquery+" WHERE semri like '%" + String.valueOf(txtFilter.getText()) + "%'" );
					
	       while (rs.next())	 
	       {
		 oblist.add(new ModelTable(rs.getString("sid"),rs.getString("semri"),rs.getString("sprindi"),rs.getString("smbiemri"),rs.getString("sfakulteti"),rs.getString("sqyteti"),rs.getString("snrpersonal"),rs.getString("sadresa"),rs.getString("stel"),rs.getString("semail"),rs.getString("sgjinia")));
	       }
	      if(oblist.isEmpty())
	      {
                Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information Dialog");
		alert.setHeaderText(null);
		alert.setContentText("Gabim gjate kerkimi!");
                alert.showAndWait();
	       }
	      tableview.setItems(oblist);
	   }
					
	 else if (choicebox.getValue()=="Mbiemri")
	 {
	   oblist.removeAll(oblist);
	   rs = conn.createStatement().executeQuery(subquery+" WHERE smbiemri like '%" + String.valueOf(txtFilter.getText()) + "%'" );
	   while (rs.next())
	   {
	     oblist.add(new ModelTable(rs.getString("sid"),rs.getString("semri"),rs.getString("sprindi"),rs.getString("smbiemri"),rs.getString("sfakulteti"),rs.getString("sqyteti"),rs.getString("snrpersonal"),rs.getString("sadresa"),rs.getString("stel"),rs.getString("semail"),rs.getString("sgjinia")));
	   }
	   if(oblist.isEmpty())
	   {
	     Alert alert = new Alert(AlertType.INFORMATION);
	     alert.setTitle("Information Dialog");
	     alert.setHeaderText(null);
	     alert.setContentText("Gabim gjate kerkimit!");
	     alert.showAndWait();
	    }
	   tableview.setItems(oblist);
	}
	else if (choicebox.getValue()=="Email") 
	{
	   oblist.removeAll(oblist);
	   rs = conn.createStatement().executeQuery(subquery+" WHERE semail like '%" + String.valueOf(txtFilter.getText()) + "%'" );
	   while (rs.next())
	   {
	    oblist.add(new ModelTable(rs.getString("sid"),rs.getString("semri"),rs.getString("sprindi"),rs.getString("smbiemri"),rs.getString("sfakulteti"),rs.getString("sqyteti"),rs.getString("snrpersonal"),rs.getString("sadresa"),rs.getString("stel"),rs.getString("semail"),rs.getString("sgjinia")));
	   }
	  if(oblist.isEmpty())
	  {
	     Alert alert = new Alert(AlertType.INFORMATION);
	     alert.setTitle("Information Dialog");
	     alert.setHeaderText(null);
	     alert.setContentText("Gabim gjate kerkimi!");
             alert.showAndWait();
	   }
	   tableview.setItems(oblist);
	 }
	 else if (choicebox.getValue()=="Qyteti") 
	 {
	  oblist.removeAll(oblist);
	  rs = conn.createStatement().executeQuery(subquery+" WHERE sqyteti like '%" + String.valueOf(txtFilter.getText()) + "%'" );
	  while (rs.next())
	  {
	      oblist.add(new ModelTable(rs.getString("sid"),rs.getString("semri"),rs.getString("sprindi"),rs.getString("smbiemri"),rs.getString("sfakulteti"),rs.getString("sqyteti"),rs.getString("snrpersonal"),rs.getString("sadresa"),rs.getString("stel"),rs.getString("semail"),rs.getString("sgjinia")));
	  }
	  if(oblist.isEmpty())
	  {
	      Alert alert = new Alert(AlertType.INFORMATION);
	      alert.setTitle("Information Dialog");
	      alert.setHeaderText(null);
	      alert.setContentText("Gabim gjate kerkimi!");
              alert.showAndWait();
	   }
	   tableview.setItems(oblist);
	 }
	 else if (choicebox.getValue()=="Ditelindja")
	 {
	   oblist.removeAll(oblist);
	   rs = conn.createStatement().executeQuery(subquery+" WHERE sditelindja like '%" + String.valueOf(txtFilter.getText()) + "%'" );				
	   while (rs.next())
	   {
	      oblist.add(new ModelTable(rs.getString("sid"),rs.getString("semri"),rs.getString("sprindi"),rs.getString("smbiemri"),rs.getString("sfakulteti"),rs.getString("sqyteti"),rs.getString("snrpersonal"),rs.getString("sadresa"),rs.getString("stel"),rs.getString("semail"),rs.getString("sgjinia")));
	     
	   }
	   if(oblist.isEmpty())
	   {
	      Alert alert = new Alert(AlertType.INFORMATION);
	      alert.setTitle("Information Dialog");
	      alert.setHeaderText(null);
	      alert.setContentText("Gabim gjate kerkimi!");
              alert.showAndWait();
	   }
           tableview.setItems(oblist);
	 }
         else if (choicebox.getValue()=="Fakulteti") 
	 {
	    oblist.removeAll(oblist);
	    rs = conn.createStatement().executeQuery(subquery+" WHERE sfakulteti like '%" + String.valueOf(txtFilter.getText()) + "%'" );
            while (rs.next())
	    {
	       oblist.add(new ModelTable(rs.getString("sid"),rs.getString("semri"),rs.getString("sprindi"),rs.getString("smbiemri"),rs.getString("sfakulteti"),rs.getString("sqyteti"),rs.getString("snrpersonal"),rs.getString("sadresa"),rs.getString("stel"),rs.getString("semail"),rs.getString("sgjinia")));
	    }
           if(oblist.isEmpty())
	   {
	       Alert alert = new Alert(AlertType.INFORMATION);
	       alert.setTitle("Information Dialog");
	       alert.setHeaderText(null);
	       alert.setContentText("Gabim gjate kerkimi!");
               alert.showAndWait();
	   }
	   tableview.setItems(oblist);
	}
	
     }
					
					
     catch (Exception e)
     {
	Alert alert = new Alert(AlertType.INFORMATION);
	alert.setTitle("Information Dialog");
	alert.setHeaderText(null);
	alert.setContentText("Gabim gjate kerkimi!");
	alert.showAndWait();
      }
				    
  } 
		
  public void onEdit() {
			       
         ModelTable selectedPerson = tableview.getSelectionModel().getSelectedItem();
	 String subquery = "Delete from studentet  WHERE sid = ?";
	 Connection conn= DatabaseConnection.getConnection();
   try {
	
	 PreparedStatement statement = conn.prepareStatement("DELETE FROM studentet WHERE sid = ?");
	 statement.setString(1, selectedPerson.getId());
	 statement.executeUpdate();
	Alert alert = new Alert(AlertType.INFORMATION);
alert.setTitle("Information Dialog");
alert.setHeaderText(null);
alert.setContentText("U fshi studenti i selektuar !");

alert.showAndWait();
tableview.getItems().removeAll(tableview.getSelectionModel().getSelectedItem());
	 tableview.getItems().removeAll(tableview.getSelectionModel().getSelectedItem());
							  
							   
	 }
    catch (Exception e) {
	Alert alert = new Alert(AlertType.INFORMATION);
	alert.setTitle("Information Dialog");
	alert.setHeaderText(null);
	alert.setContentText("Selektoni studentin qe doni ta fshini");
	alert.showAndWait();
	}    
	 }


public void actionPerformed(ActionEvent e)
{
try {


Connection conn= DatabaseConnection.getConnection();

ModelTable selectedPerson = tableview.getSelectionModel().getSelectedItem();

 

try {

  String i= selectedPerson.getId();
  String sql = "select * from studentet where sid='" + i + "'";
PreparedStatement pst = conn.prepareStatement(sql);
ResultSet res = pst.executeQuery();
while (res.next()) {
Dialog<Pair<String, String>> dialog = new Dialog<>();
GridPane grid = new GridPane();
grid.setHgap(10);
grid.setVgap(10);
grid.setPadding(new Insets(20, 150, 10, 10));

TextField username = new TextField();
username.setPromptText("Emri");
username.setText(res.getString("semri"));
TextField mbiemri = new TextField();
mbiemri.setPromptText("Mbiemri");
mbiemri.setText(res.getString("smbiemri"));
TextField email = new TextField();
email.setPromptText("Email");
email.setText(res.getString("semail"));
TextField tel = new TextField();
tel.setPromptText("Tel");
tel.setText(res.getString("stel"));

grid.add(new Label("Emri:"), 0, 0);
grid.add(username, 1, 0);
grid.add(new Label("Mbiemri:"), 0, 1);
grid.add(mbiemri, 1, 1);
grid.add(new Label("Email:"), 0, 2);
grid.add(email, 1, 2);
grid.add(new Label("Tel:"), 0, 3);
grid.add(tel, 1, 3);
dialog.setTitle("Edito");

  ButtonType loginButtonType = new ButtonType("Update", ButtonData.OK_DONE);
  dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);
  dialog.setResultConverter(dialogButton -> {
   if (dialogButton == loginButtonType) {
    String sqll = "UPDATE studentet SET semri='" + username.getText() + "', " + "smbiemri='"
+ mbiemri.getText() + "',"
+ "stel ='" + tel.getText() + "'," + "semail ='" + email.getText()
+ "' where sid='" + selectedPerson.getId() + "'";
PreparedStatement pstt;
try {
pstt = conn.prepareStatement(sqll);
pstt.execute();

pstt.close();
} catch (SQLException e1) {
// TODO Auto-generated catch block
e1.printStackTrace();
}
oblist.removeAll(oblist);
ResultSet rs;
try {
rs = conn.createStatement().executeQuery("Select * from studentet");

  while (rs.next()) {
  oblist.add(new ModelTable(rs.getString("sid"),rs.getString("semri"),rs.getString("sprindi"),rs.getString("smbiemri"),rs.getString("sfakulteti"),rs.getString("sqyteti"),rs.getString("snrpersonal"),rs.getString("sadresa"),rs.getString("stel"),rs.getString("semail"),rs.getString("sgjinia")));
  }
 
  Alert alert = new Alert(AlertType.INFORMATION);
  alert.setTitle("Information Dialog");
  alert.setHeaderText(null);
  alert.setContentText("Te dhenat per studentin "+ selectedPerson.getId()+" u ndryshuan .");

  alert.showAndWait();
}

catch (SQLException e1) {
// TODO Auto-generated catch block
e1.printStackTrace();
}
   }
   return null;
});

dialog.getDialogPane().setContent(grid);
Optional<Pair<String, String>> result = dialog.showAndWait();

}
pst.close();
} 
catch (Exception x) {
Alert alert = new Alert(AlertType.INFORMATION);
alert.setTitle("Information Dialog");
alert.setHeaderText(null);
alert.setContentText("Eshte shfaur nje gabim!\nSelekto dhe edito nje student .");

alert.showAndWait();
}

} 
catch (Exception o) {
Alert alert = new Alert(AlertType.INFORMATION);
alert.setTitle("Information Dialog");
alert.setHeaderText(null);
alert.setContentText("Selekto dhe edito nje student");

alert.showAndWait();
}

}
   


   
    
    @Override
    public void initialize(URL url,ResourceBundle rb) {
	    	col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
    col_emri.setCellValueFactory(new PropertyValueFactory<>("emri"));
    col_eprindit.setCellValueFactory(new PropertyValueFactory<>("eprindit"));
    col_fakulteti.setCellValueFactory(new PropertyValueFactory<>("fakulteti"));
    col_mbiemri.setCellValueFactory(new PropertyValueFactory<>("mbiemri"));
    col_qyteti.setCellValueFactory(new PropertyValueFactory<>("qyteti"));
    col_nrpersonal.setCellValueFactory(new PropertyValueFactory<>("nrpersonal"));
    col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
    col_tel.setCellValueFactory(new PropertyValueFactory<>("tel"));
    col_gjinia.setCellValueFactory(new PropertyValueFactory<>("gjinia"));
    col_adresa.setCellValueFactory(new PropertyValueFactory<>("adresa"));
    tableview.setItems(oblist);
    choicebox.getItems().addAll(lista);  
    edito();
    	
    }


}
