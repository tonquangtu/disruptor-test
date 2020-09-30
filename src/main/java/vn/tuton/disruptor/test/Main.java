package vn.tuton.disruptor.test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.function.DoubleToIntFunction;

public class Main {
    public static void main(String[] args) {
        double x = 3.0;
        int n = 8;
        double res = powWithoutRecursion(x, n);
        double expect = Math.pow(x, n);
        System.out.println(res);
        System.out.println(expect);
        System.out.println((int)Math.ceil(Math.pow(1000, 1/3.0)));
        System.out.println((int)Math.ceil(Math.pow(10, 1/3.0)));
        int loop = (int)Math.ceil(Math.pow(n, 1/3.0));
//        int loop = (int)Math.ceil(Math.pow(10, 1/3.0)) + 1;
        int [] a = new int[3];
        System.out.println(Arrays.toString(a));
        String s;

        testAutoBox();

    }

    static double powWithoutRecursion(double x, int n) {
        double res = 1.0;
        double temp = x;
        while (n > 0) {
            if (n % 2 != 0) {
                res = res * temp;
            }
            temp = temp * temp;
            n = n / 2;
        }
        return res;
    }

    static void testAutoBox() {
        Integer i1 = 120;
        Integer i2 = 120;
        System.out.println(i1.equals(i2));

        Integer i3 = Integer.valueOf(145);
        Integer i4 = Integer.valueOf(145);
        System.out.println(i3 == i4);

        Integer i5 = Integer.valueOf(120);
        Integer i6 = Integer.valueOf(120);
        System.out.println(i5 == i6);

        Integer i7 = 145;
        Integer i8 = 145;
        System.out.println(i7 == i8);

        Integer i9 = 120;
        Integer i10 = 120;
        System.out.println(i9 == i10);

        Integer i11 = new Integer(145);
        Integer i12 = new Integer(145);
        int i13 = i11;
        int i14 = i12;
        System.out.println(i13 == i14);

        LinkedList<Integer> b = new LinkedList<>();
        LinkedList<Integer> a = new LinkedList<>(b.subList(1, 2));
        String s;
        Queue<Integer> queue = new ArrayDeque<>();
     }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
