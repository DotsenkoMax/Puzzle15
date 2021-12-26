package ru.msu.algo;

public class PolynomialHasher {
    int maxN = 100;
    long mod;
    int prime;
    long[] primeDegs = new long[maxN];

    PolynomialHasher(long mod, int prime) {
        this.mod = mod;
        this.prime = prime;
        primeDegs[0] = 1;
        for (int i = 1; i < primeDegs.length; i++) {
            primeDegs[i] = (primeDegs[i - 1] * prime) % mod;
        }
    }

    long getHash(int[] arr) {
        long hash = 0;
        for (int i = 0; i < arr.length; i++) {
            hash = (hash + ((arr[i] + 1) * primeDegs[i]) % mod) % mod;
        }
        return hash;
    }
}
