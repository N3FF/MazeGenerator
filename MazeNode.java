// Justin Neff - TCSS 342 Maze Generator
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MazeNode {
  private Random rand = new Random();
  int x = 0;
  int y = 0;
  boolean north;
  boolean south;
  boolean east;
  boolean west;
  boolean visited;
  boolean solution;
  ArrayList<Integer> direction = new ArrayList<>(Arrays.asList(0, 1, 2, 3));

  MazeNode(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int randomDir() {
    int d = direction.remove(rand.nextInt(direction.size()));
    return d;
  }

  public boolean hasNewDirection() {
    return direction.size() > 0;
  }

  public String topString() {
    StringBuilder sb = new StringBuilder();
    sb.append(" X");
    sb.append(north ? "  " : " X");
    return sb.toString();
  }

  public String midString(boolean solved) {
    StringBuilder sb = new StringBuilder();
    sb.append(west ? "  " : " X");
    if (solved)
      sb.append(solution ? " +" : "  ");
    else
      sb.append(visited ? " V" : "  ");
    return sb.toString();
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Block: " + x + ", " + y + "\n");
    sb.append("X");
    sb.append(north ? "  " : " X");
    sb.append(" X\n");
    sb.append(west ? " " : "X");
    sb.append(solution ? " +": "  ");
    sb.append(east ? "  " : " X");
    sb.append("\n");
    sb.append("X");
    sb.append(south ? "  " : " X");
    sb.append(" X");
    return sb.toString();
  }

}
