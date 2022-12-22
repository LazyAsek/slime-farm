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

}
