package ru.msu.algo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BoardTest {
    @Test
    public void test() {
        Board a1 = new BoardImpl(2, new int[][]{{1, 2}, {3, 4}});
        Board a2 = new BoardImpl(2, new int[][]{{1, 2}, {3, 4}});
        Assertions.assertEquals(a1, a2);
    }

    @Test
    public void testNextUp() {
        Board prev = new BoardImpl(2, new int[][]{{0, 1}, {2, 3}});
        Board next = prev.next(-1, 0);
        Board expected = new BoardImpl(2, new int[][]{{0, 3}, {2, 1}});
        Assertions.assertEquals(expected, next);
    }

    @Test
    public void testNextLeft() {
        Board prev = new BoardImpl(2, new int[][]{{0, 1}, {2, 3}});
        Board next = prev.next(0, -1);
        Board expected = new BoardImpl(2, new int[][]{{0, 1}, {3, 2}});
        Assertions.assertEquals(expected, next);
    }

    @Test
    public void testNotNextLeft() {
        Board prev = new BoardImpl(2, new int[][]{{0, 1}, {2, 3}});
        Board next = prev.next(0, -1);
        Board expected = new BoardImpl(2, new int[][]{{0, 1}, {2, 3}});
        Assertions.assertNotEquals(expected, next);
    }
}
