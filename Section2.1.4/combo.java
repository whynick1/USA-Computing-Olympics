/*
ID: whynick1
LANG: JAVA
PROG: combo
TASK: Given Farmer John's combination and the master combination, 
      please determine the number of distinct settings for the dials that 
      will open the lock. Order matters, so the setting (1,2,3) is distinct from (3,2,1).
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class combo
{
    public static void main(String args[]) 
    {
        try{
            BufferedReader br = new BufferedReader(new FileReader("combo.in"));
            Scanner sc = new Scanner(br);
            BufferedWriter bw = new BufferedWriter(new FileWriter("combo.out"));
            PrintWriter pw = new PrintWriter(bw);
            //start read input file
            int maximum = sc.nextInt();
            int[] lock1 = new int[3];
            for (int i = 0; i < 3; i++)
            {
                lock1[i] = sc.nextInt();
            }
            int[] lock2 = new int[3];
            for (int i = 0; i < 3; i++)
            {
                lock2[i] = sc.nextInt();
            }
            int[] similarlock = new int[3];
            for (int i = 0; i < 3; i++)
            {
                similarlock[i] = howSimilar(lock1[i], lock2[i], maximum);
            }
            int codes = similarlock[0] * similarlock[1] * similarlock[2];
            System.out.println(codes);
            int maxKeys = Math.min(maximum, 5);
            pw.println(maxKeys * maxKeys * maxKeys * 2 - codes);// there are two key, so multiplied by 2
            System.out.println(maxKeys * maxKeys * maxKeys * 2 - codes);
            sc.close();
            pw.close();
        } catch (IOException e){
            System.out.println(e);
        }
    }
    
    public static int howSimilar(int lock1, int lock2, int max)
    {
        int overlap = 0; 
        int minDistance = -1;
        //the minimum distance between 2 numbers in a "necklace"
        minDistance = Math.min(Math.abs(lock1 - lock2), max - Math.abs(lock1 - lock2));
        if (minDistance >= 5)
            overlap = 0;
        else
            overlap = Math.min(5 - minDistance, max);
        System.out.println("overlap = " + overlap);
        return overlap;
    }
}







