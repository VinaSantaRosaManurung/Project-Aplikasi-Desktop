/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package res_gambar;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author ASUS
 */
public class Gambar {
        private Image recomImage;
    private ImageView recomImageView;
    
    public Gambar(double x, double y){
        recomImage = new Image(getClass().getResourceAsStream("/res_gambar/recom.png"));
        recomImageView = new ImageView(recomImage);
        
        recomImageView.setX(x);
        recomImageView.setY(y);
        
        GambarTest.root.getChildren().addAll(recomImageView);
        interactions();
    }
    private void interactions(){
}
}