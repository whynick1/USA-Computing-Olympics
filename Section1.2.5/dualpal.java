
/*
ID: whynick1
LANG: JAVA
PROG: dualpal
TASK: Write a program that reads two numbers (expressed in base 10):
    N (1 <= N <= 15)
    S (0 < S < 10000)
    and then finds and prints (in base 10) the first N numbers strictly greater than S
    that are palindromic when written in two or more number bases (2 <= base <= 10).
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

class dualpal
{
    public static void main(String args[]) 
    {
        try{
            BufferedReader br = new BufferedReader(new FileReader("dualpal.in"));
            Scanner sc = new Scanner(br);
            BufferedWriter bw = new BufferedWriter(new FileWriter("dualpal.out"));
            PrintWriter pw = new PrintWriter(bw);
            //read input file
            int printN = sc.nextInt();
            int startFromS = sc.nextInt() + 1;
            int currentN = 0;
            
            while (currentN < printN)
            {
                if (findPalindrome(startFromS) == true)
                {
                    currentN++;
                    pw.println(startFromS);
                }
                startFromS++;
            }
            sc.close();
            pw.close();

        } catch (IOException e) {
            System.out.println (e);
            System.out.println ("Could not find file \"palsquare.in\"");
        }
    }
    
    public static boolean findPalindrome(int num)
    {
        int base = 2;
        int countDulPalindrome = 0;
        while (base <= 10)
        {
            int number = num;
            StringBuilder sb = new StringBuilder();
            while (number >= base)
            {
                int remainder = number % base;
                sb.append(remainder);
                number /= base;
            }
            sb.append(number);
            if (checkPalindorme(sb.toString()) == true)
            {
                if (++countDulPalindrome >= 2)
                {
                    return true;
                }
            }
            base++;
        }
        return false;
    }
    
    public static boolean checkPalindorme(String str)
    {
        for (int i = 0; i < str.length() / 2; i++)
        {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i))
            {
                return false;
            }
                
        }
        return true;
    }
}












