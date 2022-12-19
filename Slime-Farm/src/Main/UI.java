package Main;

import java.awt.Font;
import java.awt.Graphics2D;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.awt.Rectangle;

public class UI {
    
    GamePanel gp;
    Font arial40;
    BufferedImage uiImage ;
    BufferedImage eggBar[] = new BufferedImage[5];
    BufferedImage shopState[] = new BufferedImage[9];
    int hatchButtonWidth,hatchButtonHeight,shopButtonWidth,shopButtonHeight,upgradeButtonWidth,upgradeButtonHeight;
    int hatchButtonX,hatchButtonY,shopButtonX,shopButtonY,upgradeButtonX,upgradeButtonY;

    int shopOpenX,shopOpenY,shopOpenWidth,shopOpenHeight;

    int coin ,eggs,perSec,eggLimit;
    String coinText,eggsText,perSecText;
    int coinX,coinY;
    int eggsX,eggsY;
    int perSecX,perSecY;
    int currentBarImage=0;

    int maxdelay ,frameChangeDelay, currentDelay, lastDelay;;

    boolean shopOpen=false,unlocked1=true,unlocked2=false,unlocked3=false,unlocked4=false,unlocked5=false,unlocked6=false,unlocked7=false,unlocked8=false,unlocked9=false;

    public Rectangle hatchButton ,shopButton,upgradeButton,shopClose,buyslime1,buyslime2,buyslime3,buyslime4,buyslime5,buyslime6,buyslime7,buyslime8,buyslime9;
    
    ClickHandler cHandler = new ClickHandler(gp,this);

    int shopStateNum=0;
    
    public UI(GamePanel gp){
        this.gp =gp;
        getUi();
        hatchButton();
        shopButton();
        upgradeButton();
        topBar();
        arial40 = new Font("Arial",Font.PLAIN,40);
    }

    public void getUi(){
        try{
            uiImage = ImageIO.read(new FileInputStream("Slime-Farm/res/UI/UI.png"));
            eggBar[0] = ImageIO.read(new FileInputStream("Slime-Farm/res/UI/eggbar5.png"));
            eggBar[1] = ImageIO.read(new FileInputStream("Slime-Farm/res/UI/eggbar4.png"));
            eggBar[2] = ImageIO.read(new FileInputStream("Slime-Farm/res/UI/eggbar3.png"));
            eggBar[3] = ImageIO.read(new FileInputStream("Slime-Farm/res/UI/eggbar2.png"));
            eggBar[4] = ImageIO.read(new FileInputStream("Slime-Farm/res/UI/eggbar1.png"));
            shopState[0] = ImageIO.read(new FileInputStream("Slime-Farm/res/UI/shop/shop1.png"));
            shopState[1] = ImageIO.read(new FileInputStream("Slime-Farm/res/UI/shop/shop2.png"));
            shopState[2] = ImageIO.read(new FileInputStream("Slime-Farm/res/UI/shop/shop3.png"));
            shopState[3] = ImageIO.read(new FileInputStream("Slime-Farm/res/UI/shop/shop4.png"));
            shopState[4] = ImageIO.read(new FileInputStream("Slime-Farm/res/UI/shop/shop5.png"));
            shopState[5] = ImageIO.read(new FileInputStream("Slime-Farm/res/UI/shop/shop6.png"));
            shopState[6] = ImageIO.read(new FileInputStream("Slime-Farm/res/UI/shop/shop7.png"));
            shopState[7] = ImageIO.read(new FileInputStream("Slime-Farm/res/UI/shop/shop8.png"));
            shopState[8] = ImageIO.read(new FileInputStream("Slime-Farm/res/UI/shop/shop9.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void hatchButton(){
        hatchButtonWidth =gp.screenWidth/3;
        hatchButtonHeight = gp.orginalSize *2;

        hatchButtonX= gp.screenWidth/2-hatchButtonWidth/2;
        hatchButtonY= gp.screenHeight-hatchButtonHeight;

        hatchButton = new Rectangle(hatchButtonX,hatchButtonY,hatchButtonWidth,hatchButtonHeight);
    }

    public void shopButton(){
        shopButtonWidth =gp.screenWidth/3;
        shopButtonHeight = gp.orginalSize *2;
        
        shopButtonX=0;
        shopButtonY= gp.screenHeight-shopButtonHeight;

        shopButton = new Rectangle(shopButtonX,shopButtonY,shopButtonWidth,shopButtonHeight);

        shopOpenX =gp.orginalSize/2;
        shopOpenY =gp.orginalSize/2;
        shopOpenWidth=gp.screenWidth-gp.orginalSize;
        shopOpenHeight=gp.screenHeight-gp.orginalSize;
    }

    public void upgradeButton(){
        upgradeButtonWidth =gp.screenWidth/3;
        upgradeButtonHeight = gp.orginalSize *2;
        
        upgradeButtonX= upgradeButtonWidth*2;
        upgradeButtonY= gp.screenHeight-upgradeButtonHeight;

        upgradeButton = new Rectangle(upgradeButtonX,upgradeButtonY,upgradeButtonWidth,upgradeButtonHeight);
    }

    public void topBar(){
        coinX = shopButtonX+60 ;
        coinY = gp.orginalSize+gp.orginalSize/2;
        coin = 1000000;
        coinText = coin +"";

        eggsX = hatchButtonX+30 ;
        eggsY = gp.orginalSize+gp.orginalSize/2;
        eggs = 5;
        eggLimit=10;
        eggsText = eggs +"/"+eggLimit;

        perSecX = upgradeButtonX+60 ;
        perSecY = gp.orginalSize+gp.orginalSize/2;
        perSec = 0;
        perSecText = perSec+"";
    }

    public void eggBarUpdate(){
        maxdelay = gp.eco.maxEggDelay;
        frameChangeDelay =maxdelay/eggBar.length;
        currentDelay=gp.eco.eggDelay;

        if(currentDelay ==1){
            lastDelay=0;
            currentBarImage=0;
        }

        if(currentDelay-lastDelay>frameChangeDelay){
            lastDelay = currentDelay;
            currentBarImage++;
        }
        
    }
    
    public void formatCoins(){
        if(coin>10000){
            coinText=coin/10000+"k";
        }else{
            coinText = coin+"";
        }
    }

    public void shopOpen(){
        if(unlocked1==true){
            shopStateNum=0;
        }
        if(unlocked2==true){
            shopStateNum=1;
        }
        if(unlocked3==true){
            shopStateNum=2;
        }
        if(unlocked4==true){
            shopStateNum=3;
        }
        if(unlocked5==true){
            shopStateNum=4;
        }
        if(unlocked6==true){
            shopStateNum=5;
        }
        if(unlocked7==true){
            shopStateNum=6;
        }
        if(unlocked8==true){
            shopStateNum=7;
        }
        if(unlocked9==true){
            shopStateNum=8;
        }
        int buyX=gp.orginalSize+gp.orginalSize/4;
        int buyY=gp.orginalSize*6-gp.orginalSize/4;
        int buyWidth =gp.orginalSize*3;
        int buyHeight =gp.orginalSize-gp.orginalSize/2+gp.orginalSize/4;
        shopClose = new Rectangle( shopOpenWidth - gp.orginalSize-gp.orginalSize/3,gp.orginalSize,gp.orginalSize+gp.orginalSize/4,gp.orginalSize+gp.orginalSize/4);
        buyslime1 = new Rectangle( buyX,buyY,buyWidth,buyHeight);
        buyslime2 = new Rectangle( buyX+buyWidth+buyWidth/8,buyY,buyWidth,buyHeight);
        buyslime3 = new Rectangle( buyX+buyWidth*2+buyWidth/6,buyY,buyWidth,buyHeight);
        buyslime4 = new Rectangle( buyX,buyY*2-buyHeight*2,buyWidth,buyHeight);
        buyslime5 = new Rectangle( buyX+buyWidth+buyWidth/8,buyY*2-buyHeight*2,buyWidth,buyHeight);
        buyslime6 = new Rectangle( buyX+buyWidth*2+buyWidth/6,buyY*2-buyHeight*2,buyWidth,buyHeight);
        buyslime7 = new Rectangle( buyX,buyY*3-buyHeight*4,buyWidth,buyHeight);
        buyslime8 = new Rectangle( buyX+buyWidth+buyWidth/8,buyY*3-buyHeight*4,buyWidth,buyHeight);
        buyslime9 = new Rectangle( buyX+buyWidth*2+buyWidth/6,buyY*3-buyHeight*4,buyWidth,buyHeight);
    }


    public void draw(Graphics2D g2){
      
      g2.drawImage(uiImage, 0, 0, gp.screenWidth, gp.screenHeight,null);
      g2.drawImage(eggBar[currentBarImage], eggsX, eggsY+5,upgradeButtonWidth-gp.orginalSize,gp.orginalSize/4,null);
      g2.setFont(arial40);
      g2.drawString(coinText, coinX, coinY);
      g2.drawString(eggsText, eggsX, eggsY);
      g2.drawString(perSecText, perSecX, perSecY);
      if(shopOpen==true){
          g2.drawImage(shopState[shopStateNum], shopOpenX,shopOpenY,shopOpenWidth,shopOpenHeight, null);
          //g2.fillRect(buyslime9.x,buyslime9.y,(int)buyslime9.getWidth(),(int)buyslime9.getHeight());
      }
     
    }
}
