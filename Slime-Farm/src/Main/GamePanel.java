package Main;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import javax.swing.JPanel;
import java.awt.GraphicsEnvironment;
import Entity.entity;
import Entity.slime;


public class GamePanel extends JPanel implements Runnable{
    
      GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    //  public final int screenWidth= gd.getDisplayMode().getWidth()/2;
    //  public final int screenHeight= gd.getDisplayMode().getHeight()-100;
      public final int orginalSize = 64;
      public final int screenWidth = orginalSize * 12;//768
      public final int screenHeight = orginalSize * 16; //1024
    
    public BackgroundMenager bm = new BackgroundMenager(this);
    public UI ui= new UI(this);
    public ClickHandler cHandler = new ClickHandler(this,ui);
    public SlimeSpawner sSpawner = new SlimeSpawner(this, cHandler);
    public slime slime = new slime(this);
    public entity e[] = new entity[300];
    public Economy eco = new Economy(this);
    public Saves s = new Saves(this);
    Sound music = new Sound();
    Sound SE = new Sound();
    Thread gameThread;
    int FPS = 60;
    
    

    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addMouseListener(cHandler);
        this.addMouseMotionListener(cHandler);
        playMusic(0);
        s.load();
        if(s.FirstSave==true){
           s.save();
        }
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
      double drawInterval = 1000000000/FPS;
      double delta=0;
      long lastTime = System.nanoTime();
      long timer=0,currentTime;
      int drawCount=0;
      sSpawner.loadSlimes();
      
      while(gameThread !=null){
        currentTime = System.nanoTime();

        delta +=(currentTime - lastTime)/drawInterval;
        timer +=(currentTime-lastTime);
        lastTime = currentTime;
        //drawas 60 per secound
        if(delta>=1){
            update();
            repaint();
            delta--;
            drawCount++;
        }
        //once per secound
        if(timer>=1000000000){
            System.out.println("FPS"+drawCount);
            timer =0;
            drawCount =0;
            for(int i=0;i<e.length;i++){
                if(e[i]!=null){
                e[i].moveInterval ++;
                if(e[i].hatchframe<3&& e[i].currentImage<3){
                    e[i].currentImage++;
                    e[i].hatchframe++;
                }
            }
        }
        eco.getTiers();
        eco.eggDelay++;
        eco.updateValues();
        s.SaveInterval--;
        if(s.FirstSave==true){
            s.FirstSave=false;
        }
        if(s.SaveInterval==0){
            s.SaveInterval=10;
            s.save();
        }
        }
      }

    }
        public void update(){
            //cHandler.mosePostion();
           // System.out.println(cHandler.mouseX+" "+cHandler.mouseY);
            //gets new destination point every 5 secounds
            for(int i=0;i<e.length;i++){
                if(e[i]!=null&&e[i].moveInterval==5){
                e[i].getPoint(this);
                e[i].moveInterval=0;
                }
            }
           
            //moves entities to destination point
         for(int i=0;i<e.length;i++){
            if(e[i]!=null && e[i].startMoveing ==true){
                e[i].move(this);
             }
             }
         if(cHandler.hold==true){
           
            e[cHandler.clickedEntity].drag(this,cHandler.mouseX,cHandler.mouseY);
            e[cHandler.clickedEntity].getPoint(this);
             }

        }
        

        public void paintComponent (Graphics g){
            super.paintComponent(g);
             Graphics2D g2 = (Graphics2D)g;
             bm.draw(g2);
             
             for(int i=0;i<e.length;i++){
                 if(e[i]!=null){
                     e[i].draw(g2, this);
                    }
                }
                
             ui.draw(g2);
             g2.dispose();
         }
         public void playMusic(int i){
            music.setFile(i);
            music.play();
            music.loop();
         }
         public void stopMusic(){
            music.stop();
         }
         public void playSE(int i){
            SE.setFile(i);
            SE.play();
         }
}
