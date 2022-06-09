
package AppConnectionMain;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class StartApplication extends Application{ 
    
    @Override
    public void start(Stage primaryStage) throws IOException, Exception {

        Parent root = FXMLLoader.load(getClass().getResource("BarkGui/WelcomeScreenController.fxml")); //Sets main fxml screen
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(root,300,275 ));
        primaryStage.show();

    }
    public static void main(String[] args) {
        launch(args);
    }
}
    

