// Justin Neff - TCSS 342 Maze Generator
public class Maze {

  int depth;
  int width;
  private boolean complete;
  private boolean debug;
  MazeNode maze[][] = null;

  Maze(int width, int depth, boolean debug) {
    this.depth = depth;
    this.width = width;
    this.debug = debug;
    maze = new MazeNode[depth][width];
    buildMaze();
    complete = true;
    display();
  }

  private void buildMaze() {
    for (int i = 0; i < depth; i++) {
      for (int j = 0; j < width; j++) {
        maze[i][j] = new MazeNode(i, j);
      }
    }
    maze[0][0].north = true;
    recurse(maze[0][0]);
  }

  private MazeNode recurse(MazeNode node) {
    if (debug) {
      display();
    }
    node.visited = true;
    if (node.x == depth - 1 && node.y == width - 1) {
      node.south = true;
      node.solution = true;
      return node;
    }
    while (node.hasNewDirection()) {
      int dir = node.randomDir();
      if (dir == 0 && node.x - 1 >= 0 && !maze[node.x - 1][node.y].visited) {
        node.north = true;
        maze[node.x - 1][node.y].south = true;
        if (recurse(maze[node.x - 1][node.y]).solution) {
          node.solution = true;
        }
      } else if (dir == 1 && node.x + 1 < depth && !maze[node.x + 1][node.y].visited) {
        node.south = true;
        maze[node.x + 1][node.y].north = true;
        if (recurse(maze[node.x + 1][node.y]).solution) {
          node.solution = true;
        }
      } else if (dir == 2 && node.y - 1 >= 0 && !maze[node.x][node.y - 1].visited) {
        node.west = true;
        maze[node.x][node.y - 1].east = true;
        if (recurse(maze[node.x][node.y - 1]).solution) {
          node.solution = true;
        }
      } else if (dir == 3 && node.y + 1 < width && !maze[node.x][node.y + 1].visited) {
        node.east = true;
        maze[node.x][node.y + 1].west = true;
        if (recurse(maze[node.x][node.y + 1]).solution) {
          node.solution = true;
        }
      }
    }
    return node;
  }

  public void display() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < depth; i++) {
      for (int j = 0; j < width; j++) {
        sb.append(maze[i][j].topString());
      }
      sb.append(" X\n");
      for (int j = 0; j < width; j++) {
        sb.append(maze[i][j].midString(complete));
      }
      sb.append(" X\n");
    }
    for (int i = 0; i < width * 2 - 1; i++) {
      sb.append(" X");
    }
    sb.append("   X\n\n");
    System.out.println(sb);
  }
}
