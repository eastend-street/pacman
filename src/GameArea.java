import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.net.MalformedURLException;

public class GameArea extends JFrame {
    public GameArea() {
        this.setTitle("Pacman");
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon icon = getImageIcon("https://images.discordapp.net/avatars/398127484983443468/0bc43684999726e69c2ca797200ffffc.png?size=512");
        initializeGameArea();
        this.setVisible(true);
    }

    Cell[][] cells = new Cell[10][10];


    private int[][] initialCellData = {
            {1, 0, 1, 0, 1, 1, 0, 1, 0, 1},
            {0, 0, 1, 0, 0, 0, 0, 1, 0, 0},
            {1, 0, 1, 1, 0, 0, 1, 1, 0, 1},
            {1, 0, 1, 0, 0, 0, 0, 1, 0, 1},
            {0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
            {1, 0, 1, 0, 1, 1, 0, 1, 0, 1},
            {1, 0, 1, 0, 0, 0, 0, 1, 0, 1},
            {1, 0, 1, 1, 0, 0, 1, 1, 0, 1},
            {0, 0, 1, 0, 2, 0, 0, 1, 0, 0},
            {1, 0, 1, 0, 1, 1, 0, 1, 0, 1},
    };


    public void initializeGameArea() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (initialCellData[i][j] == 1) {
                    cells[i][j] = new Cell(true, false);
                } else if (initialCellData[i][j] == 2) {
                    cells[i][j] = new Cell(false, true);
                } else {
                    cells[i][j] = new Cell(false, false);
                }
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics graphics = getContentPane().getGraphics();

        int x = 140;
        int y = 100;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (cells[i][j].isWall) {
                    g.setColor(Color.black);
                }else if(cells[i][j].isPacman) {
                    g.setColor(Color.yellow);
                }
                else {
                    g.setColor(Color.white);
                }
                g.fillRect(x, y, 20, 20);
                x += 20;
            }
            x = 140;
            y += 20;
        }

        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++) {
                System.out.println(cells[i][j].getIsWall());
            }
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
