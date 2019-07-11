import java.awt.Graphics;
import javax.swing.JPanel;

public class Cell extends JPanel{
    public boolean isWall = false;
    public boolean isPacman = false;

    public Cell (boolean isWall, boolean isPacman){
      this.isWall = isWall;
      this.isPacman = isPacman;
    }

    public boolean getIsWall(){
        return this.isWall;
    }

    public boolean getIsPacman(){
        return this.isPacman;
    }

//    @Override
//    public void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        g.drawRect(x,y,width,height);
//    }
}

