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
    int hatchButtonWidth,hatchButtonHeight,shopButtonWidth,shopButtonHeight,upgradeButtonWidth,upgradeButtonHeight;
    int hatchButtonX,hatchButtonY,shopButtonX,shopButtonY,upgradeButtonX,upgradeButtonY;

    int coin ,eggs,perSec,eggLimit;
    String coinText,eggsText,perSecText;
    int coinX,coinY;
    int eggsX,eggsY;
    int perSecX,perSecY;

    

    public Rectangle hatchButton ,shopButton,upgradeButton;
    
    ClickHandler cHandler = new ClickHandler(gp,this);
    
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
        coin = 0;
        coinText = coin +"";

        eggsX = hatchButtonX+100 ;
        eggsY = gp.orginalSize+gp.orginalSize/2;
        eggs = 0;
        eggLimit=10;
        eggsText = eggs +"/"+eggLimit;

        perSecX = upgradeButtonX+60 ;
        perSecY = gp.orginalSize+gp.orginalSize/2;
        perSec = 0;
        perSecText = perSec+"";
    }

    public void draw(Graphics2D g2){
      
      g2.drawImage(uiImage, 0, 0, gp.screenWidth, gp.screenHeight,null);
      g2.setFont(arial40);
      g2.drawString(coinText, coinX, coinY);
      g2.drawString(eggsText, eggsX, eggsY);
      g2.drawString(perSecText, perSecX, perSecY);
     
    }
}
