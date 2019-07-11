import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.net.MalformedURLException;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameArea extends JFrame implements Runnable {
    public GameArea() {
        this.setTitle("Pacman");
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon icon = getImageIcon("https://images.discordapp.net/avatars/398127484983443468/0bc43684999726e69c2ca797200ffffc.png?size=512");
        this.getContentPane().setBackground(new Color(2, 2, 2));
        initializeGameArea();


        MyKeyAdapter myKeyAdapter = new MyKeyAdapter();
        addKeyListener(myKeyAdapter);

        this.setVisible(true);
    }

    Cell[][] cells = new Cell[10][10];
    Cell pacmanLocationCell;

    private int[][] initialCellData = {
            {1, 0, 1, 0, 1, 1, 0, 1, 0, 1},
            {0, 0, 1, 0, 0, 0, 0, 1, 0, 0},
            {1, 0, 1, 1, 0, 0, 1, 1, 0, 1},
            {1, 0, 1, 0, 0, 0, 0, 1, 0, 1},
            {0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
            {1, 0, 1, 0, 1, 1, 0, 1, 0, 1},
            {1, 0, 1, 0, 0, 0, 0, 1, 0, 1},
            {1, 0, 1, 1, 0, 0, 1, 1, 0, 1},
            {0, 0, 1, 0, 2, 0, 0, 1, 0, 0},
            {1, 0, 1, 0, 1, 1, 0, 1, 0, 1},
    };


    public void initializeGameArea() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (initialCellData[i][j] == 1) {
                    cells[i][j] = new Cell(i, j, true, false);
                } else if (initialCellData[i][j] == 2) {
                    cells[i][j] = new Cell(i, j, false, true);
                    pacmanLocationCell = cells[i][j];
                } else {
                    cells[i][j] = new Cell(i, j, false, false);
                }
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics graphics = getContentPane().getGraphics();

        int x = 140;
        int y = 100;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (cells[i][j].isWall) {
                    g.setColor(new Color(5, 19, 185));
                    g.fillRect(x, y, 20, 20);
                } else if (cells[i][j].isPacman) {
                    g.setColor(new Color(251, 246, 6));
                    g.fillOval(x, y, 20, 20);
                } else {
                    g.setColor(new Color(2, 2, 2));
                    g.fillRect(x, y, 20, 20);
                    g.setColor(new Color(252, 252, 252));
                    g.fillOval(x + 7, y + 7, 5, 5);
                }
                x += 20;
            }
            x = 140;
            y += 20;
        }
    }

    private class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            Cell currentCell = cells[pacmanLocationCell.getX()][pacmanLocationCell.getY()];
            Cell nextCell;
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP:
                    nextCell = cells[pacmanLocationCell.getX() - 1][pacmanLocationCell.getY()];
                    if (!nextCell.getIsWall()) {
                        currentCell.setIsPacman(false);
                        nextCell.setIsPacman(true);
                        pacmanLocationCell = nextCell;
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    nextCell = cells[pacmanLocationCell.getX() + 1][pacmanLocationCell.getY()];
                    if (!nextCell.getIsWall()) {
                        currentCell.setIsPacman(false);
                        nextCell.setIsPacman(true);
                        pacmanLocationCell = nextCell;
                    }
                    break;
                case KeyEvent.VK_LEFT:
                    nextCell = cells[pacmanLocationCell.getX()][pacmanLocationCell.getY() - 1];
                    if (!nextCell.getIsWall()) {
                        currentCell.setIsPacman(false);
                        nextCell.setIsPacman(true);
                        pacmanLocationCell = nextCell;
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    nextCell = cells[pacmanLocationCell.getX()][pacmanLocationCell.getY() + 1];
                    if (!nextCell.getIsWall()) {
                        currentCell.setIsPacman(false);
                        nextCell.setIsPacman(true);
                        pacmanLocationCell = nextCell;
                    }
                    break;

            }
            repaint();
        }

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

    @Override
    public void run() {
        while (true) {
            repaint();
        }
    }
}
