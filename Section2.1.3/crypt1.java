/*
ID: whynick1
LANG: JAVA
PROG: crypt1
TASK: Write a program that will find all solutions to the cryptarithm 
      above for any subset of supplied non-zero single-digits.
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


class crypt1
{
    private static boolean[] table = new boolean[10];
    public static void main(String args[]) 
    {
        try{
            BufferedReader br = new BufferedReader(new FileReader("crypt1.in"));
            Scanner sc = new Scanner(br);
            BufferedWriter bw = new BufferedWriter(new FileWriter("crypt1.out"));
            PrintWriter pw = new PrintWriter(bw);
            //start read input file
            int size = sc.nextInt();
            for (int i = 0; i < 10; i++)
                table[i] = false;
            //store the available nums in table
            //with limited possibility, use a boolean table to judge if exist
            //is much faster than compare each of values
            for (int i = 0; i < size; i++)
            {
                table[sc.nextInt()] = true;
            }
            //start count the valid answers
            int soluNum = 0;
            for (int i = 111; i <= 999; i++)
            {
                if (!judge(i))
                    continue;
                for (int j = 11; j <= 99; j++)
                {
                    if (!judge(j) || !judge(i * (j % 10)) || !judge(i * (j / 10)) || !judge2((i * (j / 10)) * 10 + (i * (j % 10))))
                        continue;
                    else

                        soluNum++;  
                }
            }
            pw.println(soluNum);
            sc.close();
            pw.close();
        } catch (IOException e){
            System.out.println(e);
        }
    }
    
    public static boolean judge(int num)
    {
        int count = 0;
        while (num > 0)
        {
            if (!table[num % 10])
                return false;
            num /= 10;
            count++;
        }
        if (count <= 3)
            return true;
        else
            return false;
    }
    
    public static boolean judge2(int num)
    {
        int count = 0;
        while (num > 0)
        {
            if (!table[num % 10])
                return false;
            num /= 10;
            count++;
        }
        if (count <= 4)
            return true;
        else
            return false;
    }
}












