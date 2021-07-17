package program;

import config.Koneksi;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import tampilan_program.MainView;

public class ProgramUtama extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        stage = new Stage();
        
        Scene s = new Scene(new MainView(), 800, 600);
        stage.setScene(s);
        stage.setTitle("Aplikasi Pendataan Murid Baru | By. Vina Santa Rosa");
        stage.show();
    }
    public static void main(String[] args){
        launch(args);
    }
 }