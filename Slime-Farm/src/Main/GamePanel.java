package Main;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import Entity.entity;
import Entity.slime;


public class GamePanel extends JPanel implements Runnable{
    
    public final int orginalSize = 64;
    public final int screenWidth = orginalSize * 12;//768
    public final int screenHeight = orginalSize * 16; //1024
    
    public BackgroundMenager bm = new BackgroundMenager(this);
    public UI ui= new UI(this);
    public ClickHandler cHandler = new ClickHandler(this,ui);
    public SlimeSpawner sSpawner = new SlimeSpawner(this, cHandler);
    public slime slime = new slime(this);
    public entity e[] = new entity[10];
    
    Thread gameThread;
    int FPS = 60;
    
    

    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addMouseListener(cHandler);
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
                }
           }
        }
      }

    }
        public void update(){
      
            for(int i=0;i<e.length;i++){
                if(e[i]!=null&&e[i].moveInterval==5){
                e[i].getPoint();
                e[i].moveInterval=0;
                }
            }
           
        
         for(int i=0;i<e.length;i++){
            if(e[i]!=null && e[i].startMoveing ==true){
                e[i].move();
             }
             }
        }

        public void paintComponent (Graphics g){
            super.paintComponent(g);
             Graphics2D g2 = (Graphics2D)g;
             bm.draw(g2);
             ui.draw(g2);
             
             for(int i=0;i<e.length;i++){
                if(e[i]!=null){
                    e[i].draw(g2, this);
                }
             }
             
             g2.dispose();
         }
}
