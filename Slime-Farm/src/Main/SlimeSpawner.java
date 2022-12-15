package Main;

import Entity.slime;

public class SlimeSpawner {
    GamePanel gp;

    public SlimeSpawner (GamePanel gp,ClickHandler cHandler){
        this.gp=gp;
    }

    public void spawn(int num,int x,int y){
        gp.e[num]= new slime(gp);
        gp.e[num].screenX=x;
        gp.e[num].screenY=y;
    }
}
