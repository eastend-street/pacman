import java.awt.Graphics;
import javax.swing.JPanel;

public class Cell extends JPanel {
    public int x;
    public int y;
    public boolean isWall = false;
    public boolean isPacman = false;

    public Cell(int x, int y, boolean isWall, boolean isPacman) {
        this.x = x;
        this.y = y;
        this.isWall = isWall;
        this.isPacman = isPacman;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public boolean getIsWall() {
        return this.isWall;
    }

    public boolean getIsPacman() {
        return this.isPacman;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setIsWall(boolean isWall) {
        this.isWall = isWall;
    }

    public void setIsPacman(boolean isPacman) {
        this.isPacman = isPacman;
    }

//    @Override
//    public void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        g.drawRect(x,y,width,height);
//    }
}

