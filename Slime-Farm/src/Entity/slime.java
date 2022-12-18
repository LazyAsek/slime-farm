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
            image[0]=ImageIO.read(new FileInputStream("Slime-Farm/res/animation/hatch/Hatch1.png"));
            image[1]=ImageIO.read(new FileInputStream("Slime-Farm/res/animation/hatch/Hatch2.png"));
            image[2]=ImageIO.read(new FileInputStream("Slime-Farm/res/animation/hatch/Hatch3.png"));
            image[3] = ImageIO.read(new FileInputStream("Slime-Farm/res/slimes/slime1.png"));
            image[4] = ImageIO.read(new FileInputStream("Slime-Farm/res/slimes/slime2.png"));
            image[5] = ImageIO.read(new FileInputStream("Slime-Farm/res/slimes/slime3.png"));
            image[6] = ImageIO.read(new FileInputStream("Slime-Farm/res/slimes/slime4.png"));
            image[7] = ImageIO.read(new FileInputStream("Slime-Farm/res/slimes/slime5.png"));
            image[8] = ImageIO.read(new FileInputStream("Slime-Farm/res/slimes/slime6.png"));
            image[9] = ImageIO.read(new FileInputStream("Slime-Farm/res/slimes/slime7.png"));
            image[10] = ImageIO.read(new FileInputStream("Slime-Farm/res/slimes/slime8.png"));
            image[11] = ImageIO.read(new FileInputStream("Slime-Farm/res/slimes/slime9.png"));
            image[12] = ImageIO.read(new FileInputStream("Slime-Farm/res/slimes/slime10.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }


}
