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
            image = ImageIO.read(new FileInputStream("Slime-Farm/res/slimes/slime1.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }


}
