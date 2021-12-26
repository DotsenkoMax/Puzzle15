package ru.msu.algo;

import java.util.List;

public interface Game {
    Board shuffle();

    List<Board> play();
    Board2PQAdapter playWithSqueeze();

    int getMoves();
}
