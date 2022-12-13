import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class UI {
    
    GamePanel gp;
    Font arial40;
    BufferedImage buyButtonImage;

    public UI(GamePanel gp){
        this.gp =gp;
        buyButton();
    }

    public void buyButton(){

        try{
         BufferedImage buyButtonImage = ImageIO.read(new FileInputStream("res/UI/buybutton.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2){
   
        int x,y;
        x= gp.screenWidth/2;
        y= gp.screenHeight;

        g2.drawImage( buyButtonImage, x, y, 128, 64, null);
    }
}
