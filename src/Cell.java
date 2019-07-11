import java.awt.Graphics;
import javax.swing.JPanel;

public class Cell extends JPanel {
    public int x;
    public int y;
    public boolean isWall = false;
    public boolean isPacman = false;
    public boolean isCookie = true;

    public Cell(int x, int y, boolean isWall, boolean isPacman, boolean isCookie) {
        this.x = x;
        this.y = y;
        this.isWall = isWall;
        this.isPacman = isPacman;
        this.isCookie = isCookie;
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

    public boolean getIsCookie() {
        return this.isCookie;
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

    public void setIsCookie(boolean isCookie) {
        this.isCookie = isCookie;
    }

//    @Override
//    public void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        g.drawRect(x,y,width,height);
//    }
}

