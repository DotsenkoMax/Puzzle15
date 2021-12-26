package ru.msu.algo;

import java.util.*;

public class BoardImpl implements Board {
    int n;
    int emptyNum;
    int coordEmptyNum;
    int[] arr;
    static int[][] dDist = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};


    BoardImpl(int n, int coordEmptyNum, int[] arr) {
        this.n = n;
        this.emptyNum = n * n - 1;
        this.coordEmptyNum = coordEmptyNum;
        this.arr = arr;
    }

    protected BoardImpl(int n, int[][] arr) {
        this.arr = new int[n * n];
        this.emptyNum = n * n - 1;
        for (int i = 0; i < n * n; i++) {
            this.arr[i] = arr[i / n][i % n];
            if (this.arr[i] == emptyNum) {
                this.coordEmptyNum = i;
            }
        }
        this.n = n;
    }

    @Override
    public int manhattanDistance() {
        int sm = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i * n + j == emptyNum) continue;
                int idx = arr[i * n + j] / n;
                int jdx = arr[i * n + j] % n;
                sm += Math.abs(idx - i) + Math.abs(jdx - j);
            }
        }
        return sm;
    }

    @Override
    public int getSize() {
        return n;
    }

    @Override
    public Board next(int dx, int dy) {
        int i = (coordEmptyNum / n) + dx, j = (coordEmptyNum % n) + dy;
        if (i >= 0 && i < n && j >= 0 && j < n) {
            int[] copyTmp = new int[n * n];
            System.arraycopy(arr, 0, copyTmp, 0, arr.length);
            int tmp = copyTmp[i * n + j];
            copyTmp[i * n + j] = arr[coordEmptyNum];
            copyTmp[coordEmptyNum] = tmp;
            return new BoardImpl(n, i * n + j, copyTmp);
        }
        return null;
    }

    @Override
    public List<Board> getSons() {
        LinkedList<Board> boards = new LinkedList<>();
        for (int[] ints : dDist) {
            Board nextBoard = next(ints[0], ints[1]);
            if (nextBoard != null) {
                boards.add(nextBoard);
            }
        }
        return boards;
    }

    @Override
    public Board generateRandomSteps(int cntSteps) {
        Random random = new Random();
        Board now = this;
        for (int i = 0; i < cntSteps; i++) {
            int[] vec = dDist[random.nextInt(dDist.length)];
            Board next = now.next(vec[0], vec[1]);
            if (next != null) {
                now = next;
            }
        }
        return now;
    }

    @Override
    public String toString() {
        int numSpaces = String.valueOf(n * n).length();
        String spaces;
        {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < numSpaces; i++) {
                builder.append(' ');
            }
            spaces = builder.toString();
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i * n + j] != emptyNum) {
                    builder.append(String.format("%s%s", arr[i * n + j], spaces.substring(0, spaces.length() - String.valueOf(arr[i * n + j]).length() + 1)));
                } else {
                    builder.append(String.format("X%s", spaces));
                }
            }
            if (i != n - 1) {
                builder.append("\n");
            }
        }
        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        BoardImpl board = (BoardImpl) o;
        return Arrays.equals(arr, board.arr);
    }
}
