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
    Cell enemyLocationCell;

    private int[][] initialCellData = {
            {1, 0, 1, 0, 1, 1, 0, 1, 0, 1},
            {0, 0, 1, 0, 0, 0, 0, 1, 0, 0},
            {1, 0, 1, 1, 0, 0, 1, 1, 0, 1},
            {1, 0, 1, 0, 3, 0, 0, 1, 0, 1},
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
                    cells[i][j] = new Cell(i, j, true, false, false, false);
                } else if (initialCellData[i][j] == 2) {
                    cells[i][j] = new Cell(i, j, false, true, false, false);
                    pacmanLocationCell = cells[i][j];
                } else if (initialCellData[i][j] == 3) {
                    cells[i][j] = new Cell(i, j, false, false, false, true);
                    enemyLocationCell = cells[i][j];
                } else {
                    cells[i][j] = new Cell(i, j, false, false, true, false);
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
                } else if (cells[i][j].isEnemy) {
                    g.setColor(new Color(235, 2, 0));
                    g.fillOval(x, y, 20, 20);
                } else if (cells[i][j].isCookie) {
                    g.setColor(new Color(2, 2, 2));
                    g.fillRect(x, y, 20, 20);
                    g.setColor(new Color(252, 252, 252));
                    g.fillOval(x + 7, y + 7, 5, 5);
                } else {
                    g.setColor(new Color(2, 2, 2));
                    g.fillRect(x, y, 20, 20);
                }
                x += 20;
            }
            x = 140;
            y += 20;
        }
    }

    public void update(Cell cell) {
        Graphics g = getContentPane().getGraphics();
        int x = cell.getX();
        int y = cell.getY();

        System.out.println("X: " + cell.getX());
        System.out.println("Y: " + cell.getX());
        System.out.println("isPacman: " + cell.getIsPacman());
        System.out.println("isCookie: " + cell.getIsCookie());
        System.out.println("isEnemy: " + cell.getIsCookie());
//        if (cell.isPacman) {
//            g.setColor(new Color(251, 246, 6));
//            g.fillOval(x, y, 20, 20);
//        } else if (cell.isEnemy) {
//            g.setColor(new Color(235, 2, 0));
//            g.fillOval(x, y, 20, 20);
//        } else if (cell.isCookie) {
//            g.setColor(new Color(2, 2, 2));
//            g.fillRect(x, y, 20, 20);
//            g.setColor(new Color(252, 252, 252));
//            g.fillOval(x + 7, y + 7, 5, 5);
//        } else {
//            g.setColor(new Color(2, 2, 2));
//            g.fillRect(x, y, 20, 20);
//        }
    }

    private class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            Cell currentCell = cells[pacmanLocationCell.getX()][pacmanLocationCell.getY()];
            Cell nextCell = cells[pacmanLocationCell.getX()][pacmanLocationCell.getY()];
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP:
                    if (pacmanLocationCell.getX() - 1 < 0) {
                        nextCell = cells[9][pacmanLocationCell.getY()];
                    } else {
                        nextCell = cells[pacmanLocationCell.getX() - 1][pacmanLocationCell.getY()];
                    }
                    if (!nextCell.getIsWall()) {
                        currentCell.setIsPacman(false);
                        currentCell.setIsCookie(false);
                        nextCell.setIsPacman(true);
                        pacmanLocationCell = nextCell;
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if (pacmanLocationCell.getX() + 1 > 9) {
                        nextCell = cells[0][pacmanLocationCell.getY()];
                    } else {
                        nextCell = cells[pacmanLocationCell.getX() + 1][pacmanLocationCell.getY()];
                    }
                    if (!nextCell.getIsWall()) {
                        currentCell.setIsPacman(false);
                        currentCell.setIsCookie(false);
                        nextCell.setIsPacman(true);
                        pacmanLocationCell = nextCell;
                    }
                    break;
                case KeyEvent.VK_LEFT:
                    if (pacmanLocationCell.getY() - 1 < 0) {
                        nextCell = cells[pacmanLocationCell.getX()][9];
                    } else {
                        nextCell = cells[pacmanLocationCell.getX()][pacmanLocationCell.getY() - 1];
                    }
                    if (!nextCell.getIsWall()) {
                        currentCell.setIsPacman(false);
                        currentCell.setIsCookie(false);
                        nextCell.setIsPacman(true);
                        pacmanLocationCell = nextCell;
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if (pacmanLocationCell.getY() + 1 > 9) {
                        nextCell = cells[pacmanLocationCell.getX()][0];
                    } else {
                        nextCell = cells[pacmanLocationCell.getX()][pacmanLocationCell.getY() + 1];
                    }
                    if (!nextCell.getIsWall()) {
                        currentCell.setIsPacman(false);
                        currentCell.setIsCookie(false);
                        nextCell.setIsPacman(true);
                        pacmanLocationCell = nextCell;
                    }
                    break;

            }
//            update(currentCell);
//            update(nextCell);
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
