import java.util.Scanner;

//=================================================
// YOUR NAME GOES HERE
// Which project is this?
// Due Date
//
// What is this file/module used for?
//=================================================
class Maze{

    // data members
    private int r;
    private int c;
    private int count = 0;
    private char[][] maze;
    private Point start;
    private Point end;
    private String alphabet = "abcdefghijklmnopqrstuvwxyz";
    private boolean solved = false;
    // member functions

    // default constructor
    Maze(){

    }


    // overloaded constructor
    Maze(int r, int c){
        this.r = r;
        this.c = c;
        maze = new char[r][c];
    }

    // initialize method
    public void initialize() {
        maze = null;
        r = 0;
        c = 0;
    }

    // read method
    public void read(Scanner sc) {
        sc.nextLine();
        String[] size = sc.nextLine().trim().split(" ");
        r = Integer.parseInt(size[0]);
        c = Integer.parseInt(size[1]);

        maze = new char[r][c];

        String[] position = sc.nextLine().trim().split(" ");
        // need to check how to use read method of Point
        start = new Point(Integer.parseInt(position[0])-1, Integer.parseInt(position[1])-1);
        end = new Point(Integer.parseInt(position[2])-1, Integer.parseInt(position[3])-1);

        for(int row = 0; row < r; row++) {
            String line = sc.nextLine();
            for(int col = 0; col < c; col++) {
                maze[row][col] = line.charAt(col);
            }
        }
    }

    // print method
    public void print() {
        for(int r = 0; r < this.r; r++) {
            for(int c = 0; c < this.c; c++) {
                System.out.print(maze[r][c]);
            }
            System.out.println();
        }
    }

    // printall method
    public void printAll() {
        System.out.println("dimension: " + r + "x" + c);
        start.print();
        end.print();
        print();
    }

    // findpath method
    public void findPath(Point start, Point end) {
        if(solved) return;
        int col = start.getX();
        int row = start.getY();

        if(col < 0 || col >= c || row < 0 || row >= r || maze[row][col] != '.') return;

        maze[row][col] = alphabet.charAt(count++ % 26);
        if(start.isEqual(end)) {
            solved = true;
            print();
            return;
        }
        // not find yet => need to solve
        findPath(new Point(col, row+1), end);
        findPath(new Point(col+1, row), end);
        findPath(new Point(col, row-1), end);
        findPath(new Point(col-1, row), end);
        maze[row][col] = '.';
        count = (count+25) % 26;
    }

    public void find() {
        findPath(start, end);
        if(!solved) System.out.println("NO PATH EXISTS");
        System.out.println();
    }
}