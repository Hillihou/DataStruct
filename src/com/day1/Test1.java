package com.day1;

import org.junit.Test;

import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Test1 {

    //矩阵压缩
    @Test
    public void test(){
        int[] arr[]=new int[10][10];
        arr[0][8]=2;
        arr[1][1]=1;
        arr[1][2]=1;
        arr[2][2]=2;
        arr[3][1]=2;
        arr[9][5]=1;
        /*
        * 1 1 1
        * 2 2 2
        * */
        int lines=0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j]!=0){
                    lines++;
                }
            }
        }
        System.out.println(lines);
//        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        int[][] save = new int[lines+1][3];
        save[0][0]=arr.length;
        save[0][1]=arr[0].length;
        save[0][2]=lines;
        int first=1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j]!=0){
                    save[first][0]= i;
                    save[first][1]= j;
                    save[first][2]= arr[i][j];
                    first++;
                }
            }
        }

        for (int i = 0; i < save.length; i++) {
            System.out.println(Arrays.toString(save[i])+"第"+(i+1)+"行");
        }
        System.out.println("*************************");

        int[][] pullout = new int[save[0][0]][save[0][1]];
        for (int i = 0; i < save.length; i++) {
                if (save[i][2]!=0 && i!=0)
                pullout[save[i][0]][save[i][1]]=save[i][2];
        }

        for (int i = 0; i < pullout.length; i++) {
            System.out.println(Arrays.toString(pullout[i]));
        }
    }


    /**
     * 压缩成文件
     * @throws Exception
     */
    @Test
    public void test1() throws  Exception{
        int[] arr[]=new int[10][10];
        arr[0][8]=2;
        arr[1][1]=1;
        arr[1][2]=1;
        arr[2][2]=2;
        arr[3][1]=2;
        arr[9][5]=1;
        /*
         * 1 1 1
         * 2 2 2
         * */
        FileWriter fileWriter = new FileWriter("save.txt");

        int lines=0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j]!=0){

                    lines++;
                }
            }
        }



        int[][] save = new int[lines+1][3];
        save[0][0]=arr.length;
        fileWriter.write(arr.length+",");
        save[0][1]=arr[0].length;
        fileWriter.write(arr[0].length+",");
        save[0][2]=lines;
        fileWriter.write(lines+"\n");
        int first=1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j]!=0){
                    save[first][0]= i;
                    fileWriter.write(i+",");
                    save[first][1]= j;
                    fileWriter.write(j+",");
                    save[first][2]= arr[i][j];
                    fileWriter.write(arr[i][j]+"\n");
                    first++;
                }
            }
        }



        for (int i = 0; i < save.length; i++) {
            System.out.println(Arrays.toString(save[i])+"第"+(i+1)+"行");
        }
        System.out.println("*************************");

        int[][] pullout = new int[save[0][0]][save[0][1]];
        for (int i = 0; i < save.length; i++) {
            if (save[i][2]!=0 && i!=0)
                pullout[save[i][0]][save[i][1]]=save[i][2];
        }

        for (int i = 0; i < pullout.length; i++) {
            System.out.println(Arrays.toString(pullout[i]));
        }
        fileWriter.close();
    }

    @Test
    public void test2(){
//        FileReader fileReader = new FileReader("save.txt");
        int[] ints = new int[10];
        for (int i = 0; i < ints.length; i++) {
            ints[i]=i+10;
        }

        Object o = Array.get(ints, 0);
        System.out.println(o);
    }

}
