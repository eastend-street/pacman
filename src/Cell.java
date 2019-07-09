import java.awt.Graphics;
import javax.swing.JPanel;

public class Cell extends JPanel {
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawLine(100,100,200,200);
    }
}

