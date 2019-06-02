package com.codeforces.ritesh.Codeforces;

import java.util.Scanner;

public class CF543A {

    public static long arrangemets(int n, int m, long b, long mod, long[] arr, int p) {
        if (n <= 0) return 0;
        if (m == 0) return 1;
        long sum=0;
        for (int l=0; l*arr[p] <= b && l<=m;l++) {
            sum += (arrangemets(n-1, m-l, b-(l*arr[p]), mod, arr, p+1) % mod);
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,m,b;
        long mod;
        n = sc.nextInt();
        m = sc.nextInt();
        b = sc.nextInt();
        mod = sc.nextLong();
        long[] bugs = new long[n];
        for (int i=0;i<n;i++) {
            bugs[i] = sc.nextLong();
        }
        System.out.println(arrangemets(n,m,b,mod,bugs,0));
    }

}
