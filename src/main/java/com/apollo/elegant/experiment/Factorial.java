package com.apollo.elegant.experiment;

public class Factorial {
    public static long fact(long n) {
        long r = 1;
        for (long i = 1; i <= n; i++) {
            r = r * i;
        }
        String a = null;
        return r;
    }
}
