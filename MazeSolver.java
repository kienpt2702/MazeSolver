//=================================================
// Kien Trung Pham
// Maze path finding
// Due Date 9/12/2022
//
// Maze solver class to read total problems and make calls to Maze class to find path
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