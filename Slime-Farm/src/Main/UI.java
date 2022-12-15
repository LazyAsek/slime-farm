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
    BufferedImage buyButtonBackground ,shopButtonBackground,upgradeButtonBackground;
    int buyButtonWidth,buyButtonHeight,shopButtonWidth,shopButtonHeight,upgradeButtonWidth,upgradeButtonHeight;
    int buyButtonX,buyButtonY,shopButtonX,shopButtonY,upgradeButtonX,upgradeButtonY;

    public Rectangle buyButton ,shopButton,upgradeButton;
    
    ClickHandler cHandler = new ClickHandler(gp,this);
    
    public UI(GamePanel gp){
        this.gp =gp;
        buyButton();
        shopButton();
        upgradeButton();
    }

    public void buyButton(){
        buyButtonWidth =gp.screenWidth/3;
        buyButtonHeight = 64 *2;
        try{
            buyButtonBackground = ImageIO.read(new FileInputStream("Slime-Farm/res/UI/buybutton.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
        buyButtonX= gp.screenWidth/2-buyButtonWidth/2;
        buyButtonY= gp.screenHeight-buyButtonHeight;

        buyButton = new Rectangle(buyButtonX,buyButtonY,buyButtonWidth,buyButtonHeight);
    }

    public void shopButton(){
        shopButtonWidth =gp.screenWidth/3;
        shopButtonHeight = 64 *2;
        try{
            shopButtonBackground = ImageIO.read(new FileInputStream("Slime-Farm/res/UI/shopbutton.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
        shopButtonX=0;
        shopButtonY= gp.screenHeight-shopButtonHeight;

        shopButton = new Rectangle(shopButtonX,shopButtonY,shopButtonWidth,shopButtonHeight);
    }

    public void upgradeButton(){
        upgradeButtonWidth =gp.screenWidth/3;
        upgradeButtonHeight = 64 *2;
        try{
            upgradeButtonBackground = ImageIO.read(new FileInputStream("Slime-Farm/res/UI/upgradeButton.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
        upgradeButtonX= upgradeButtonWidth*2;
        upgradeButtonY= gp.screenHeight-upgradeButtonHeight;

        upgradeButton = new Rectangle(upgradeButtonX,upgradeButtonY,upgradeButtonWidth,upgradeButtonHeight);
    }

    public void draw(Graphics2D g2){
      
      g2.drawImage(buyButtonBackground, buyButtonX, buyButtonY, buyButtonWidth, buyButtonHeight,null);
      g2.drawImage(shopButtonBackground, shopButtonX, shopButtonY, shopButtonWidth, shopButtonHeight,null);
      g2.drawImage(upgradeButtonBackground, upgradeButtonX, upgradeButtonY, upgradeButtonWidth, upgradeButtonHeight,null);
     
    }
}
