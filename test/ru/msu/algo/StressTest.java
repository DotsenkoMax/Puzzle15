package ru.msu.algo;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

public class StressTest {
    @Test
    public void testAll() {
        test(2, 1, 0, 1000, false);
        test(2, 1, 1, 1000, false);
        test(3, 1, 0, 1000, false);
        test(3, 1, 1, 1000, false);
        test(3, 1, 2, 1000, false);
        test(3, 1, 10, 1000, false);
        test(4, 1, 0, 1000, false);
    }

    @Test
    public void testTmp() {
        test(5, 1, 0, 10, true);
    }

    public void test(int n, int a, int b, int nTrials, boolean debugMode) {
        List<Integer> moves = new LinkedList<>();
        List<Long> time = new LinkedList<>();
        for (int i = 0; i < nTrials; i++) {
            Game game = new GameImpl(n, a, b);
            game.shuffle();
            long startTime = System.currentTimeMillis();
            game.playWithSqueeze();
            long deltaTime = System.currentTimeMillis() - startTime;
            time.add(deltaTime);
            moves.add(game.getMoves());
            if (debugMode) {
                //if (i % 10 == 1) {
                System.out.println(i);
                //}
            }
        }
        System.out.printf("Algo with n = %s, a = %s, b = %s\n", n, a, b);
        System.out.printf("Max moves: %s\n", moves.stream().max(Integer::compareTo).get());
        System.out.printf("Mean moves: %s\n", (double) moves.stream().reduce(0, Integer::sum) / moves.size());
        System.out.printf("Max time (secs): %s\n", (double) time.stream().max(Long::compareTo).get() / 1000.);
        System.out.printf("Mean time (secs): %s\n", (double) time.stream().reduce(0L, Long::sum) / time.size() / 1000.);
        System.out.println("--------------------------------------------------------------------");
    }
}
