import java.util.Scanner;

//=================================================
// Kien Trung Pham
// Maze path finding
// Due Date 9/12/2022
//
// Point class to represent point in the maze.
//=================================================
class Point{

    // data members
    int x;
    int y;

    // member functions

    // default constructor
    Point(){
        x = 0;
        y = 0;
    } 

    // overloaded constructor
    Point(int x_val, int y_val){
        x = x_val;
        y = y_val;
    }

    // copy constructor
    Point(Point other){
        x = other.x;
        y = other.y;
    }


    // getX method
    public int getX() {
        return x;
    }


    // getY method
    public int getY() {
        return y;
    }


    // setX method
    public void setX(int x) {
        this.x = x;
    }

    // setY method
    public void setY(int y) {
        this.y = y;
    }

    // isEqual method
    public boolean isEqual(Point other) {
        if(other == null) return false;
        return this.x == other.x && this.y == other.y;
    }

    // read method
    public static Point read(Scanner sc) {
        int x = sc.nextInt()-1;
        int y = sc.nextInt()-1;

        return new Point(x,y);
    }

    // print method
    public void print() {
        System.out.println("(" + x + ", " + y + ")");
    }
}