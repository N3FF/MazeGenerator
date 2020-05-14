// Justin Neff - TCSS 342 Maze Generator
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Window extends JFrame {



  private static final Dimension DEFAULT_WINDOW_SIZE = new Dimension(400 + 100, 400);
  private static final Dimension MIN_WINDOW_SIZE = new Dimension(400 + 100, 400);
  private static final long serialVersionUID = 1L;
  private BorderLayout layout = new BorderLayout();
  private MazePanel mazePanel = new MazePanel();
  private Maze maze;

  Window() {
    setupWindow();
    addComponents();
    createMaze(10, 10, false);
    this.setVisible(true);
  }
  private void addComponents() {
    JButton newMaze = new JButton("New Maze");
    JCheckBox check = new JCheckBox("Debug");
    JTextField wBox = new JTextField("10",2);
    JTextField hBox = new JTextField("10",2);
    JLabel size = new JLabel("Size");
    JPanel rightPan = new JPanel();
    rightPan.setPreferredSize(new Dimension(100, MIN_WINDOW_SIZE.height));
    rightPan.add(size);
    rightPan.add(wBox);
    rightPan.add(hBox);
    rightPan.add(newMaze);
    rightPan.add(check);
    this.add(mazePanel, BorderLayout.CENTER);
    this.add(rightPan, BorderLayout.EAST);
    newMaze.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        try {
          int width = Integer.parseInt(wBox.getText());
          int height = Integer.parseInt(hBox.getText());
          if(width > 50) {
            width = 50;
            wBox.setText("50");
          }
          if(height > 50) {
            height = 50;
            hBox.setText("50");
          }
          createMaze(width, height, check.isSelected());
        } catch (NumberFormatException ex) {
        }

      }
    });
  }

  private void createMaze(int width, int height, boolean debug) {
    maze = new Maze(width, height, debug);
    mazePanel.paintMaze(maze);
  }

  private void setupWindow() {
    this.setSize(DEFAULT_WINDOW_SIZE);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("Maze Generator");
    this.setMinimumSize(MIN_WINDOW_SIZE);
    this.setLayout(layout);
  }
}
