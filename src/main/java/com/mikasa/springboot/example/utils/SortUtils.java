package com.mikasa.springboot.example.utils;

import java.util.Arrays;

import static org.codehaus.groovy.runtime.DefaultGroovyMethods.swap;

/**
 * Created by sherlock on 2016/11/7.
 */
public class SortUtils {

    /**
     * 冒泡排序
     * @param dw
     */
    public static void bubbleSort(DataWrap[] dw) {
        int n = dw.length;
        boolean flag;//设置标志位，若发生未交换的情况，说明已经有序，退出循环即可
        for (int i = n - 1; i > 0; i--) {
            flag = false;
            for (int j = 0; j < i; j++) {
                if (dw[j].compareTo(dw[j + 1]) > 0) {
                    swap(dw, j + 1, j);
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
            System.out.println("冒泡排序：" + Arrays.toString(dw));
        }
    }

    /**
     * 直接插入排序
     * @param dw
     * @param n
     */
    public static void directInsertSort(DataWrap[] dw, int n) {
        for (int i = 1; i < n; i++) {
            if (dw[i].compareTo(dw[i - 1]) < 0) {
                DataWrap temp = dw[i];
                int j;
                for (j = i - 1; j >= 0 && dw[j].compareTo(temp) > 0; j--) {
                    dw[j + 1] = dw[j];

                }
                dw[j + 1] = temp;
            }
        }
        System.out.println("直接插入排序：" + Arrays.toString(dw));
    }

    public static void insertDirectlySort(int a[]) {
        if (a == null) return;
        int len = a.length;
        try {
            for (int i = 0; i < len; i++) {
                for (int j = i + 1; j < len && j > 0; j--) {
                    if (a[j] < a[j - 1]) {
                        int temp = a[j];
                        a[j] = a[j - 1];
                        a[j - 1] = temp;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void shellSort(int data[]) {
        if (data == null) return;
        int j = 0;
        int temp = 0;
        int len = data.length / 2;
        for (int increment  = len; increment > 0; increment /= 2) {
            for (int i = increment; i < data.length; i++) {
                temp = data[i];
                for (j = i; j >= increment; j -= increment) {
                    if(temp < data[j - increment]){
                        data[j] = data[j - increment];
                    }else{
                        break;
                    }
                }
                data[j] = temp;
            }
        }
    }

    public static void main(String[] args){
        DataWrap d1 = new DataWrap(1,"一");
        DataWrap d2 = new DataWrap(2,"二");
        DataWrap d3 = new DataWrap(3,"三");
        DataWrap[] dw = new DataWrap[] {d1,d3,d2};
        bubbleSort(dw);
        directInsertSort(dw,3);
    }
}
