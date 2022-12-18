package Main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.Rectangle;



public class ClickHandler implements MouseListener,MouseMotionListener {
    GamePanel gp;
    UI ui;
    
    public boolean hold= false;
    public int clickedEntity;
    public int mouseX ,mouseY;
    int freenum;
    int randomnum;
    public Rectangle matchHitbox ;
  
    
    public ClickHandler (GamePanel gp,UI ui){
        this.gp=gp;
        this.ui=ui;
    }
    

    @Override
    public void mouseClicked(MouseEvent e) {
        randomnum = getRandomNumber(-100,100);
        int x=gp.screenWidth/2+randomnum , y=gp.screenHeight/2+randomnum;
        
        //make buy button work to spawn
        if(ui.hatchButton.contains(mouseX, mouseY)&&gp.ui.eggs>0){
            freenum = getNum();
            gp.sSpawner.spawn(getNum(),x,y);
            gp.ui.eggs--;
        }    
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
        for(int i=0;i<gp.e.length;i++){
            if(gp.e[i]!=null && gp.e[i].hitbox.contains(mouseX,mouseY)){
                hold=true;
                clickedEntity = i;  
               // System.out.println(clickedEntity);          
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        hold = false;
        matchHitbox = new Rectangle(mouseX-128,mouseY-128,128,128);
        int used = 0;
        for(int i=0;i<gp.e.length;i++){
            if(gp.e[i]!=null && 
               gp.e[i].hitbox.contains(gp.e[clickedEntity].screenX,gp.e[clickedEntity].screenY )&& 
               i!=clickedEntity &&
               matchHitbox.contains(gp.e[clickedEntity].screenX, gp.e[clickedEntity].screenY)){
                   if(used ==0 &&gp.e[i].currentImage == gp.e[clickedEntity].currentImage 
                   &&gp.e[clickedEntity].currentImage<gp.e[clickedEntity].image.length-1){
                             gp.e[i] = null;
                             used++;
                             gp.e[clickedEntity].currentImage++;
                             System.gc();
                         }
                         
            }
        }
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        mouseX= e.getX();
        mouseY= e.getY();   
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX= e.getX();
        mouseY= e.getY();   
      
    }

    public int getNum(){
        freenum=0;
        for(int i =0;i<gp.e.length;i++){
            if(gp.e[i]==null){
                freenum=i;
                break;
            }
        }
        return freenum;
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

 
    

}
