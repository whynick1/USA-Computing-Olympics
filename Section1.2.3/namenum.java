/*
ID: whynick1
LANG: JAVA
PROG: namenum
TASK: Write a program that is given the brand number of a cow and 
      prints all the valid names that can be generated from that brand
      number or ``NONE'' if there are no valid names. Serial numbers 
      can be as many as a dozen digits long.
*/
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

class namenum {        
        public static int CNT = 0;

        public static void main(String[] args) throws IOException {
            Scanner sc = new Scanner(new File("namenum.in"));
            PrintWriter pw = new PrintWriter(new File("namenum.out"));
            Scanner sc2 = new Scanner(new File("dict.txt"));
            
            char[][] keypad = new char[][] {
                    {},
                    {},
                    {'A','B','C'},
                    {'D','E','F'},
                    {'G','H','I'},
                    {'J','K','L'},
                    {'M','N','O'},
                    {'P','R','S'},
                    {'T','U','V'},
                    {'W','X','Y'}
            };
            //dictionary here is actually much longer
            String[] dict = new String[5000];
            int i = 0;
            while (sc2.hasNext())
            {
                dict[i++] = sc2.next();
            }
        
        String digits = sc.next();
        //here is the key method
        build(0, digits, new StringBuilder(), keypad, dict, pw);
        if (CNT == 0) pw.println("NONE");
        pw.close();
    }

    private static void build(int index, String input, StringBuilder sb, char[][] keypad, String[] dict, PrintWriter pw) {
        //start from index 0
        if (sb.length() != input.length()) {
            int key = Integer.parseInt(input.charAt(index)+"");
            //this for loop is tricky, but very smart!
            for(int i=0; i<keypad[key].length; i++) {
                build(index+1, input, new StringBuilder(sb).append(keypad[key][i]), keypad, dict, pw);
            }
        } 
        //when the sb.length == input.length, means successful build a String
        else {
            String target = sb.toString();
            if (Arrays.binarySearch(dict, target) > 0) {
                CNT++;
                pw.println(sb.toString());
            }
        }
    }
}
        








