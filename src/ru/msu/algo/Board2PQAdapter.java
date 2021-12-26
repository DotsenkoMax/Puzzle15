package ru.msu.algo;

import java.util.LinkedList;
import java.util.List;

public class Board2PQAdapter {
    Board currentBoard;
    Board2PQAdapter previousBoard;
    int moveNumber;
    int a, b;

    public Board2PQAdapter(Board currentBoard, int moveNumber, int a, int b) {
        this(null, currentBoard, moveNumber, a, b);
    }

    public Board2PQAdapter(Board2PQAdapter previousBoard, Board currentBoard, int moveNumber, int a, int b) {
        this.previousBoard = previousBoard;
        this.currentBoard = currentBoard;
        this.moveNumber = moveNumber;
        this.a = a;
        this.b = b;
    }


    public int compareTo(Board2PQAdapter rhs) {
        int rightDist = rhs.currentBoard.manhattanDistance();
        int rightMove = rhs.moveNumber;
        int leftDist = currentBoard.manhattanDistance();
        int leftMove = moveNumber;
        return Integer.compare((this.a * leftDist + this.b * leftMove), (this.a * rightDist + this.b * rightMove));
    }

    public List<Board> getAllWay2Initial() {
        LinkedList<Board> boards = new LinkedList<>();
        Board initialBoard = currentBoard;
        boards.addFirst(initialBoard);
        Board2PQAdapter tmpAdapter = previousBoard;
        while (tmpAdapter != null) {
            initialBoard = tmpAdapter.currentBoard;
            tmpAdapter = tmpAdapter.previousBoard;
            boards.addFirst(initialBoard);
        }
        return boards;
    }
}
