import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.*;

public class EnemyTimer implements ActionListener{
    Timer timer;

    EnemyTimer() {
        timer = new Timer(1000, this);
        timer.start();
    }

//    public static void printTime() {
//        System.out.println("aaaaaaaaaa");
//    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("aaagagagaga");
    }
}
