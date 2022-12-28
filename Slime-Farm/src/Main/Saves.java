package Main;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

public class Saves {

    GamePanel gp;

    public boolean FirstSave=true;
    public int SaveInterval=5;
    public Saves(GamePanel gp){
        this.gp=gp;
    }

    public void save(){
        try{
            FileWriter writer = new FileWriter("Slime-Farm/res/saveFile.txt");
            writer.write("FirstSave="+FirstSave+"\n"); 
            writer.write("Coins="+gp.ui.coin+"\n");
            writer.write("Eggs="+gp.ui.eggs+"\n");
            writer.write("slime2Unlocked="+gp.ui.unlocked2+"\n");
            writer.write("slime3Unlocked="+gp.ui.unlocked3+"\n");
            writer.write("slime4Unlocked="+gp.ui.unlocked4+"\n");
            writer.write("slime5Unlocked="+gp.ui.unlocked5+"\n");
            writer.write("slime6Unlocked="+gp.ui.unlocked6+"\n");
            writer.write("slime7Unlocked="+gp.ui.unlocked7+"\n");
            writer.write("slime8Unlocked="+gp.ui.unlocked8+"\n");
            writer.write("slime9Unlocked="+gp.ui.unlocked9+"\n");
            writer.write("slime1BCounter="+gp.eco.slime1BCounter+"\n");
            writer.write("slime2BCounter="+gp.eco.slime2BCounter+"\n");
            writer.write("slime3BCounter="+gp.eco.slime3BCounter+"\n");
            writer.write("slime4BCounter="+gp.eco.slime4BCounter+"\n");
            writer.write("slime5BCounter="+gp.eco.slime5BCounter+"\n");
            writer.write("slime6BCounter="+gp.eco.slime6BCounter+"\n");
            writer.write("slime7BCounter="+gp.eco.slime7BCounter+"\n");
            writer.write("slime8BCounter="+gp.eco.slime8BCounter+"\n");
            writer.write("slime9BCounter="+gp.eco.slime9BCounter+"\n");
            writer.write("PerSecMulitplayer="+gp.eco.perSecMultiplayer+"\n");
            writer.write("maxeggdelay="+gp.eco.maxEggDelay+"\n");
            writer.write("eggLimit="+gp.ui.eggLimit+"\n");
            writer.write("twinsChance="+gp.eco.twinChance+"\n");
            writer.write("upgrade1BCounter="+gp.eco.upgrade1BCounter+"\n");
            writer.write("upgrade2BCounter="+gp.eco.upgrade2BCounter+"\n");
            writer.write("upgrade3BCounter="+gp.eco.upgrade3BCounter+"\n");
            writer.write("upgrade4BCounter="+gp.eco.upgrade4BCounter+"\n");
            writer.write("slime1="+gp.eco.slime1+"\n");
            writer.write("slime2="+gp.eco.slime2+"\n");
            writer.write("slime3="+gp.eco.slime3+"\n");
            writer.write("slime4="+gp.eco.slime4+"\n");
            writer.write("slime5="+gp.eco.slime5+"\n");
            writer.write("slime6="+gp.eco.slime6+"\n");
            writer.write("slime7="+gp.eco.slime7+"\n");
            writer.write("slime8="+gp.eco.slime8+"\n");
            writer.write("slime9="+gp.eco.slime9+"\n");
            writer.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public void load(){
        int currentline=0;
        try{
            BufferedReader reader = new BufferedReader(new FileReader("Slime-Farm/res/saveFile.txt"));
            String line = reader.readLine();
            while (line != null) {
                String value =(line.substring(line.indexOf("=")+1));
                switch(currentline+1){
                    case 1:FirstSave = Boolean.parseBoolean(value);
                    break;
                    case 2:gp.ui.coin = Integer.parseInt(value);
                    break;
                    case 3:gp.ui.eggs = Integer.parseInt(value);
                    break;
                    case 4:gp.ui.unlocked2 =Boolean.parseBoolean(value);
                    break;
                    case 5:gp.ui.unlocked3 =Boolean.parseBoolean(value);
                    break;
                    case 6:gp.ui.unlocked4 =Boolean.parseBoolean(value);
                    break;
                    case 7:gp.ui.unlocked5 =Boolean.parseBoolean(value);
                    break;
                    case 8:gp.ui.unlocked6 =Boolean.parseBoolean(value);
                    break;
                    case 9:gp.ui.unlocked7 =Boolean.parseBoolean(value);
                    break;
                    case 10:gp.ui.unlocked8 =Boolean.parseBoolean(value);
                    break;
                    case 11:gp.ui.unlocked9 =Boolean.parseBoolean(value);
                    break;
                    case 12:gp.eco.slime1BCounter=Integer.parseInt(value);
                    break;        
                    case 13:gp.eco.slime2BCounter=Integer.parseInt(value);
                    break;        
                    case 14:gp.eco.slime3BCounter=Integer.parseInt(value);
                    break;        
                    case 15:gp.eco.slime4BCounter=Integer.parseInt(value);
                    break;        
                    case 16:gp.eco.slime5BCounter=Integer.parseInt(value);
                    break;        
                    case 17:gp.eco.slime6BCounter=Integer.parseInt(value);
                    break;        
                    case 18:gp.eco.slime7BCounter=Integer.parseInt(value);
                    break;        
                    case 19:gp.eco.slime8BCounter=Integer.parseInt(value);
                    break;        
                    case 20:gp.eco.slime9BCounter=Integer.parseInt(value);
                    break;        
                    case 21:gp.eco.perSecMultiplayer = Double.parseDouble(value);
                    break;        
                    case 22:gp.eco.maxEggDelay=Integer.parseInt(value);
                    break; 
                    case 23:gp.ui.eggLimit=Integer.parseInt(value);
                    break; 
                    case 24:gp.eco.twinChance=Integer.parseInt(value);
                    break; 
                    case 25:gp.eco.upgrade1BCounter=Integer.parseInt(value);
                    break; 
                    case 26:gp.eco.upgrade2BCounter=Integer.parseInt(value);
                    break; 
                    case 27:gp.eco.upgrade3BCounter=Integer.parseInt(value);
                    break; 
                    case 28:gp.eco.upgrade4BCounter=Integer.parseInt(value);
                    break; 
                    case 29:gp.eco.slime1=Integer.parseInt(value);
                    break;        
                    case 30:gp.eco.slime2=Integer.parseInt(value);
                    break;        
                    case 31:gp.eco.slime3=Integer.parseInt(value);
                    break;        
                    case 32:gp.eco.slime4=Integer.parseInt(value);
                    break;        
                    case 33:gp.eco.slime5=Integer.parseInt(value);
                    break;        
                    case 34:gp.eco.slime6=Integer.parseInt(value);
                    break;        
                    case 35:gp.eco.slime7=Integer.parseInt(value);
                    break;        
                    case 36:gp.eco.slime8=Integer.parseInt(value);
                    break;        
                    case 37:gp.eco.slime9=Integer.parseInt(value);
                    break;                                                                                                                                                                                                                                                                                                                                                                                                   
                }
				
				
				line = reader.readLine();
                currentline++;
			}
            currentline=0;

			reader.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
