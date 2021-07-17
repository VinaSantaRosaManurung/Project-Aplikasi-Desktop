/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package res_gambar;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import program.ProgramUtama;

/**
 *
 * @author ASUS
 */
public class GambarTest extends ProgramUtama {
    public static Group root = new Group();
    
    public void start(Stage primaryStage){
        Gambar gambar1 = new Gambar(200, 200);
        
        Scene scene = new Scene(root, 600, 500, Color.rgb(50, 50, 50));
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[]args){
        
    }
}
