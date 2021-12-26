package ru.msu.algo;

import java.util.HashMap;

public class BoardFactory {
    HashMap<Long, Board> container = new HashMap<>();

    Board generateInitial(int n) {
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = i * n + j;
            }
        }
        Board initialBoard = new BoardImpl(n, arr);
        container.put((long) initialBoard.hashCode(), initialBoard);
        return initialBoard;
    }

}
