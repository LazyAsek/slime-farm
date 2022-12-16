package Entity;
import Main.GamePanel;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;


public class slime extends entity{

    GamePanel gp;

   

    public slime (GamePanel gp){
        this.gp=gp;
        getImage();
    }

    public void getImage(){
        try{
            image[0] = ImageIO.read(new FileInputStream("Slime-Farm/res/slimes/slime1.png"));
            image[1] = ImageIO.read(new FileInputStream("Slime-Farm/res/slimes/slime1.png"));
            image[2] = ImageIO.read(new FileInputStream("Slime-Farm/res/slimes/slime1.png"));
            image[3] = ImageIO.read(new FileInputStream("Slime-Farm/res/slimes/slime1.png"));
            image[4] = ImageIO.read(new FileInputStream("Slime-Farm/res/slimes/slime1.png"));
            image[5] = ImageIO.read(new FileInputStream("Slime-Farm/res/slimes/slime1.png"));
            image[6] = ImageIO.read(new FileInputStream("Slime-Farm/res/slimes/slime1.png"));
            image[7] = ImageIO.read(new FileInputStream("Slime-Farm/res/slimes/slime1.png"));
            image[8] = ImageIO.read(new FileInputStream("Slime-Farm/res/slimes/slime1.png"));
            image[9] = ImageIO.read(new FileInputStream("Slime-Farm/res/slimes/slime1.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }


}
