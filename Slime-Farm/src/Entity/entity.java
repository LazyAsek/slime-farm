package Entity;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;

import Main.GamePanel;

public class entity {
    public int screenX,screenY;
    public int moveRange=40;
    public int speed=1;
    public String name;
    public Rectangle hitbox = new Rectangle(screenX-32,screenY-32,64,64);
    public boolean startMoveing=false;
    public boolean hold=false ;
    public BufferedImage image[]= new BufferedImage[13];
    public int moveInterval =0;
    public int currentImage=0,hatchframe=0;;
    int nextX;
    int nextY;
    int slimesize;

    public void getPoint(GamePanel gp){
        //make endpoint where entity go in range of 40
        nextX =screenX + getRandomNumber(-moveRange, moveRange);
        nextY =screenY + getRandomNumber(-moveRange, moveRange);
        //cant go out of bounds of background + one slime
        if(nextX>gp.screenWidth-gp.orginalSize){
            nextX=-moveRange;
        }
        if(nextX<0+gp.orginalSize){
            nextX=+moveRange;
        }
        if(nextY>gp.screenHeight-gp.orginalSize*3){
            nextY=-moveRange;
        }
        if(nextY<0+gp.orginalSize){
            nextY=+moveRange;
        }

        startMoveing = true;
    }
    //function to generate random numbers
    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public void move(GamePanel gp){
        //move to end point from this point

        if(screenX>nextX){
            screenX-=speed;
        }
        if(screenX<nextX){
            screenX+=speed;
        }
        if(screenY>nextY){
            screenY-=speed;
        }
        if(screenY<nextY){
            screenY+=speed;
        }
        hitbox.x=screenX;
        hitbox.y=screenY;
    }
    public void drag(GamePanel gp,int x,int y){
            
            if(screenX>0 && screenX<gp.screenWidth){
                screenX= x - gp.orginalSize/2;
            }
            if(screenY>0 && screenY<gp.screenHeight){
                screenY= y - gp.orginalSize/2;
            
        }
    }
    public void draw(Graphics2D g2 ,GamePanel gp){
        slimesize = gp.orginalSize + gp.orginalSize/4;
        g2.drawImage(image[currentImage], screenX, screenY, slimesize, slimesize, null);
       
    }
}
