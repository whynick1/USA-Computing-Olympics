/*
ID: whynick
LANG: JAVA
TASK: ariprog
Write a program that finds all arithmetic progressions of length n in the set S of bisquares.
The set of bisquares is defined as the set of all integers of the form p2 + q2 (where p and q are non-negative integers).
*/

import java.io.*;
import java.util.*;

public class ariprog {
    static int[] squareTable;
    static boolean[] bisquares;
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new FileReader("ariprog.in"));
        Scanner sc = new Scanner(br);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("ariprog.out")));
        //N = sequence length
        int N = sc.nextInt();
        //an upper bound to limit with 0 <= p,q <= M.
        int elememtLenLimit = sc.nextInt();
        //print None flag
        boolean none = true;
        
        // generate bisquares into a boolean array
        // loop times: 251 * 252 /2 = 31626
        int MM2 = elememtLenLimit*elememtLenLimit*2;
        boolean[] bisquares1 = new boolean[MM2+1];
        for(int p = 0; p <= elememtLenLimit; p++)
            for(int q = p; q <= elememtLenLimit; q++)
                bisquares1[p * p + q * q] = true;
        bisquares = bisquares1;
                    
        //use a square table to speed up
        int[] squareTable1 = new int[elememtLenLimit + 1];
        for (int i = 0; i < elememtLenLimit + 1; i++)
        {
            squareTable1[i] = i * i;
        }
        squareTable = squareTable1;
        //diff is positive
        for (int diff = 1; ; diff++)
        {
            //startNum >= 0;
            int startNum = 0;
            for ( ; ; startNum++)
            {
                if ((startNum + (N - 1) * diff) > (elememtLenLimit * elememtLenLimit)<<1)
                {
                    break;//when start from startNum is outOfBound, means start cannot be bigger, return to first for loop
                }
                
                //checkBisquare will check and if correct, print to output file 
                if (checkBisquare(elememtLenLimit, N, startNum, diff))
                {
                    none = false;
                    pw.println(startNum + " " + diff);
//                  System.out.println(startNum + " " + diff);
                }
            }
            if (startNum == 0)
            {
                break;//when start from 0 is outOfBound, means diff is too big, jump out of cycle
            }
        }
        if (none)
            pw.println("NONE");
        exit(sc, pw);
    }
    
    private static boolean checkBisquare(int elementLenLimit, int N, int startNum, int diff)
    {
        //Now start to check consecutive N number, if all are bisquares, than find one group!
        int i = 0;
        boolean pass = false;
        for ( ; i < N; i++)
        {
            int num = startNum + diff * i;
//          if (num == squareTable[elem1] + squareTable[elem2])//means this number has passed bisquare check
            if (!bisquares[num])
            {
                return false;
            }
        }
        return true;
    }

    private static void exit(Scanner in, Writer out) throws IOException {
        in.close();
        out.close();
        System.exit(0);
    }
}