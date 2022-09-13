import java.util.Scanner;

//=================================================
// Kien Trung Pham
// Maze path finding
// Due Date 9/12/2022
//
// Maze class to read input and find path in maze
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
        initialize();
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
        start = null;
        end = null;
    }

    // read method
    public void read(Scanner sc) {
        r = sc.nextInt();
        c = sc.nextInt();
        maze = new char[r][c];

        start = Point.read(sc);
        end = Point.read(sc);
        sc.nextLine();

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
            return;
        }
        // not find yet => need to solve
        findPath(new Point(col, row+1), end);
        findPath(new Point(col+1, row), end);
        findPath(new Point(col, row-1), end);
        findPath(new Point(col-1, row), end);

        if(!solved){
            maze[row][col] = '.';
            count = (count+25) % 26;
        }
    }

    public void findPath() {
        findPath(start, end);
    }
    public void printResult() {
        if(!solved) System.out.println("NO PATH EXISTS");
        else print();
        System.out.println();
    }
}