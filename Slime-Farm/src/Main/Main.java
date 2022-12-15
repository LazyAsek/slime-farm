package Main;
import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) throws Exception {
        //make window with game panel
        JFrame window = new JFrame();
        window.setResizable(false);
        window.setTitle("Slime-Farm");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //add Game panel
        GamePanel gp = new GamePanel();
        window.add(gp);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gp.startGameThread();
    }
}
