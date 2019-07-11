import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.Arrays;

public class GameArea extends JFrame {
    public GameArea() {
        this.setTitle("Pacman");
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon icon = getImageIcon("https://images.discordapp.net/avatars/398127484983443468/0bc43684999726e69c2ca797200ffffc.png?size=512");
        this.setVisible(true);
    }

    private int[][] walldata = {
            {1, 0, 1, 0, 1, 1, 0, 1, 0, 1},
            {0, 0, 1, 0, 0, 0, 0, 1, 0, 0},
            {1, 0, 1, 1, 0, 0, 1, 1, 0, 1},
            {1, 0, 1, 0, 0, 0, 0, 1, 0, 1},
            {0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
            {1, 0, 1, 0, 1, 1, 0, 1, 0, 1},
            {1, 0, 1, 0, 0, 0, 0, 1, 0, 1},
            {1, 0, 1, 1, 0, 0, 1, 1, 0, 1},
            {0, 0, 1, 0, 0, 0, 0, 1, 0, 0},
            {1, 0, 1, 0, 1, 1, 0, 1, 0, 1},
    };


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics graphics = getContentPane().getGraphics();

        Object[][] area = new Object[10][10];

        int x = 140;
        int y = 100;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                area[i][j] = new Cell(false, false);

                if (walldata[i][j] == 1) {
                    g.setColor(Color.black);
                    g.fillRect(x, y, 20, 20);
                } else {
                    g.setColor(Color.white);
                    g.fillRect(x, y, 20, 20);
                }
                x += 20;
            }
            x = 140;
            y += 20;
        }
    }

    ImageIcon getImageIcon(String argUrl) {
        URL url = null;
        try {
            url = new URL(argUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        ImageIcon icon = new ImageIcon(url);
        return icon;
    }

//    @Override
//    public void run() {
//       while(true){
//           drawArea();
//           repaint();
//       }
//    }
}
