import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class X extends Application

{
   public Line line1, line2;
   public Group root;
   public void start(Stage primaryStage)
    {
        root = new Group();
        
        Scene scene = new Scene(root, 500, 300, Color.BLACK);
        
        

        primaryStage.setTitle("x");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
    }  
      public void drawX()
      {
      double h = 10.0;
      double w = 30.0;
      line1 = new Line(5, w -10 , h, w);
      line2 = new Line(h+10, w-25, h+20, w-20);
      }   
   
      
      
     public static void main(String[] args) {
        launch(args);
        
        }
 
 

        
}