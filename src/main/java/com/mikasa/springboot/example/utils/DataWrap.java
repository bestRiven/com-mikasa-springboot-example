package com.mikasa.springboot.example.utils;

/**
 * Created by sherlock on 2016/11/7.
 */
public class DataWrap implements Comparable<DataWrap> {
    private int data;
    private String flag;
    public DataWrap(int data,String flag)
    {
        this.data = data;
        this.flag = flag;
    }
    //重写compareTo方法
    public int compareTo(DataWrap other)
    {
        return this.data > other.data ? 1 : (this.data == other.data ? 0 : -1);
    }
    public String toString()
    {
        return this.data + this.flag;
    }
}
