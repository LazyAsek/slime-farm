package Main;
import java.awt.Graphics2D;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;


public class BackgroundMenager {
    
    GamePanel gp;
    BufferedImage background;

    public BackgroundMenager(GamePanel gp){
        this.gp = gp;
        getBackgoundImage();
    }

    public void getBackgoundImage(){
        try{
            background = ImageIO.read(new FileInputStream("Slime-Farm/res/backgrounds/background.png"));
           }catch(IOException e){
               e.printStackTrace();
           }
    }

    public void draw(Graphics2D g2){

        g2.drawImage(background, 0,0,gp.screenWidth,gp.screenHeight,null);
    }

}
