package Main;

public class Economy {
    GamePanel gp;
    int slime1,slime2,slime3,slime4,slime5,slime6,slime7,slime8,slime9,slime10;
    public int slime1Price,slime2Price,slime3Price,slime4Price,slime5Price,slime6Price,slime7Price,slime8Price,slime9Price,slime10Price;
    int slime1BCounter=1,slime2BCounter=1,slime3BCounter=1,slime4BCounter=1,slime5BCounter=1,slime6BCounter=1,slime7BCounter=1,slime8BCounter=1,slime9BCounter=1;
    int perSec;
    public double perSecMultiplayer=1;
    int eggDelay=0,maxEggDelay=12;
    int upgrade1,upgrade2,upgrade3,upgrade4;
    int upgrade1Price,upgrade2Price,upgrade3Price,upgrade4Price;
    int upgrade1BCounter=1,upgrade2BCounter=1,upgrade3BCounter=1,upgrade4BCounter=1;
    int twinChance=1;
    public Economy(GamePanel gp){
        this.gp=gp;
    }

    public void getTiers(){
        slime1=0;
        slime2=0;
        slime3=0;
        slime4=0;
        slime5=0;
        slime6=0;
        slime7=0;
        slime8=0;
        slime9=0;
        slime10=0;
        perSec=0;
        for(int i=0;i<gp.e.length;i++){
            if(gp.e[i]!=null){
                switch(gp.e[i].currentImage){
                    case 3,2,1,0:
                    slime1++;
                    break;
                    case 4:
                    slime2++;
                    gp.ui.unlocked2 = true;
                    break;
                    case 5:
                    slime3++;
                    gp.ui.unlocked3 = true;
                    break;
                    case 6:
                    slime4++;
                    gp.ui.unlocked4 = true;
                    break;
                    case 7:
                    slime5++;
                    gp.ui.unlocked5 = true;
                    break;
                    case 8:
                    slime6++;
                    gp.ui.unlocked6 = true;
                    break;
                    case 9:
                    slime7++;
                    gp.ui.unlocked7 = true;
                    break;
                    case 10:
                    slime8++;
                    gp.ui.unlocked8 = true;
                    break;
                    case 11:
                    slime9++;
                    gp.ui.unlocked9 = true;
                    break;
                    case 12:
                    slime10++;
                    break;
                }
               }
           }
           getPerSec();
    }
    public void getPerSec(){
        perSec +=slime1;
        perSec +=slime2*3;
        perSec +=slime3*9;
        perSec +=slime4*27;
        perSec +=slime5*81;
        perSec +=slime6*243;
        perSec +=slime7*729;
        perSec +=slime8*2187;
        perSec +=slime9*6561;
        perSec +=slime10*19683;
        perSec =(int) (perSec *perSecMultiplayer);
    }

    public void getPrices(){
        if(gp.ui.shopOpen==true){
            slime1Price = (slime1BCounter*2)*25*5;
            slime2Price = (slime2BCounter*2)*75*5;
            slime3Price = (slime3BCounter*2)*225*5;
            slime4Price = (slime4BCounter*2)*675*5;
            slime5Price = (slime5BCounter*2)*2025*5;
            slime6Price = (slime6BCounter*2)*6075*5;
            slime7Price = (slime7BCounter*2)*18225*5;
            slime8Price = (slime8BCounter*2)*54675*5;
            slime9Price = (slime9BCounter*2)*164025*5;
        }
        if(gp.ui.upgradeShopOpen==true){
            upgrade1Price = (upgrade1BCounter*10)*100;
            upgrade2Price = (upgrade2BCounter*2)*200;
            upgrade3Price = (upgrade3BCounter*10)*400;
            upgrade4Price = (upgrade4BCounter*10)*50;
        }
    }

    public void updateValues(){
        gp.ui.coin += perSec;
        gp.ui.perSec = perSec;
        if(eggDelay > maxEggDelay&& gp.ui.eggs !=gp.ui.eggLimit){
            gp.ui.eggs++;
            eggDelay=0;
        }
        if(gp.ui.eggs !=gp.ui.eggLimit){
            gp.ui.eggBarUpdate();
        }

        gp.ui.formatCoins();
        gp.ui.eggsText=gp.ui.eggs +"/"+gp.ui.eggLimit;
        gp.ui.perSecText=gp.ui.perSec+"";
    }
}
