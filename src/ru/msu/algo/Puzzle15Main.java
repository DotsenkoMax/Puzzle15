package ru.msu.algo;

import java.util.List;
import java.util.Scanner;

public class Puzzle15Main {
    public static Scanner enter = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.print("Enter game dim: ");
            int n = enter.nextInt();
            Game game = new GameImpl(n, 1, 0);
            Board initialBoard = game.shuffle();
            System.out.println("Initial Board:");
            System.out.println(initialBoard);

            List<Board> boards = game.play();
            System.out.println("Game Steps:");
            for (Board each : boards) {
                System.out.println(each);
                System.out.println("-----------------------------------------------");
            }
        }
    }
}
