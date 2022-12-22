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
        mouseX= e.getX();
        mouseY= e.getY();  
        //make buy button work to spawn
        if(ui.hatchButton.contains(mouseX, mouseY)&&gp.ui.eggs>0&&gp.ui.shopOpen==false){
            Boolean doubleSpwan=false;
            if(getRandomNumber(0, 100)<gp.eco.twinChance){
                doubleSpwan=true;
            }
            if(doubleSpwan==true){
                freenum = getNum();
                gp.sSpawner.spawn(getNum(),x,y);
                freenum = getNum();
                gp.sSpawner.spawn(getNum(),x,y);
                gp.ui.eggs--;
                
            }
            if(doubleSpwan==false){
                freenum = getNum();
                gp.sSpawner.spawn(getNum(),x,y);
                gp.ui.eggs--;
            }
            doubleSpwan=false;
        }    
        if(ui.shopButton.contains(mouseX, mouseY)){
            gp.ui.shopOpen=true;
            gp.ui.shopOpen();
        } 
        if(ui.upgradeButton.contains(mouseX, mouseY)){
            gp.ui.upgradeShopOpen=true;
            gp.ui.upgradeShopOpen();
        }   
        if(ui.upgradeShopOpen==true){
            gp.eco.getPrices();
            ui.formatCoins();
            if(ui.shopClose.contains(mouseX, mouseY)){
                gp.ui.upgradeShopOpen=false;
            }
            if(ui.buyUpgrade1.contains(mouseX, mouseY)&&ui.coin>=gp.eco.upgrade1Price&& gp.eco.perSecMultiplayer<1.5){
                gp.eco.perSecMultiplayer+=0.10;
                ui.coin-=gp.eco.upgrade1Price;
                gp.eco.upgrade1BCounter++;
            }
            if(ui.buyUpgrade2.contains(mouseX, mouseY)&&ui.coin>=gp.eco.upgrade2Price&&gp.eco.maxEggDelay!=5){
                gp.eco.maxEggDelay--;
                ui.coin-=gp.eco.upgrade2Price;
                gp.eco.upgrade2BCounter++;
            }
            if(ui.buyUpgrade3.contains(mouseX, mouseY)&&ui.coin>=gp.eco.upgrade3Price&& ui.eggLimit!=20){
                ui.eggLimit++;
                ui.coin-=gp.eco.upgrade3Price;
                gp.eco.upgrade3BCounter++;
            }
            if(ui.buyUpgrade4.contains(mouseX, mouseY)&&ui.coin>=gp.eco.upgrade4Price && gp.eco.twinChance<20){
                gp.eco.twinChance++;;
                ui.coin-=gp.eco.upgrade4Price;
                gp.eco.upgrade4BCounter++;
            }
            gp.eco.getPrices();
            ui.formatCoins();
        }
        if( gp.ui.shopOpen==true){
            gp.eco.getPrices();
            ui.formatCoins();
            if(ui.shopClose.contains(mouseX, mouseY)){
                gp.ui.shopOpen=false;
            }
            if(ui.buyslime1.contains(mouseX,mouseY)&& ui.coin >= gp.eco.slime1Price){
                gp.sSpawner.buy(getNum(),x,y,3);
                ui.coin -= gp.eco.slime1Price;
                gp.eco.slime1BCounter++;
            }
            if(ui.buyslime2.contains(mouseX,mouseY)&& ui.unlocked2==true && ui.coin >= gp.eco.slime2Price){
                gp.sSpawner.buy(getNum(),x,y,4);
                ui.coin -= gp.eco.slime2Price;
                gp.eco.slime2BCounter++;
            }
            if(ui.buyslime3.contains(mouseX,mouseY)&& ui.unlocked3==true&& ui.coin >= gp.eco.slime3Price){
                gp.sSpawner.buy(getNum(),x,y,5);
                ui.coin -= gp.eco.slime3Price;
                gp.eco.slime3BCounter++;
            }
            if(ui.buyslime4.contains(mouseX,mouseY)&& ui.unlocked4==true&& ui.coin >= gp.eco.slime4Price){
                gp.sSpawner.buy(getNum(),x,y,6);
                ui.coin -= gp.eco.slime4Price;
                gp.eco.slime4BCounter++;
            }
            if(ui.buyslime5.contains(mouseX,mouseY)&& ui.unlocked5==true&& ui.coin >= gp.eco.slime5Price){
                gp.sSpawner.buy(getNum(),x,y,7);
                ui.coin -= gp.eco.slime5Price;
                gp.eco.slime5BCounter++;
            }
            if(ui.buyslime6.contains(mouseX,mouseY)&& ui.unlocked6==true&& ui.coin >= gp.eco.slime6Price){
                gp.sSpawner.buy(getNum(),x,y,8);
                ui.coin -= gp.eco.slime6Price;
                gp.eco.slime6BCounter++;
            }
            if(ui.buyslime7.contains(mouseX,mouseY)&& ui.unlocked7==true&& ui.coin >= gp.eco.slime7Price){
                gp.sSpawner.buy(getNum(),x,y,9);
                ui.coin -= gp.eco.slime7Price;
                gp.eco.slime7BCounter++;
            }
            if(ui.buyslime8.contains(mouseX,mouseY)&& ui.unlocked8==true&& ui.coin >= gp.eco.slime8Price){
                gp.sSpawner.buy(getNum(),x,y,10);
                ui.coin -= gp.eco.slime8Price;
                gp.eco.slime8BCounter++;
            }
            if(ui.buyslime9.contains(mouseX,mouseY)&& ui.unlocked9==true&& ui.coin >= gp.eco.slime9Price){
                gp.sSpawner.buy(getNum(),x,y,11);
                ui.coin -= gp.eco.slime9Price;
                gp.eco.slime9BCounter++;
            }
            gp.eco.getPrices();
            ui.formatCoins();

        } 


    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(gp.ui.shopOpen==false){
            for(int i=0;i<gp.e.length;i++){
                if(gp.e[i]!=null && gp.e[i].hitbox.contains(mouseX,mouseY)){
                    hold=true;
                    clickedEntity = i;  
                   // System.out.println(clickedEntity);          
                }
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(gp.ui.shopOpen==false){
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
