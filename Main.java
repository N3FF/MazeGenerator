// Justin Neff - TCSS 342 Maze Generator
import javax.swing.SwingUtilities;

public class Main {

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {

      @Override
      public void run() {
        new Window();
      }
    });
    //testMaze();
  }

  private static void testMaze() {
    int x = 1;
    int y = 1;
    Maze maze = new Maze(10,10,true);
    System.out.println(maze.maze[x][y]+"\n");
    System.out.println("Block visited: " + maze.maze[x][y].visited);
    System.out.println("Solution block: " + maze.maze[x][y].solution);
    System.out.println("North: " + maze.maze[x][y].north);
    System.out.println("East: " + maze.maze[x][y].east);
    System.out.println("South: " + maze.maze[x][y].south);
    System.out.println("West: " + maze.maze[x][y].west);
  }
}
