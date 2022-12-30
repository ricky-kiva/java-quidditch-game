package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

import main.models.Game;
import main.models.Team;

public class Main {

    static Game game;
    static final String TEAMS_PATH = "./main/teams.txt";
    static final String PLAYS_PATH = "./main/plays.txt";

    public static void main(String[] args) {

        try {

            String[][] data = getData();

            Team home = new Team(data[0][0], data[0][1], data[0][2], new String[] {data[0][3], data[0][4], data[0][5]});
            Team away = new Team(data[1][0], data[1][1], data[1][2], new String[] {data[1][3], data[1][4], data[1][5]});

            game = new Game(home, away);
            startGame();

        } catch (FileNotFoundException e) {

            System.out.println(e);

        }
        
    }

     public static String[][] getData() throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(TEAMS_PATH);
        Scanner scan = new Scanner(fis);
        String[][] arr = {scan.nextLine().split(","), scan.nextLine().split(",")};

        scan.close();
        return Arrays.copyOf(arr, arr.length);
     }


    /** Function name: startGame
     * 
     * Inside the function:
     *    1. Grabs each play from plays.txt and calls game.simulate(play);
     *    2. Prints the return from game.simulate(play)
     *        - println("\n" + <return> + "\n");
     */

    public static void startGame() throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(PLAYS_PATH);
        Scanner scan = new Scanner(fis);
        while(scan.hasNextLine()) {
            System.out.println("\n" + game.simulate(scan.nextLine()));
        }
        System.out.println();
        scan.close();
    }


    /** Function name: printResult()
     * 
     * Inside the function:
     *    1. Prints the final score: println("\nGRYFFINDOR: " + <gryffindor score> + " SLYTHERIN: " + <slytherin score>);
     *    2. Prints the winner: println("\n" + <winner team name> + " WINS!");
     *  
     */

    /**
     * Function name: wait
     * @param sec
     * 
     * Inside the function:
     *  1. Make the code sleep for X seconds.
     */


  }
