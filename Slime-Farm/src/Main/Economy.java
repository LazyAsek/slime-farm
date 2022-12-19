package Main;

public class Economy {
    GamePanel gp;
    int slime1,slime2,slime3,slime4,slime5,slime6,slime7,slime8,slime9,slime10;
    int perSec;
    int eggDelay=0,maxEggDelay=12;
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
    }

    public void updateValues(){
        gp.ui.coin += perSec;
        gp.ui.perSec = perSec;
        if(eggDelay > maxEggDelay&& gp.ui.eggs !=10){
            gp.ui.eggs++;
            eggDelay=0;
        }
        if(gp.ui.eggs !=10){
            gp.ui.eggBarUpdate();
        }

        gp.ui.formatCoins();
        gp.ui.eggsText=gp.ui.eggs +"/"+gp.ui.eggLimit;
        gp.ui.perSecText=gp.ui.perSec+"";
    }
}
