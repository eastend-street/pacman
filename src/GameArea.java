import javax.swing.JFrame;

public class GameArea extends JFrame {
    public GameArea(String title, int width, int height) {
        setTitle(title);
        setSize(width, height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
