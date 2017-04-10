# Zoe

/*
 * 
 */
package piechartpractice;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class PieChartPractice extends Application {
    
    public readFile RF1;
   
    @Override
    public void start(Stage stage) throws Exception 
    {
        readFile RF1 = new readFile();
        
        //create Parent object and connect to fxml file
         Parent root = FXMLLoader.load(getClass().getResource("FXMLPie.fxml"));
        
        //create scene and set size of scene 
        Scene scene = new Scene(root, 1100,750);
        
        //add scene to stage
        stage.setScene(scene);
        
        //show stage
        stage.show();          
       
    }

   
    public static void main(String[] args) 
    {
        launch(args);
    }
    
}
