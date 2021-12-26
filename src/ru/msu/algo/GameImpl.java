package ru.msu.algo;

import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class GameImpl implements Game {
    int n;
    BoardFactory factory = new BoardFactory();
    HashSet<Hash> smartHash = new HashSet<>();
    Board initialBoard;
    int a, b;
    int moves;

    GameImpl(int n, int a, int b) {
        this.n = n;
        this.a = a;
        this.b = b;
        moves = 0;
    }

    @Override
    public Board shuffle() {
        initialBoard = factory.generateInitial(n).generateRandomSteps((int) 1e5);
        return initialBoard;
    }

    @Override
    public List<Board> play() throws IllegalArgumentException {
        Board2PQAdapter answer = playWithSqueeze();
        if (answer != null) {
            return answer.getAllWay2Initial();
        }
        return null;
    }

    @Override
    public Board2PQAdapter playWithSqueeze() throws IllegalArgumentException {
        int boundary = 100_000_000;
        PriorityQueue<Board2PQAdapter> pq = new PriorityQueue<>(Board2PQAdapter::compareTo);
        pq.add(new Board2PQAdapter(initialBoard, 0, a, b));
        int idx = 0;
        while (!pq.isEmpty()) {
            Board2PQAdapter now = pq.poll();

            if (idx == boundary) {
                throw new IllegalArgumentException();
            }

            if (now.currentBoard.manhattanDistance() == 0) {
                moves = now.moveNumber;
                return now;
            }
            for (Board son : now.currentBoard.getSons()) {
                Hash hash = new Hash(son);
                if (smartHash.contains(hash)) {
                    continue;
                }
                smartHash.add(hash);

                Board2PQAdapter next = new Board2PQAdapter(now, son, now.moveNumber + 1, a, b);
                if (son.manhattanDistance() == 0) {
                    moves = next.moveNumber;
                    return next;
                }
                pq.add(next);
            }
            idx += 1;
        }
        return null;
    }

    @Override
    public int getMoves() {
        return moves;
    }
}
