import java.awt.Graphics;
import javax.swing.JPanel;

public class Cell extends JPanel{
    private int x = 0;
    private int y = 0;
    public int width = 20;
    public int height = 20;
    public Cell (int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawRect(x,y,width,height);
    }
}

