package com.codeforces.ritesh.Codeforces;

import java.util.Scanner;

/**
 7 3 2
 21 10 7 18 5 33 20
 */
public class CF467C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long[][] dp = new long[5000][5000];
        long sum=0, prev=0;
        int i,j;
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        long[] arr = new long[n];
        long[] cumsum = new long[n];
        for (i=0;i<n;i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
            if(i+1 >= m) {
                sum = cumsum[i] = sum - prev;
                dp[0][i] = Math.max(i>0?dp[0][i-1]:0, cumsum[i]);
                prev = arr[i-m+1];
            }
        }
        for (i=1;i<k;i++) {
            for (j=m*(i+1)-1;j<n;j++) {
                dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j-m] + cumsum[j]);
            }
        }
/*
        for (i=0;i<n;i++) {
            System.out.println(cumsum[i] + "\t" + dp[0][i]);
        }
*/
        System.out.println(dp[k-1][n-1]);
    }

}
