//=================================================
// YOUR NAME GOES HERE
// Which project is this?
// Due Date
//
// What is this file/module used for?
//=================================================

import java.util.ArrayList;
import java.util.Scanner;

class MazeSolver{
    
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();

        ArrayList<Maze> list = new ArrayList<>();
        for(int i = 0; i < total; i++) {
            Maze maze = new Maze();
            maze.read(sc);
            list.add(maze);
        }
        for(Maze maze: list) {
            maze.findPath();
            maze.printResult();
        }
    }
}