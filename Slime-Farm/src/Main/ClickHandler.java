package Main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.Rectangle;



public class ClickHandler implements MouseListener,MouseMotionListener {
    GamePanel gp;
    UI ui;
    public int clickNum=0;
    public boolean hold= false;
    public int clickedEntity;
    public int mouseX ,mouseY;
    public Rectangle matchHitbox ;
  
    
    public ClickHandler (GamePanel gp,UI ui){
        this.gp=gp;
        this.ui=ui;
    }
    int num = clickNum;

    @Override
    public void mouseClicked(MouseEvent e) {
        int x=gp.screenWidth/2 , y=gp.screenHeight/2;;
        
        //make buy button work to spawn
        if(ui.buyButton.contains(mouseX, mouseY)){
            num = clickNum;
            gp.sSpawner.spawn(clickNum,x,y);
            clickNum ++;
        }    
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
        for(int i=0;i<gp.e.length;i++){
            if(gp.e[i]!=null && gp.e[i].hitbox.contains(mouseX,mouseY)){
                hold=true;
                clickedEntity = i;            
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
                   if(used ==0 &&gp.e[i].currentImage == gp.e[clickedEntity].currentImage){
                             gp.e[i] = null;
                             used++;
                             gp.e[clickedEntity].currentImage++;
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

    //public int getNum(int[] arr){
       // int freenum=0;
       // for(int i =0;i<arr.length;i++){
        //    if(arr[i]!=null){

        //    }
       // }
  //  }


 
    

}
