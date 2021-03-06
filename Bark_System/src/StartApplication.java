/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import oracle.jdbc.pool.OracleDataSource;

/**
 *
 * @author Vanessa Quinteros
 */
public class StartApplication extends Application {

    static Connection connect;
    Statement commStmt;
    ResultSet rs;

// textfields for volunteer application
    TextField txtFirstName = new TextField();
    TextField txtLastName = new TextField();
    //TextField txtDOB = new TextField();
    TextField txtPhoneNumber = new TextField();
    TextField txtEmail = new TextField();
    TextField txtAddress = new TextField();
    Label lblFirstName = new Label("First Name");
    Label lblLastName = new Label("Last Name");
    Label lblDOB = new Label("DOB");
    Label lblPhoneNumber = new Label("Phone Number");
    Label lblEmail = new Label("Email");
    Label lblAddress = new Label("Address");
    Label lblExperience = new Label("Experience");
    ComboBox<String> expCombo = new ComboBox<>();
    Button btnSubmit = new Button("Submit Application");
    DatePicker dob = new DatePicker();

    //login window textfields and labels
    TextField txtUser = new TextField();
    TextField txtPass = new TextField();
    Label lblUser = new Label("User");
    Label lblPass = new Label("Password");
    Button btnLogin = new Button("Login");

    Button create = new Button("Welcome");

    public void start(Stage primaryStage) throws SQLException {
        try {
            String connectionString = "jdbc:oracle:thin:@localhost:1521:XE";
            OracleDataSource ds = new OracleDataSource();   // use of OracleDriver is from this class
            ds.setURL(connectionString);
            connect = ds.getConnection("javauser", "javapass"); // connect to oracle database

            GridPane pane = new GridPane();
            pane.setAlignment(Pos.CENTER);
            pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
            pane.setHgap(5.5);
            pane.setVgap(5.5);

            Button btLogin = new Button("Login");
            pane.add(btLogin, 1, 3);
            GridPane.setHalignment(btLogin, HPos.CENTER);
            btLogin.setOnAction((ActionEvent e) -> {
                try {
                    openLoginWindow();
                } catch (SQLException ex) {
                }
            });

            Button btCreateApp = new Button("Submit New Application");
            pane.add(btCreateApp, 1, 4);
            GridPane.setHalignment(btCreateApp, HPos.CENTER);
            btCreateApp.setOnAction(e -> {
                try {
                    openAppWindow();
                } catch (SQLException ex) {
                }
            }
            );
            Scene scene = new Scene(pane, 500, 600); //Create a scene
            primaryStage.setTitle("Welcome"); //set stage title
            primaryStage.setScene(scene); //place scene on stage
            primaryStage.show();//display the stage

        } catch (SQLException ex) {
            System.out.println("Error" + ex);
        }
    }

    public void openLoginWindow() throws SQLException {
        Stage loginWindow = new Stage();
        GridPane pane = new GridPane();
        loginWindow.setTitle("Login Window"); //set stage title

        Scene scene2 = new Scene(pane, 500, 550);
        pane.setAlignment(Pos.CENTER);
        pane.add(txtUser, 1, 0);
        pane.add(lblUser, 0, 0);
        pane.add(txtPass, 1, 1);
        pane.add(lblPass, 0, 1);
        pane.add(btnLogin, 1, 2);

        btnLogin.setOnAction(e -> {
            try {
                openHomescreen();
            } catch (SQLException ex) {
            }
        });
        loginWindow.setScene(scene2); //place scene on stage
        loginWindow.show();//display the stage

    }

    public void openAppWindow() throws SQLException {
        Stage applicationWindow = new Stage();
        GridPane pane = new GridPane();

        applicationWindow.setTitle("Volunteer Applications"); //set stage title
        ObservableList<String> experienceList = FXCollections.observableArrayList("Novice", "Intermediate", "Expert");
        Scene scene3 = new Scene(pane, 500, 550);
        pane.setAlignment(Pos.CENTER);
        pane.add(lblFirstName, 0, 0);
        pane.add(lblLastName, 0, 1);
        pane.add(lblDOB, 0, 2);
        pane.add(lblPhoneNumber, 0, 3);
        pane.add(lblEmail, 0, 4);
        pane.add(lblAddress, 0, 5);
        pane.add(lblExperience, 0, 6);

        pane.add(txtFirstName, 1, 0);
        pane.add(txtLastName, 1, 1);
        pane.add(dob, 1, 2);
        pane.add(txtPhoneNumber, 1, 3);
        pane.add(txtEmail, 1, 4);
        pane.add(txtAddress, 1, 5);
        pane.add(expCombo, 1, 6);
        expCombo.setItems(experienceList);
        pane.add(btnSubmit, 1, 7);

        btnSubmit.setOnAction(e -> {
            //give error if any fields are empty
            if (txtFirstName.getText().isEmpty() || txtLastName.getText().isEmpty() || dob.getValue() == null
                    || //DOB.getChronology().isNull ||
                    txtPhoneNumber.getText().isEmpty() || txtEmail.getText().isEmpty() || txtAddress.getText().isEmpty()
                    || expCombo.getValue().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Please enter all data");
                alert.showAndWait();
            } else {
                System.out.println(txtFirstName.getText() + " " + txtLastName.getText() + " " + dob.getValue() + " " + txtPhoneNumber.getText() + " "
                        + txtEmail.getText() + " " + txtAddress.getText() + " " + expCombo.getValue());
                
                //code for creating a new application when submit button is clicked
//        Application submittedApp = new Application(
//                txtFirstName.getText(),
//                txtLastName.getText(),
//                txtDOB.getText(),
//                txtPhoneNumber.getText(),
//                txtEmail.getText(),
//                txtAddress.getText(),
//                expCombo.getValue()
//        ); applications.add(submittedApp);
//        String query = "INSERT INTO APPLICATION (ApplicationID,FirstName,LastName,DOB,email,phone, address,experience,status) VALUES (" + submittedApp.getAppID() + ", '"
//                + txtFirstName.getText() + "', '" + txtLastName.getText() + "', '" + dob.getValue() + "', '" + txtEmail.getText() + "', '" + txtAddress.getText() + 
//                "', '" + expCombo.getValue() + "', '" + submittedApp.getStatus() + "','" + "')";
//        DBConnection conn = new DBConnection();
//        conn.sendDBCommand(query);

                //clear text fields after submission
                txtFirstName.setText("");
                txtLastName.setText("");
                dob.setValue(null);
                txtPhoneNumber.setText("");
                txtEmail.setText("");
                txtAddress.setText("");
                expCombo.setValue("");

                //give alert that application was submitted
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText("Application Submitted!");
                alert.showAndWait();
            }
        });
        applicationWindow.setScene(scene3); //place scene on stage
        applicationWindow.show();//display the stage
    }

    private void openHomescreen() throws SQLException {
        //homescreen for volunteer after logging in
        Stage homescreenWindow = new Stage();
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        homescreenWindow.setTitle("Volunteer Homepage"); //set stage title
        Scene scene4 = new Scene(pane, 500, 550);

        Button btnCheckIn = new Button();
        Button btnCheckOut = new Button();
        Label lblCheckIn = new Label("Check-in");
        Label lblCheckOut = new Label("Check-out");
        Label lblInfo = new Label("View Volunteer Summary");
        Button btnInfo = new Button("Click");
        Button btnAssign = new Button("Click");
        Label lblAssign = new Label("Assign Specialization");
        Button btnEvents = new Button("Click");
        Label lblEvents = new Label("Update/Create Events");
        Label lblReports = new Label("View Reports");

        ComboBox<String> reportsCombo = new ComboBox<>();

        pane.add(lblCheckIn, 0, 0);
        pane.add(lblCheckOut, 0, 1);
        pane.add(lblReports, 0, 2);
        pane.add(lblInfo, 3, 0);
        pane.add(lblAssign, 3, 1);
        pane.add(lblEvents, 3, 2);
        pane.add(btnCheckIn, 1, 0);
        pane.add(btnCheckOut, 1, 1);
        pane.add(reportsCombo, 1, 2);
        pane.add(btnInfo, 4, 0);
        pane.add(btnAssign, 4, 1);
        pane.add(btnEvents, 4, 2);

        homescreenWindow.setScene(scene4); //place scene on stage
        homescreenWindow.show();//display the stage

    }

    public static void main(String[] args) {
        launch(args);
    }
}
