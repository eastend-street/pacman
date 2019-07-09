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
        drawArea();
        this.setVisible(true);
    }

    Cell[][] cells = new Cell[10][10];

    void drawArea() {
        int posX = 0;
        int posY = 0;
        Cell aCell = new Cell(0, 0);
        for (int x = 0; x < cells.length; x++) {
            for (int y = 0; y < cells[x].length; y++) {

                aCell = new Cell(posX, posY);
                this.add(aCell);
                // cells[x][y] = aCell;
                posY += aCell.width;
                if (y >= cells[x].length - 1) {
                    posY = 0;
                }
            }
            posX += aCell.height;
            if (posX == cells.length - 1) {
                posX = 0;
            }
        }

        this.add(new Cell(30, 30));
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
}
