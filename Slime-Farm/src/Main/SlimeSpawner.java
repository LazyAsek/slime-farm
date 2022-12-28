package Main;

import Entity.slime;
import java.awt.image.BufferedImage;

public class SlimeSpawner {
    GamePanel gp;
 
    int xSpawn,ySpawn;
    BufferedImage hatch[]= new BufferedImage [3];
    public SlimeSpawner (GamePanel gp,ClickHandler cHandler){
        this.gp=gp;

    }

    public void spawn(int num,int x,int y){
        //make basic slime
        xSpawn=x;
        ySpawn=y;
        gp.e[num]= new slime(gp);
        gp.e[num].screenX=x;
        gp.e[num].screenY=y;
        gp.e[num].hitbox.x=x;
        gp.e[num].hitbox.y=y;
    }

    public void buy(int num,int x,int y,int currentimage){
        //make basic slime
        xSpawn=x;
        ySpawn=y;
        gp.e[num]= new slime(gp);
        gp.e[num].screenX=x;
        gp.e[num].screenY=y;
        gp.e[num].hitbox.x=x;
        gp.e[num].hitbox.y=y;
        gp.e[num].currentImage=currentimage;
    }

    public void loadSlimes(){
       int num;
        for(int i=1;i<=gp.eco.slime1;i++){
            num=gp.cHandler.getNum();
            buy(num, gp.screenWidth/2,gp.screenHeight/2, 3);
            System.out.println("work");
        }
        for(int i=1;i<=gp.eco.slime2;i++){
            num=gp.cHandler.getNum();
            buy(num, gp.screenWidth/2,gp.screenHeight/2, 4);
            System.out.println("work");
        }
        for(int i=1;i<=gp.eco.slime3;i++){
            num=gp.cHandler.getNum();
            buy(num, gp.screenWidth/2,gp.screenHeight/2, 5);
            System.out.println("work");
        }
        for(int i=1;i<=gp.eco.slime4;i++){
            num=gp.cHandler.getNum();
            buy(num, gp.screenWidth/2,gp.screenHeight/2, 6);
            System.out.println("work");
        }
        for(int i=1;i<=gp.eco.slime5;i++){
            num=gp.cHandler.getNum();
            buy(num, gp.screenWidth/2,gp.screenHeight/2, 7);
            System.out.println("work");
        }
        for(int i=1;i<=gp.eco.slime6;i++){
            num=gp.cHandler.getNum();
            buy(num, gp.screenWidth/2,gp.screenHeight/2, 8);
            System.out.println("work");
        }
        for(int i=1;i<=gp.eco.slime7;i++){
            num=gp.cHandler.getNum();
            buy(num, gp.screenWidth/2,gp.screenHeight/2, 9);
            System.out.println("work");
        }
        for(int i=1;i<=gp.eco.slime8;i++){
            num=gp.cHandler.getNum();
            buy(num, gp.screenWidth/2,gp.screenHeight/2, 10);
            System.out.println("work");
        }
        for(int i=1;i<=gp.eco.slime9;i++){
            num=gp.cHandler.getNum();
            buy(num, gp.screenWidth/2,gp.screenHeight/2, 11);
            System.out.println("work");
        }
    }
}
