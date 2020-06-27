import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class WriteMessageControl implements Initializable{
	@FXML
    private ColorPicker colorpicker;

    @FXML
    private Text mytext;
    @FXML
    private Label label;
    @FXML
    private TextArea textarea;
    @FXML
    private Button dergo;
    
    @FXML
    void changecolor(ActionEvent event) {
    	Color c=colorpicker.getValue();
    	mytext.setFill(c);
    	
    	int color=colorpicker.getValue().hashCode();
    	String c2=Integer.toHexString(color);
    	
    	textarea.setStyle("-fx-background-color: #"+c2);
    	dergo.setStyle("-fx-background-color: #"+c2);
    }
    @FXML
    void dergo(ActionEvent event) {
    	//nese shtypet butoni dergo
    }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

}
