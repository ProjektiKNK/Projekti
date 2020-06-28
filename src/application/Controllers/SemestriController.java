package application.Controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class SemestriController {

	
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

package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

public class SemestriController implements Initializable{

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
    private Button btnKerko;

    @FXML
    private Button btnRegjistro;

    @FXML
    private TextField stdID;

    @FXML
    private Label lblData;

    @FXML
    private Label lblKoha;

    @FXML
    private TableView<ModelTable> tblStudentet;

    @FXML
    private TableColumn<ModelTable, String> colID;

    @FXML
    private TableColumn<ModelTable, String> colEmri;

    @FXML
    private TableColumn<ModelTable, String> colMbiemri;

    @FXML
    private TableColumn<ModelTable, String> colDtl;

    @FXML
    private TableColumn<ModelTable, String> colFk;

    @FXML
    private TableColumn<ModelTable, String> colSemestri;

    @FXML
    private TableColumn<ModelTable, String> colGjinia;

    @FXML
    private TableColumn<ModelTable, String> colLloji;

    @FXML
    private TableColumn<ModelTable, String> colData;

    @FXML
    private TableColumn<ModelTable, String> colPaguar;
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
    	updateTable("SELECT studentet.sid, studentet.semri, studentet.smbiemri, studentet.sditelindja, fakultetet.femri, studentet.ssemestri, studentet.sgjinia, fletpagesat.flloji, fletpagesat.fdata, fletpagesat.fpaguar FROM studentet LEFT JOIN fletpagesat ON studentet.sid = fletpagesat.fstudenti LEFT JOIN fakultetet ON studentet.sfakulteti = fakultetet.fid");
    }
    
    @FXML
    void kerkoStudentin(ActionEvent event) 
    {
    	updateTable("SELECT studentet.sid, studentet.semri, studentet.smbiemri, studentet.sditelindja, fakultetet.femri, studentet.ssemestri, studentet.sgjinia, fletpagesat.flloji, fletpagesat.fdata, fletpagesat.fpaguar FROM studentet LEFT JOIN fletpagesat ON studentet.sid = fletpagesat.fstudenti LEFT JOIN fakultetet ON studentet.sfakulteti = fakultetet.fid WHERE studentet.sid =" +stdID.getText());
    }

    @FXML
    void regjistroSemestrin(ActionEvent event) throws SQLException 
    {
    	Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/spms",
                "root", "passwordiMySQL");
    	PreparedStatement pst;
    	ResultSet res;
    	
    	int id = Integer.parseInt(stdID.getText());
    	
    	if (id != 0) {
			String paguar = "";
			String perdorur="";
			String studenti = "";
			String semestri = "";
			int semestriint = 1;
			try {
				String sql = "Select * from studentet s,fletpagesat fl,qytetet q,fakultetet f "
						+ "where s.sid=fl.fstudenti and s.sqyteti=q.qid and f.fid=s.sfakulteti and s.sid='" + id
						+ "'";
				pst = conn.prepareStatement(sql);
				res = pst.executeQuery();
				while (res.next()) {
					paguar = res.getString("fpaguar");
					perdorur=res.getString("fperdorur");
					studenti = res.getString("semri") + " " + res.getString("smbiemri");
					semestri = res.getString("ssemestri");
					semestriint = Integer.parseInt(semestri);
					semestriint += 1;
					
				}
				pst.close();

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "InsertError");
			}

			if (semestriint != 1 && paguar.equals("PO") && perdorur.equals("0")) {
				try {
					String sql1 = "Update studentet set ssemestri='" + semestriint + "' where sid='" + id
							+ "' ";

					pst = conn.prepareStatement(sql1);
					pst.execute();
					updateTable("SELECT studentet.sid, studentet.semri, studentet.smbiemri, studentet.sditelindja, fakultetet.femri, studentet.ssemestri, studentet.sgjinia, fletpagesat.flloji, fletpagesat.fdata, fletpagesat.fpaguar FROM studentet LEFT JOIN fletpagesat ON studentet.sid = fletpagesat.fstudenti LEFT JOIN fakultetet ON studentet.sfakulteti = fakultetet.fid");
					pst.close();
					
					String sql2 = "Update fletpagesat set fperdorur=" + 1 + " where fstudenti=" + id;
					pst = conn.prepareStatement(sql2);
					pst.execute();
					pst.close();
					
					JOptionPane.showMessageDialog(null,
					"Student:" + studenti +" "+"regjistrom semestrin" + semestriint);

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "InsertError");
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "Student:" + studenti + "nuk regjistrohet");
			}
		}
    }
    
    
    public void updateTable(String sql)
	{
    	ObservableList<ModelTable> obList = FXCollections.observableArrayList();
    	
    	Connection conn;
    	ResultSet res;
    	try {
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/spms",
			        "root", "passwordiMySQL");
			res = conn.createStatement().executeQuery(sql);
		    while(res.next())
		    {
		    	obList.add(new ModelTable(res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getString(7),res.getString(8),res.getString(9),res.getString(10)));
		    }
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	colID.setCellValueFactory(new PropertyValueFactory<>("ID"));
    	colEmri.setCellValueFactory(new PropertyValueFactory<>("EMRI"));
    	colMbiemri.setCellValueFactory(new PropertyValueFactory<>("MBIEMRI"));
    	colDtl.setCellValueFactory(new PropertyValueFactory<>("DATELINDJA"));
    	colFk.setCellValueFactory(new PropertyValueFactory<>("FAKULTETI"));
    	colSemestri.setCellValueFactory(new PropertyValueFactory<>("SEMESTRI"));
    	colGjinia.setCellValueFactory(new PropertyValueFactory<>("GJINIA"));
    	colLloji.setCellValueFactory(new PropertyValueFactory<>("LLOJI"));
    	colData.setCellValueFactory(new PropertyValueFactory<>("DATA"));
    	colPaguar.setCellValueFactory(new PropertyValueFactory<>("PAGUAR"));
    	
    	tblStudentet.setItems(obList);
		
	}

}

    




