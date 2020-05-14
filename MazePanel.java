// Justin Neff - TCSS 342 Maze Generator
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class MazePanel extends JPanel {
  private static final long serialVersionUID = 6239082227515696450L;
  private int width = 0;
  private int height = 0;
  private MazeNode[][] maze;

  public void paintMaze(Maze maze) {
    setBackground(Color.BLACK);
    this.width = maze.width;
    this.height = maze.depth;
    this.maze = maze.maze;
    repaint();
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;
    g2d.setColor(Color.WHITE);
    int size = 10;
    for (int i = 0; i < width; i++) {
      for (int j = 0; j < height; j++) {
        int x = i * 14 + i * size + 14;
        int y = j * 14 + j * size + 14;

        if (maze[j][i].solution) {
          g2d.setColor(Color.GREEN);
        } else {
          g2d.setColor(Color.WHITE);
        }
        g2d.fillRect(x, y + 12, size, size);
        if (!maze[j][i].north) {
          g2d.setColor(Color.BLACK);
        } else if (j > 0 && maze[j][i].solution && maze[j - 1][i].solution && maze[j][i].north) {
          g2d.setColor(Color.GREEN);
        } else if (j > 0) {
          g2d.setColor(Color.WHITE);
        }
        g2d.fillRect(x, y, size, size);
        if (!maze[j][i].west) {
          g2d.setColor(Color.BLACK);
        } else if (i > 0 && maze[j][i].solution && maze[j][i - 1].solution && maze[j][i - 1].east) {
          g2d.setColor(Color.GREEN);
        } else if (i > 0) {
          g2d.setColor(Color.WHITE);
        }
        g2d.fillRect(x - 12, y + 12, size, size);
      }
    }
    g2d.setColor(Color.GREEN);
    g2d.fillRect(width * 14 + width * size -10, height * 14 + height * 10 + 14, size, size);
  }
}
