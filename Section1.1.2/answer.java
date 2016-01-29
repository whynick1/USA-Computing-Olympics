/*
ID: whynick1
LANG: JAVA
PROG: ride
TASK: Write a program which reads in the name of the comet and the name 
      of the group and figures out whether the final number is just the 
      product of all the letters in the name, where "A" is 1 and "Z" is 26. 
      For instance, the group "USACO" would be 21 * 19 * 1 * 3 * 15 = 17955. 
      If the group's number mod 47 is the same as the comet's number mod 47, 
      then you need to tell the group to get ready!
*/
package ride;

import java.io.*;
import java.util.*;

class ride {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("ride.in"));
        PrintWriter pw = new PrintWriter(new File("ride.out"));
        if (toNumber(sc.nextLine()) % 47 == toNumber(sc.nextLine()) % 47) {
            pw.println("GO");
        } else {
            pw.println("STAY");
        }
        pw.close();
    }

    public static int toNumber(String name) {
        int product = 1;
        for (int i = 0; i < name.length(); i++) {
            int charVal = (name.charAt(i) - 'A') + 1;
            product *= charVal;
        }
        return product;
    }
}