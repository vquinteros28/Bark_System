/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BarkGui;

import AppConnectionMain.DBConnection;
import CapStoneClasses.Application;
import java.awt.Button;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import oracle.jdbc.pool.OracleDataSource;

/**
 * FXML Controller class
 *
 * @author black
 */
public class VolunteerApplicationController implements Initializable {
 @FXML
    private ComboBox<String> CBExp;

    @FXML
    private ComboBox<String> CBSpec;

    @FXML
    private DatePicker DOB;

    @FXML
    private Button backBtn;

    @FXML
    private Button btnSubmit;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtFName;

    @FXML
    private TextField txtLName;

    @FXML
    private TextField txtPhoneNum;


    ObservableList<String> experienceList = FXCollections.observableArrayList("None", "1-3 years", "4+ years");
    ObservableList<Application> applications = FXCollections.observableArrayList();
    ResultSet rs;
    Statement stmt;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CBExp.setItems(experienceList);
        String query = "Select * from application";
        DBConnection conn = new DBConnection();
        try{
        conn.sendDBCommand(query);
        while(conn.dbResults.next()){
        Application dbApp = new Application();
        dbApp.setAppID(rs.getInt(1));
        dbApp.setAFirst(rs.getString(2));  
        dbApp.setALast(rs.getString(3));             
        dbApp.setDOB(rs.getString(4)); 
        dbApp.setEmail(rs.getString(5));
        dbApp.setPhone(rs.getString(6));
        dbApp.setAddress(rs.getString(7));
        dbApp.setExperience(rs.getString(8));
        dbApp.setStatus(rs.getString(8));

        applications.add(dbApp);
        } conn.dbResults.close();

    }catch (SQLException ex){
    }
    }
        // TODO
        
    void submitApplication(ActionEvent event) {
if(txtFName.getText().isEmpty() || txtLName.getText().isEmpty() || txtEmail.getText().isEmpty() || //DOB.getChronology().isNull ||
                txtPhoneNum.getText().isEmpty() || txtAddress.getText().isEmpty() || CBExp.getValue().isEmpty()) //|| CBSpec.getValue().isEmpty())
                {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Please enter all data");
            alert.showAndWait();
        }else{
            String date = DOB.getValue().format(DateTimeFormatter.ISO_DATE);
        System.out.println(txtFName.getText() + " " + txtLName.getText() + " " + date + " " + CBExp.getValue() + " " + CBSpec.getValue());
        Application submittedApp = new Application(
                txtFName.getText(),
                txtLName.getText(),
                date,
                txtEmail.getText(),
                txtPhoneNum.getText(),
                txtAddress.getText(),
                CBExp.getValue()
        ); //applications.add(submittedApp);
        String query = "INSERT INTO APPLICATION (ApplicationID,FirstName,LastName,DOB,email,phone, address,experience,status) VALUES (" + submittedApp.getAppID() + ", '"
                + txtFName.getText() + "', '" + txtLName.getText() + "', '" + date + "', '" + txtEmail.getText() + "', '" + txtPhoneNum.getText() + 
                "', '" + txtAddress.getText() + "', '" + submittedApp.getStatus() + "','" + CBExp.getValue() + "', '"
                + CBSpec.getValue() + "')";
        DBConnection conn = new DBConnection();
        conn.sendDBCommand(query);
        
        txtFName.setText("");
        txtLName.setText("");
        DOB.setChronology(null);
        CBExp.setValue("");
        CBSpec.setValue("");
        }
    }
    
}
