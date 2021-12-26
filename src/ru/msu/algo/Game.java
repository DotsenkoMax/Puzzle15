package ru.msu.algo;

import java.util.List;

public interface Game {
    Board shuffle();

    List<Board> play() throws IllegalArgumentException;

    Board2PQAdapter playWithSqueeze() throws IllegalArgumentException;

    int getMoves();
}
