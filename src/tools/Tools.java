/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.util.Random;

public class Tools {

    private Tools() {
    }

    public static Tools getInstance() {
        return new Tools();
    }

    public long fastMod(long b, int e, long m) {

        String binary = Integer.toBinaryString(e);
        char[] binArr = binary.toCharArray();
        int i = binArr.length - 1;
        long x = 1;

        while (i > -1) {

            if ((binArr[i]) == '1') {
                x = (x * b) % m;
            }

            b = (b * b) % m;
            i--;
        }
        return x;
    }

    public boolean millerRabin(int n) {
        if (n == 1) {
            return false;
        }
        if (n == 0) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }
        int r = 0, a, d = n - 1, i;
        long x;
        Random ran = new Random();

        while (true) {
            d = d / 2;
            r++;
            if (d % 2 == 1) {
                break;
            }
        }
        for (i = 0; i <= 3; i++) {
            a = ran.nextInt((n - 1) - 2) + 2;
            System.out.println(a);
            x = fastMod(a, d, n);
            if (x == 1 || x == n - 1) {
                return true;
            } else {
                while (d != n - 1) {
                    x = (x * x) % n;
                    d = d * 2;

                    if (x == 1) {
                        return false;
                    }
                    if (x == n - 1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public int euclidean(int a, int b) {

        if (a == 0 && b != 0) {
            return b;
        }

        if (b == 0 && a != 0) {
            return a;
        } else {
            a = euclidean(b, (a % b));
            return a;

        }
    }

    public int mulInverse(int n, int m) {
        int i, r;
        for (i = 1; i < m; i++) {
            if ((i * n) % m == 1) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] arg) {
        int i;
        Tools test = Tools.getInstance();
        i = test.mulInverse(7, 26);
        System.out.println(i);
    }
}
