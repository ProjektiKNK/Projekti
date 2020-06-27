import java.awt.Color;
import java.awt.Container;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javax.print.DocFlavor.URL;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;

import javafx.beans.binding.StringBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;

public class LoginController {

	@FXML
	private TextField txtusername;

	@FXML
	private PasswordField txtpassword;

	@FXML
    private Text lblStatus;
	@FXML
    private Slider s;
    @FXML
    private TextArea txtarea;
    @FXML
    private Label txtlabel;
	private String ngjyra="", ngjyraSfondit="", boldAttr="", italicAttr="",underlineAttr="", align="",htmlFontSize="";

	Hashing hash = new Hashing();

//Login Control
	public void button(ActionEvent actionEvent) throws SQLException, IOException {
		
		try {
			DatabaseConnection databaseConnection = new DatabaseConnection();
			Connection connection = databaseConnection.startConnection();
			
			String perdoruesi = txtusername.getText().toString();
			String password = txtpassword.getText().toString();
			
			String sql ="select * from perdoruesit where pid='"+perdoruesi+"'";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			
			
			if(resultSet.next()) {
				String fjalekalimi=password+resultSet.getString("psalt");
				fjalekalimi=hash.hashString(fjalekalimi, "SHA-1");
				if(perdoruesi.equals(resultSet.getString("pid")) && fjalekalimi.equals(resultSet.getString("pfjalekalimi"))) {
					if(resultSet.getString("ptipi").equals("s")) {
						//kalo te pjesa e studentit
						Stage primaryStage=new Stage();
						Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
						Scene scene=new Scene(root,400,400);	
						primaryStage.setTitle("Login");
						primaryStage.setScene(scene);
						primaryStage.show();
						
					}
					else if(resultSet.getString("ptipi").equals("r")) {
						Stage primaryStage=new Stage();
						Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
						Scene scene=new Scene(root,400,400);
				
						primaryStage.setTitle("Main");
						primaryStage.setScene(scene);
						primaryStage.show();
					}
				}
			}
			else 
			{
				
				 lblStatus.setText("Gabim , te perdoruesi ose fjalekalimi");
			}
			}
		 catch (Exception e) {
			
			 
			Alert failAlert = new Alert(Alert.AlertType.ERROR);
			failAlert.setTitle("Gabim:Lidhja me databaze deshtoi");
			failAlert.setContentText("Ju lutem provoni perseri me vone");
			failAlert.setHeaderText(null);
			failAlert.showAndWait();
			
		}

	}

	//Forgot Password
	@FXML
    public void button1(ActionEvent event) throws IOException {
		Stage primaryStage=new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("ForgotPassword.fxml"));
		Scene scene=new Scene(root,330,500);

		primaryStage.setTitle("Reseto Fjalekalimin");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
		
		
	}

		
		
	
