package ru.msu.algo;


import java.util.Arrays;

public class Hash {
//    public static PolynomialHasher polynomialHasher1 = new PolynomialHasher(1000000123, 1297);
//    Long hash1;
    int[] arr;

    Hash(Board board) {
        arr = ((BoardImpl) board).arr;
 //       hash1 = polynomialHasher1.getHash(((BoardImpl) board).arr);
    }

    @Override
    public boolean equals(Object o) {
        Hash hash = (Hash) o;
        return Arrays.equals(arr, hash.arr);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(arr);
 //       return hash1.intValue();
    }
}
