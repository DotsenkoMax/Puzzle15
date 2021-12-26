package ru.msu.algo;

import java.util.List;

public interface Board{
    int manhattanDistance();
    int getSize();
    List<Board> getSons();
    Board generateRandomSteps(int cntSteps);
    Board next(int left, int right);
}
