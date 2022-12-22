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
    BufferedImage uiImage , upgradeShop ;
    BufferedImage eggBar[] = new BufferedImage[5];
    BufferedImage shopState[] = new BufferedImage[9];
    int hatchButtonWidth,hatchButtonHeight,shopButtonWidth,shopButtonHeight,upgradeButtonWidth,upgradeButtonHeight;
    int hatchButtonX,hatchButtonY,shopButtonX,shopButtonY,upgradeButtonX,upgradeButtonY;

    int shopOpenX,shopOpenY,shopOpenWidth,shopOpenHeight;

    public int coin ,eggs,perSec,eggLimit;
    String coinText,eggsText,perSecText;
    int coinX,coinY;
    int eggsX,eggsY;
    int perSecX,perSecY;
    int currentBarImage=0;

    int maxdelay ,frameChangeDelay, currentDelay, lastDelay;;

    boolean shopOpen=false,unlocked1=true,unlocked2=false,unlocked3=false,unlocked4=false,unlocked5=false,unlocked6=false,unlocked7=false,unlocked8=false,unlocked9=false;

    boolean upgradeShopOpen=false;

    public Rectangle hatchButton ,shopButton,upgradeButton,shopClose,buyslime1,buyslime2,buyslime3,buyslime4,buyslime5,buyslime6,buyslime7,buyslime8,buyslime9;
    public Rectangle buyUpgrade1,buyUpgrade2,buyUpgrade3,buyUpgrade4;
    ClickHandler cHandler = new ClickHandler(gp,this);

    int shopStateNum=0;

    public String slime1PriceText,slime2PriceText,slime3PriceText,slime4PriceText,slime5PriceText,slime6PriceText,slime7PriceText,slime8PriceText,slime9PriceText,slime10PriceText;
    public String upgrade1PriceText,upgrade2PriceText,upgrade3PriceText,upgrade4PriceText;
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
            upgradeShop = ImageIO.read(new FileInputStream("Slime-Farm/res/UI/upgradeMenu.png"));
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
        coin = 100000;
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

        if(gp.eco.slime1Price>10000){
            slime1PriceText=gp.eco.slime1Price/10000+"k";
        }else{
            slime1PriceText = gp.eco.slime1Price+"";
        }
        if(gp.eco.slime2Price>10000){
            slime2PriceText=gp.eco.slime2Price/10000+"k";
        }else{
            slime2PriceText = gp.eco.slime2Price+"";
        }
        if(gp.eco.slime3Price>10000){
            slime3PriceText=gp.eco.slime3Price/10000+"k";
        }else{
            slime3PriceText = gp.eco.slime3Price+"";
        }
        if(gp.eco.slime4Price>10000){
            slime4PriceText=gp.eco.slime4Price/10000+"k";
        }else{
            slime4PriceText = gp.eco.slime4Price+"";
        }
        if(gp.eco.slime5Price>10000){
            slime5PriceText=gp.eco.slime5Price/10000+"k";
        }else{
            slime5PriceText = gp.eco.slime5Price+"";
        }
        if(gp.eco.slime6Price>10000){
            slime6PriceText=gp.eco.slime6Price/10000+"k";
        }else{
            slime6PriceText = gp.eco.slime6Price+"";
        }
        if(gp.eco.slime7Price>10000){
            slime7PriceText=gp.eco.slime7Price/10000+"k";
        }else{
            slime7PriceText = gp.eco.slime7Price+"";
        }
        if(gp.eco.slime8Price>10000){
            slime8PriceText=gp.eco.slime8Price/10000+"k";
        }else{
            slime8PriceText = gp.eco.slime8Price+"";
        }
        if(gp.eco.slime9Price>10000){
            slime9PriceText=gp.eco.slime9Price/10000+"k";
        }else{
            slime9PriceText = gp.eco.slime9Price+"";
        }
        if(gp.eco.upgrade1Price>10000){
            upgrade1PriceText=gp.eco.upgrade1Price/10000+"k";
        }else{
            upgrade1PriceText = gp.eco.upgrade1Price+"";
        }
        if(gp.eco.upgrade2Price>10000){
            upgrade2PriceText=gp.eco.upgrade2Price/10000+"k";
        }else{
            upgrade2PriceText = gp.eco.upgrade2Price+"";
        }
        if(gp.eco.upgrade3Price>10000){
            upgrade3PriceText=gp.eco.upgrade3Price/10000+"k";
        }else{
            upgrade3PriceText = gp.eco.upgrade3Price+"";
        }
        if(gp.eco.upgrade4Price>10000){
            upgrade4PriceText=gp.eco.upgrade4Price/10000+"k";
        }else{
            upgrade4PriceText = gp.eco.upgrade4Price+"";
        }
        
    }
    public void upgradeShopOpen(){
        int buyX=gp.screenWidth-gp.orginalSize*3-gp.orginalSize/4;
        int buyY=gp.orginalSize*4+gp.orginalSize/10;
        int buyWidth =gp.orginalSize*2;
        int buyHeight =gp.orginalSize-gp.orginalSize/2+gp.orginalSize/4;

        shopClose = new Rectangle( shopOpenWidth - gp.orginalSize-gp.orginalSize/3,gp.orginalSize,gp.orginalSize+gp.orginalSize/4,gp.orginalSize+gp.orginalSize/4);
        buyUpgrade1 = new Rectangle( buyX,buyY,buyWidth,buyHeight);
        buyUpgrade2 = new Rectangle( buyX,buyY*2-buyHeight-buyHeight/2-buyHeight/4,buyWidth,buyHeight);
        buyUpgrade3 = new Rectangle( buyX,buyY*3-buyHeight*3-buyHeight/3,buyWidth,buyHeight);
        buyUpgrade4 = new Rectangle( buyX,buyY*4-buyHeight*5,buyWidth,buyHeight);
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
          if(unlocked1==true){
              g2.drawString(slime1PriceText, buyslime1.x+gp.orginalSize/8, buyslime1.y-gp.orginalSize/6);
          }
          if(unlocked2==true){
              g2.drawString(slime2PriceText, buyslime2.x+gp.orginalSize/8, buyslime2.y-gp.orginalSize/6);           
          }
          if(unlocked3==true){
              g2.drawString(slime3PriceText, buyslime3.x+gp.orginalSize/3, buyslime3.y-gp.orginalSize/6);          
          }
          if(unlocked4==true){
              g2.drawString(slime4PriceText, buyslime4.x+gp.orginalSize/8, buyslime4.y-gp.orginalSize/6);
          }
          if(unlocked5==true){
              g2.drawString(slime5PriceText, buyslime5.x+gp.orginalSize/8, buyslime5.y-gp.orginalSize/6);         
          }
          if(unlocked6==true){
              g2.drawString(slime6PriceText, buyslime6.x+gp.orginalSize/3, buyslime6.y-gp.orginalSize/6);    
          }
          if(unlocked7==true){
              g2.drawString(slime7PriceText, buyslime7.x+gp.orginalSize/8, buyslime7.y-gp.orginalSize/6);         
          }
          if(unlocked8==true){
              g2.drawString(slime8PriceText, buyslime8.x+gp.orginalSize/8, buyslime8.y-gp.orginalSize/6);        
          }
          if(unlocked9==true){
              g2.drawString(slime9PriceText, buyslime9.x+gp.orginalSize/3, buyslime9.y-gp.orginalSize/6);         
          }
      }
      if(upgradeShopOpen ==true){
        g2.drawImage(upgradeShop, shopOpenX,shopOpenY,shopOpenWidth,shopOpenHeight, null);
       // g2.fillRect(buyUpgrade4.x,buyUpgrade4.y, (int)buyUpgrade4.getWidth(), (int)buyUpgrade4.getHeight());
         g2.drawString(upgrade1PriceText, buyUpgrade1.x+gp.orginalSize/8, buyUpgrade1.y-gp.orginalSize/6);
         g2.drawString(upgrade2PriceText, buyUpgrade2.x+gp.orginalSize/8, buyUpgrade2.y-gp.orginalSize/6);
         g2.drawString(upgrade3PriceText, buyUpgrade3.x+gp.orginalSize/8, buyUpgrade3.y-gp.orginalSize/6);
         g2.drawString(upgrade4PriceText, buyUpgrade4.x+gp.orginalSize/8, buyUpgrade4.y-gp.orginalSize/8);

         g2.drawString(" "+(gp.eco.upgrade1BCounter-1)*10+"%", buyUpgrade1.x-gp.orginalSize*5, buyUpgrade1.y+gp.orginalSize/4);
         g2.drawString(" "+(gp.eco.upgrade1BCounter)*10+"%", buyUpgrade1.x-gp.orginalSize*2, buyUpgrade1.y+gp.orginalSize/4);

         g2.drawString(" "+(gp.eco.maxEggDelay)+"s", buyUpgrade1.x-gp.orginalSize*5, buyUpgrade1.y+gp.orginalSize*3);
         g2.drawString(" "+(gp.eco.maxEggDelay-1)+"s", buyUpgrade1.x-gp.orginalSize*2, buyUpgrade1.y+gp.orginalSize*3);

         g2.drawString(" "+(eggLimit)+"", buyUpgrade1.x-gp.orginalSize*5, buyUpgrade1.y+gp.orginalSize*6);
         g2.drawString(" "+(eggLimit+1)+"", buyUpgrade1.x-gp.orginalSize*2, buyUpgrade1.y+gp.orginalSize*6);

         g2.drawString(" "+(gp.eco.twinChance)+"%", buyUpgrade1.x-gp.orginalSize*5, buyUpgrade1.y+gp.orginalSize*9-gp.orginalSize/4);
         g2.drawString(" "+(gp.eco.twinChance+1)+"%", buyUpgrade1.x-gp.orginalSize*2, buyUpgrade1.y+gp.orginalSize*9-gp.orginalSize/4);
        }
    }
}
