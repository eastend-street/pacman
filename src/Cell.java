import java.awt.Graphics;
import javax.swing.JPanel;

public class Cell extends JPanel{
    public boolean isWall = false;
    public boolean isEmpty = false;

    public Cell (boolean isWall, boolean isEmpty){
      this.isWall = isWall;
      this.isEmpty = isEmpty;
    }

//    @Override
//    public void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        g.drawRect(x,y,width,height);
//    }
}

