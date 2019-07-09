import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.net.MalformedURLException;

public class GameArea extends JFrame {
    public GameArea(String title, int width, int height) {
        setTitle(title);
        setSize(width, height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton btn = new JButton("New button");
        add(btn, BorderLayout.NORTH);

        ImageIcon icon= getImageIcon("https://images.discordapp.net/avatars/398127484983443468/0bc43684999726e69c2ca797200ffffc.png?size=512");
        setIconImage(icon.getImage());

        JLabel label1 = new JLabel(icon);

        JPanel panel = new JPanel();
        panel.add(label1);
        add(panel, BorderLayout.CENTER);
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
