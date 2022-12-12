import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class UI {
    
    GamePanel gp;
    Font arial40;


    public UI(GamePanel gp){
        this.gp =gp;
        arial40 = new Font("Arial",Font.PLAIN,40);
    }

    public void draw(Graphics2D g2){
        String text;
        int textLength ,textHeight;
        int x,y;

        g2.setFont(arial40);
        g2.setColor(Color.WHITE);
        g2.setBackground(Color.BLUE);

        text = "Buy slime";
        textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        textHeight = (int) g2.getFontMetrics().getStringBounds(text, g2).getHeight();

        x = gp.screenWidth /2-textLength/2;
        y = gp.screenHeight - textHeight;

        g2.drawString(text, x, y);
    }
}
