package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;


public class LoginController {

	@FXML
    private TextField txtusername;

    @FXML
    private PasswordField txtpassword;

    @FXML
    private Text lblstatus;
    
    @FXML
    private Button loginbutton;
   /* 
    * @FXML
    
    public void handleButtonAction(MouseEvent event) {
    	
    	
    	if(event.getSource()==loginbutton) {
    		try {
				Login(event);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    }
    
    public LoginController() {
    	con=DatabaseConnection.startConnection();
    }
    
    Connection con =null;
    PreparedStatement preparedStatement=null;
    ResultSet resultSet=null;
    private void Login(MouseEvent event) throws IOException {
    	String email=txtusername.getText().toString();
    	String password=txtpassword.getText().toString();
    	
    	//Query
    	String sql="Select * From studentet Where email= ? and password=?";
    	try {
			preparedStatement=con.prepareStatement(sql);
		    preparedStatement.setString(1,email);
		    preparedStatement.setString(2,password);
		    resultSet=preparedStatement.executeQuery();
		    if(!resultSet.next()) {
		    	lblstatus.setText("Enter correct email/password");
		    	
		    }
		    else {
		    	System.out.println("Login Successful");
		    }
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
    }
 */
}
