/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BarkGui;

import AppConnectionMain.SceneController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author black
 */
public class WelcomeScreenController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML Text text1;
    
    
    @FXML
    Button volunteer_login;
    @FXML 
    Button apply_here;
    @FXML
    Button backButton;
    
    SceneController sc = new SceneController();
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        SceneController sc = new SceneController();
        volunteer_login.setOnAction(e -> sc.switchScene(e, "Employee_Table_View.fxml"));
        apply_here.setOnAction(e -> sc.switchScene(e, "products.fxml"));
        backButton.setOnAction(e -> sc.switchScene(e, "store_area.fxml"));
        
    }    
    
}
