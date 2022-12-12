import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;


public class GamePanel extends JPanel implements Runnable{
    
    public UI ui= new UI(this);
    
    Thread gameThread;
    int FPS = 60;
    
    public final int screenWidth = 768;
    public final int screenHeight = 1024;

    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.black);
        this.setFocusable(true);
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

        if(delta>=1){
            update();
            repaint();
            delta--;
            drawCount++;
        }
        if(timer>=1000000000){
            System.out.println("FPS"+drawCount);
            timer =0;
            drawCount =0;
        }
      }

    }
        public void update(){
           
        }

        public void paintComponent (Graphics g){
            super.paintComponent(g);
             Graphics2D g2 = (Graphics2D)g;
             
             ui.draw(g2);

             g2.dispose();
         }
}
