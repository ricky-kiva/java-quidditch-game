package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

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

            printResult(home, away);

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

    public static void startGame() throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(PLAYS_PATH);
        Scanner scan = new Scanner(fis);
        while(scan.hasNextLine()) {
            System.out.println("\n" + game.simulate(scan.nextLine()));
            waitSec(2);
        }
        scan.close();
    }

    public static void printResult(Team home, Team away) {
        int scoreHome = game.getScore(game.getTeam(home.getHouse()));
        int scoreAway = game.getScore(game.getTeam(away.getHouse()));
        System.out.println("\n" + home.getHouse() + ": " + scoreHome);
        System.out.println(away.getHouse() + ": " + scoreAway);
        if (scoreHome > scoreAway) {
            System.out.println("\n> " + home.getHouse() + " WINS !!!\n");
        } else {
            System.out.println("\n> " + away.getHouse() + " WINS !!!\n");
        }
    }

    /**
     * Function name: wait
     * @param sec
     * 
     * Inside the function:
     *  1. Make the code sleep for X seconds.
     */

    public static void waitSec(int sec) {
        TimeUnit time = TimeUnit.SECONDS;
        try {
            time.sleep(sec);
        } catch(InterruptedException e) {
            System.out.println(e);
        }
        
    }


  }
