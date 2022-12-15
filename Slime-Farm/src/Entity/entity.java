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
    public Rectangle hitbox = new Rectangle(screenX,screenY,64,64);
    public boolean startMoveing=false;
    BufferedImage image;
    public int moveInterval =0;
    int nextX;
    int nextY;

    public void getPoint(){

        nextX =screenX + getRandomNumber(-moveRange, moveRange);
        nextY =screenY + getRandomNumber(-moveRange, moveRange);

        
        System.out.println("X:"+nextX+" Y:"+nextY);
        startMoveing = true;
    }
    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public void move(){
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
    }

    public void draw(Graphics2D g2 ,GamePanel gp){
     
        g2.drawImage(image, screenX, screenY, gp.orginalSize, gp.orginalSize, null);
        
    }
}
