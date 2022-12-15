package Main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ClickHandler implements MouseListener {
    GamePanel gp;
    UI ui;
    public int clickNum=0;
  
    
    int mouseX ,mouseY;
    public ClickHandler (GamePanel gp,UI ui){
        this.gp=gp;
        this.ui=ui;
    }
    int num = clickNum;
    
    @Override
    public void mouseClicked(MouseEvent e) {
        int x=gp.screenWidth/2 , y=gp.screenHeight/2;;
        mouseX = e.getX();
        mouseY = e.getY();
        if(ui.buyButton.contains(mouseX, mouseY)){
            num = clickNum;
            gp.sSpawner.spawn(clickNum,x,y);
            clickNum ++;
        }    
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
       // mouseCheck=false;
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

 
    

}
